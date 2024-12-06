package com.beien.mutiltransaction;

import com.beien.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @author beien
 * @date 2023/3/14 16:31
 * Copyright© 2023 beien
 */
@Slf4j
public class MutiDSTransactionInterceptor{
    private static final ThreadLocal<Map<Connection,Boolean>>  conExeResult=ThreadLocal.withInitial(()->new HashMap<>());
    private static final ThreadLocal<List<DataSource>>  dataSourceUseList=ThreadLocal.withInitial(()->new ArrayList<>());
    private Invocation invocation;
    private BeanFactory beanFactory;
    private Map<String,MutilTransactional> methodMutilTransactionalMap;
    private  MutilTransactional mutilTransactional;
    public  MutiDSTransactionInterceptor(Invocation invocation,BeanFactory beanFactory){
        this.invocation=invocation;
        this.beanFactory=beanFactory;
        this.methodMutilTransactionalMap=invocation.getMethodMutilTransactionalMap();
        this.mutilTransactional = invocation.getMutilTransactional();
    }
    public Object interceptor() throws Throwable{
        boolean classTypeAnnation=true;
        invocation.getMethod();
        if(mutilTransactional==null){  //说明是方法加了注解
            MutilTransactional mutilTransactional = methodMutilTransactionalMap.get(MutiTransactionUtil.keyGenarate(invocation.getMethod()));
            if(mutilTransactional!=null){
                this.mutilTransactional =mutilTransactional;
                classTypeAnnation=false;
            }else {
                return  invocation.execute();
            }
        }
        if(classTypeAnnation) {
            String[] strings = mutilTransactional.ignoreMethod();
            String name = invocation.getMethod().getName();
            boolean ingore = Arrays.stream(strings).anyMatch(p -> p.equals(name));
            if (ingore) {
                return invocation.execute();
            }
            //判断method上是否标注了annotationclass注解。
            if (invocation.getMethod().isAnnotationPresent(IngnoreMethod.class)) {
                return invocation.execute();
            }
        }
        MutiTransactionUtil.enterMutlTransaction();
        String qualifier = mutilTransactional.dataBase();
        DataSource dataSource = BeanFactoryAnnotationUtils.qualifiedBeanOfType(beanFactory, DataSource.class, qualifier);
        if(dataSource==null){
            throw  new RuntimeException(qualifier+"数据源不在容器中----------------");
        }
        DynamicDataSourceContextHolder.setContextKey(qualifier);
        Map<Connection, Boolean> connectionBooleanMap = conExeResult.get();
        Connection connection=null;
        Object resource = TransactionSynchronizationManager.getResource(dataSource);
        if(resource!=null){
            connection=((ConnectionHolder)resource).getConnection();
        }else {
            connection = dataSource.getConnection();
            ConnectionHolder connectionHolder=new ConnectionHolder(connection);
            TransactionSynchronizationManager.bindResource(dataSource,connectionHolder);
            dataSourceUseList.get().add(dataSource);
        }

        connection.setReadOnly(mutilTransactional.readOnly());
        if(mutilTransactional.isolationLevel()!= IsolationLevel.TRANSACTION_DEFAULT) {
            connection.setTransactionIsolation(mutilTransactional.isolationLevel().getLevel());
        }
        connection.setAutoCommit(mutilTransactional.autoCommit());
        Object result = null;
        Boolean error=false;
        try {
            result = invocation.execute();
        } catch (Throwable throwable) {
            error=true;
            throwable.printStackTrace();
        }finally {
            MutiTransactionUtil.releaseMutlTransaction();
        }
        connectionBooleanMap.put(connection,error);

        //事务发起方法结束
        if(MutiTransactionUtil.isFirstEnterMethod()){
            try {
                boolean errorHappen = connectionBooleanMap.values().stream().anyMatch(p -> p == true);
                if (errorHappen) {
                    log.info("发生错误  全部回滚------------------");
                    connectionBooleanMap.keySet().forEach(con -> {
                        try {
                            con.rollback();
                            log.info("数据库连接：{} 已回滚",con);
                        } catch (SQLException e) {
                            throw new RuntimeException("数据库连接回滚错误！！");
                        }
                    });
                    log.info("全部回滚结束------------------");
                } else {
                    log.info("没有发生错误  全部提交------------------");
                    connectionBooleanMap.keySet().forEach(con -> {
                        try {
                            con.commit();
                            log.info("数据库连接：{} 已提交",con);
                        } catch (SQLException e) {
                            throw new RuntimeException("数据库连接提交错误！！");
                        }
                    });
                    log.info("全部提交结束------------------");
                }
            }finally {
                log.info("归还数据库连接------------------");
                conExeResult.get().keySet().forEach(con->{
                    try {
                        con.close();
                    } catch (SQLException e) {
                        log.info("数据库连接：{} 关闭错误",con);
                    }
                });
                log.info("归还数据库连接结束------------------");
                conExeResult.remove();
                MutiTransactionUtil.reset();
                dataSourceUseList.get().forEach(d->{
                    TransactionSynchronizationManager.unbindResource(d);
                });
                dataSourceUseList.remove();
            }
        }
        return result;
    }
}
