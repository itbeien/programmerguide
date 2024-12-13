package cn.itbeien.canal.util;


import cn.itbeien.canal.entity.SysUser;
import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Slf4j
@Component
public class CanalUtil {


    @Value("${canal-monitor-mysql.host}")
    String canalMonitorHost;

    @Value("${canal-monitor-mysql.port}")
    Integer canalMonitorPort;

    @Autowired
    private RedisClient redisClient;

    private final static int BATCH_SIZE = 10000;

    /**
     * 启动服务
     */
    // @Async("TaskPool")
    public void startMonitorSQL() {
        while (true) {
            CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(canalMonitorHost, canalMonitorPort), "0.104", "", "");
            int batchSize = 1000;
            int emptyCount = 0;
            try {
                connector.connect();
                connector.subscribe(".*\\..*");
                connector.rollback();
                int totalEmptyCount = 120;
                while (emptyCount < totalEmptyCount) {
                    Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
                    long batchId = message.getId();
                    int size = message.getEntries().size();
                    if (batchId == -1 || size == 0) {
                        emptyCount++;
                        log.info("empty count :{} " , emptyCount);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    } else {
                        emptyCount = 0;
                        printEntry(message.getEntries());
                    }

                    connector.ack(batchId); // 提交确认
                    // connector.rollback(batchId); // 处理失败, 回滚数据
                }

                log.info("empty too many times, exit");

            } catch (Exception e) {
                log.error("成功断开监测连接!尝试重连:{}",e);
            } finally {
                connector.disconnect();
                //防止频繁访问数据库链接: 线程睡眠 10秒
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    log.error("成功断开监测连接!尝试重连:{}",e);
                }
            }
        }
    }


    private  void printEntry(List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }

            CanalEntry.RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }

            CanalEntry.EventType eventType = rowChage.getEventType();
            System.out.println(String.format("================&gt; binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));

            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                //canal获取mysql数据库删除事件
                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {//canal获取mysql数据库新增事件
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    log.info("-------&gt; before");
                    printColumn(rowData.getBeforeColumnsList());
                    log.info("-------&gt; after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    private  void printColumn(List<CanalEntry.Column> columns) {
        SysUser sysUser = new SysUser();//用反射实现值的动态绑定
        for (CanalEntry.Column column : columns) { //一行数据库数据=一个对象
            log.info(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
            //获取字段名称和字段值,设置到实体类中
            if(column.getName().equalsIgnoreCase("id")){
                sysUser.setId(column.getValue());
            }else if(column.getName().equalsIgnoreCase("name")){
                sysUser.setName(column.getValue());
            }else if(column.getName().equalsIgnoreCase("age")){
                sysUser.setAge(Integer.valueOf(column.getValue()));
            }else if(column.getName().equalsIgnoreCase("email")){
                sysUser.setEmail(column.getValue());
            }
        }
        if(sysUser.getId()!=null && !"".equals(sysUser.getId())){
            String userJson = JSON.toJSONString(sysUser);
            redisClient.set(sysUser.getId(),userJson);//保存用户数据
        }
        log.info(sysUser.toString());
    }

}
