package com.beien;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 事务四大特性
 * ACID
 * 原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）、持久性（Duration），简称ACID
 * ① 原子性
 * 事务的原子性是指事务必须是一个原子的操作序列单元。事务中包含的各项操作在一次执行过程中，只允许出现两种状态之一，要么都成功，要么都失败
 *
 * 任何一项操作都会导致整个事务的失败，同时其它已经被执行的操作都将被撤销并回滚，只有所有的操作全部成功，整个事务才算是成功完成
 *
 * ② 一致性（Consistency）
 * 事务的一致性是指事务的执行不能破坏数据库数据的完整性和一致性，一个事务在执行之前和执行之后，数据库都必须处以一致性状态。
 *
 * 比如：如果从A账户转账到B账户，不可能因为A账户扣了钱，而B账户没有加钱
 *
 * ③ 隔离性
 * 事务的隔离性是指在并发环境中，并发的事务是互相隔离的，一个事务的执行不能被其它事务干扰。也就是说，不同的事务并发操作相同的数据时，每个事务都有各自完整的数据空间。
 *
 * 一个事务内部的操作及使用的数据对其它并发事务是隔离的，并发执行的各个事务是不能互相干扰的
 *
 * ④ 持久性（Duration）
 * 事务的持久性是指事务一旦提交后，数据库中的数据必须被永久的保存下来。即使服务器系统崩溃或服务器宕机等故障。只要数据库重新启动，那么一定能够将其恢复到事务成功结束后的状态
 *
 *
 *
 * Spring事务失效的8种场景
 * 1.标注错误的异常类型
 * @Tansactional注解中标注了错误的异常类型,则Spring事务的回滚会失效
 * Spring中默认回滚的事务异常类型为RuntimeException
 * 2.不正确的捕获异常
 * 3.方法的事务传播类型不支持事务
 * 4.未配置事务管理器
 * 5.同一类中的方法调用
 * 6.方法没有被public修饰
 * 7.事务方法未被Spring管理
 * 8.动态切换数据库时
 *
 * Spring 5种事务隔离级别
 *  1.ISOLATION_DEFAULT  默认事务隔离级别，数据库中默认是什么就是什么
 *  ISOLATION_DEFAULT隔离级别是Spring中PlatformTransactionManager默认的事务隔离级别。也就是说，将Spring的事务隔离级别设置为ISOLATION_DEFAULT时，Spring 不做事务隔离级别的处理，会直接使用数据库默认的事务隔离级别。
 *  2.ISOLATION_READ_UNCOMMITTED 读未提交
 *  ISOLATION_READ_UNCOMMITTED隔离级别是Spring中最低的隔离级别。当Spring 中的隔离级别设置为ISOLATION_READ_UNCOMMITTED时，事务A能够读取到事务B 未提交的数据。这种隔离级别下会产生脏读、不可重复读和幻读的问题。相当于MySQL中的未提交读隔离级别。
 *  3.ISOLATION_READ_COMMITTED 读已提交
 *  ISOLATION_READ_COMMITTED隔离级别能够保证事务A修改的数据提交之后才能被事务B读取，事务B不能读取事务A未提交的数据。在这种隔离级别下，虽然脏读的问题解决了，但是可能会产生不可重复读和幻读的问题。相当于MySQL中的已提交读隔离级别。
 *  4.ISOLATION_REPEATABLE_READ 可重复读
 *  ISOLATION_REPEATABLE_READ隔离级别能够保证不会产生脏读和不可重复读的问题，但是可能会产生幻读的问题。事务A第一次按照一定的查询条件从数据表中查询出数据后，事务B向同一个数据表中插入了符合事务A查询条件的数据，事务A再次从数据表
 *  中查询数据时，会将事务B插入的数据查询出来。相当于MySQL中的可重复读隔离级别。
 *  5.ISOLATION_SERIALIZABLE 串行化
 *  在ISOLATION_SERIALIZABLE隔离级别下，事务只能够按照特定的顺序执行，也就是多个事务之间只能够按照串行化的顺序执行。这是最可靠的隔离级别，然而这种可靠性付出了极大的代价，也就是牺牲了并发性，相当于MySQL中的串行化隔离级别。
 *
 *
 * Spring 7种事务传播机制
 * 1.支持当前事务的事务传播机制
 * 1.1 REQUIRED 默认机制
 * 1.2 REQUIRES_NEW
 * 1.3 SUPPORTS
 * 1.4 MANDATORY
 * 1.5 NOT_SUPPORTED
 * 1.6 NEVER
 * 1.7 NESTED
 * 2.不支持当前事务的事务传播机制
 *
 */
@SpringBootTest
class TransactionBeienApplicationTests {

    @Test
    void contextLoads() {
    }

}
