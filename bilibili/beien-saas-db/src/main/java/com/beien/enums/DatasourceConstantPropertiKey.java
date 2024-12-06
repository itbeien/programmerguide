package com.beien.enums;

/**
 * @author Ben
 * @date 2020/5/21 18:19
 * @Company:Mopon
 * @Copyright:Copyright(c)2019
 */
public enum DatasourceConstantPropertiKey implements ISysconfigKey {

    DATABASE_CONFIG_ENCRYPT_KEY("database.config.encrypt.key", "","数据库密码加密密钥"),

    MASTER_JDBC_DRIVERURL("master.jdbc.driverUrl","url","jdbc驱动url"),
    MASTER_JDBC_USER("master.jdbc.user","username","数据库用户名"),
    MASTER_JDBC_PASSWORD("master.jdbc.password","password","数据库密码"),
    MASTER_JDBC_DRIVERCLASS("master.jdbc.driverClass","driverClassName","驱动类"),
    MASTER_JDBC_INITIALSIZE("master.jdbc.initialSize","initialSize","启动程序时，在连接池中初始化多少个连接"),
    MASTER_JDBC_MAXACTIVE("master.jdbc.maxActive","maxActive","连接池中最多支持多少个活动会话"),
    MASTER_JDBC_MAXPOOLPREPAREDSTATEMENTPERCONNECTIONSIZE("master.jdbc.maxPoolPreparedStatementPerConnectionSize","maxPoolPreparedStatementPerConnectionSize","每个连接最多缓存多少个SQL"),
    MASTER_JDBC_MAXWAIT("master.jdbc.maxWait","maxWait","程序向连接池中请求连接时,超过maxWait的值后，认为本次请求失败"),
    MASTER_JDBC_MINEVICTABLEIDLETIMEMILLIS("master.jdbc.minEvictableIdleTimeMillis","minEvictableIdleTimeMillis","池中某个连接的空闲时长达到 N 毫秒后, 连接池在下次检查空闲连接时，将回收该连接,要小于防火墙超时设置"),
    MASTER_JDBC_MINIDLE("master.jdbc.minIdle","minIdle","回收空闲连接时，将保证至少有minIdle个连接"),
    MASTER_JDBC_POOLPREPAREDSTATEMENTS("master.jdbc.poolPreparedStatements","poolPreparedStatements","是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭"),
    MASTER_JDBC_TESTONBORROW("master.jdbc.testOnBorrow","testOnBorrow","程序申请连接时,进行连接有效性检查（低效，影响性能）"),
    MASTER_JDBC_TESTWHILEIDLE("master.jdbc.testWhileIdle","testWhileIdle","当程序请求连接，池在分配连接时，是否先检查该连接是否有效。(高效)"),
    MASTER_JDBC_TIMEBETWEENEVICTIONRUNSMILLIS("master.jdbc.timeBetweenEvictionRunsMillis","timeBetweenEvictionRunsMillis","检查空闲连接的频率，单位毫秒, 非正整数时表示不进行检查"),
    MASTER_JDBC_VALIDATIONQUERY("master.jdbc.validationQuery","validationQuery","检查池中的连接是否仍可用的 SQL 语句,druid会连接到数据库执行该SQL, 如果正常返回，则表示连接可用，否则表示连接不可用"),

    SLAVE_JDBC_DRIVERURL("slave.jdbc.driverUrl","url","jdbc驱动url"),
    SLAVE_JDBC_USER("slave.jdbc.user","username","数据库用户名"),
    SLAVE_JDBC_PASSWORD("slave.jdbc.password","password","数据库密码"),
    SLAVE_JDBC_DRIVERCLASS("slave.jdbc.driverClass","driverClassName","驱动类"),
    SLAVE_JDBC_INITIALSIZE("slave.jdbc.initialSize","initialSize","启动程序时，在连接池中初始化多少个连接"),
    SLAVE_JDBC_MAXACTIVE("slave.jdbc.maxActive","maxActive","连接池中最多支持多少个活动会话"),
    SLAVE_JDBC_MAXPOOLPREPAREDSTATEMENTPERCONNECTIONSIZE("slave.jdbc.maxPoolPreparedStatementPerConnectionSize","maxPoolPreparedStatementPerConnectionSize","每个连接最多缓存多少个SQL"),
    SLAVE_JDBC_MAXWAIT("slave.jdbc.maxWait","maxWait","程序向连接池中请求连接时,超过maxWait的值后，认为本次请求失败"),
    SLAVE_JDBC_MINEVICTABLEIDLETIMEMILLIS("slave.jdbc.minEvictableIdleTimeMillis","minEvictableIdleTimeMillis","池中某个连接的空闲时长达到 N 毫秒后, 连接池在下次检查空闲连接时，将回收该连接,要小于防火墙超时设置"),
    SLAVE_JDBC_MINIDLE("slave.jdbc.minIdle","minIdle","回收空闲连接时，将保证至少有minIdle个连接"),
    SLAVE_JDBC_POOLPREPAREDSTATEMENTS("slave.jdbc.poolPreparedStatements","poolPreparedStatements","是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭"),
    SLAVE_JDBC_TESTONBORROW("slave.jdbc.testOnBorrow","testOnBorrow","程序申请连接时,进行连接有效性检查（低效，影响性能）"),
    SLAVE_JDBC_TESTWHILEIDLE("slave.jdbc.testWhileIdle","testWhileIdle","当程序请求连接，池在分配连接时，是否先检查该连接是否有效。(高效)"),
    SLAVE_JDBC_TIMEBETWEENEVICTIONRUNSMILLIS("slave.jdbc.timeBetweenEvictionRunsMillis","timeBetweenEvictionRunsMillis","检查空闲连接的频率，单位毫秒, 非正整数时表示不进行检查"),
    SLAVE_JDBC_VALIDATIONQUERY("slave.jdbc.validationQuery","validationQuery","检查池中的连接是否仍可用的 SQL 语句,druid会连接到数据库执行该SQL, 如果正常返回，则表示连接可用，否则表示连接不可用"),
    DEFAULT_MASTER("defaultMaster","","主数据源标识"),
    DEFAULT_SLAVE("defaultSlave","","从数据源标识"),
    DATASOURCEFLAG("dynamic-db","","动态数据源前缀"),
    ;

    DatasourceConstantPropertiKey(String key, String dataSourceKey, String remark) {
        this.key = key;
        this.dataSourceKey = dataSourceKey;
        this.remark = remark;
    }

    private String key;

    private String dataSourceKey;

    private String remark;

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getRemark() {
        return this.remark;
    }

    public String getDataSourceKey() {
        return this.dataSourceKey;
    }
}
