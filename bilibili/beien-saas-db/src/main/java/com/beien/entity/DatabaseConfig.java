package com.beien.entity;

import java.io.Serializable;

public class DatabaseConfig implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.ALIAS_NAME
     *
     * @mbggenerated
     */
    private String aliasName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DB_MODEL
     *
     * @mbggenerated
     */
    private String dbModel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DB_TYPE
     *
     * @mbggenerated
     */
    private String dbType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DB_USERNAME
     *
     * @mbggenerated
     */
    private String dbUsername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DB_PASSWORD
     *
     * @mbggenerated
     */
    private String dbPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DRIVER_URL
     *
     * @mbggenerated
     */
    private String driverUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DB_IP
     *
     * @mbggenerated
     */
    private String dbIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DB_PORT
     *
     * @mbggenerated
     */
    private String dbPort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DB_NAME
     *
     * @mbggenerated
     */
    private String dbName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.DRIVER_CLASS_NAME
     *
     * @mbggenerated
     */
    private String driverClassName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.INITIAL_SIZE
     *
     * @mbggenerated
     */
    private Integer initialSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.MAX_ACTIVE
     *
     * @mbggenerated
     */
    private Integer maxActive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.MAX_POOL_PREPARED_STATEMENT_PER_CONNECTION_SIZE
     *
     * @mbggenerated
     */
    private Integer maxPoolPreparedStatementPerConnectionSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.MAX_WAIT
     *
     * @mbggenerated
     */
    private Integer maxWait;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.MIN_EVICTABLE_IDLE_TIME_MILLIS
     *
     * @mbggenerated
     */
    private Integer minEvictableIdleTimeMillis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.MIN_IDLE
     *
     * @mbggenerated
     */
    private Integer minIdle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.POOL_PREPARED_STATEMENTS
     *
     * @mbggenerated
     */
    private String poolPreparedStatements;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.TEST_ON_BORROW
     *
     * @mbggenerated
     */
    private String testOnBorrow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.TEST_ON_RETURN
     *
     * @mbggenerated
     */
    private String testOnReturn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.TEST_WHILE_IDLE
     *
     * @mbggenerated
     */
    private String testWhileIdle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.TIME_BETWEEN_EVICTION_RUNS_MILLIS
     *
     * @mbggenerated
     */
    private Integer timeBetweenEvictionRunsMillis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_database_config.VALIDATION_QUERY
     *
     * @mbggenerated
     */
    private String validationQuery;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_database_config
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.ID
     *
     * @return the value of sys_database_config.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.ID
     *
     * @param id the value for sys_database_config.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.ALIAS_NAME
     *
     * @return the value of sys_database_config.ALIAS_NAME
     *
     * @mbggenerated
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.ALIAS_NAME
     *
     * @param aliasName the value for sys_database_config.ALIAS_NAME
     *
     * @mbggenerated
     */
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DB_MODEL
     *
     * @return the value of sys_database_config.DB_MODEL
     *
     * @mbggenerated
     */
    public String getDbModel() {
        return dbModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DB_MODEL
     *
     * @param dbModel the value for sys_database_config.DB_MODEL
     *
     * @mbggenerated
     */
    public void setDbModel(String dbModel) {
        this.dbModel = dbModel == null ? null : dbModel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DB_TYPE
     *
     * @return the value of sys_database_config.DB_TYPE
     *
     * @mbggenerated
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DB_TYPE
     *
     * @param dbType the value for sys_database_config.DB_TYPE
     *
     * @mbggenerated
     */
    public void setDbType(String dbType) {
        this.dbType = dbType == null ? null : dbType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DB_USERNAME
     *
     * @return the value of sys_database_config.DB_USERNAME
     *
     * @mbggenerated
     */
    public String getDbUsername() {
        return dbUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DB_USERNAME
     *
     * @param dbUsername the value for sys_database_config.DB_USERNAME
     *
     * @mbggenerated
     */
    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername == null ? null : dbUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DB_PASSWORD
     *
     * @return the value of sys_database_config.DB_PASSWORD
     *
     * @mbggenerated
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DB_PASSWORD
     *
     * @param dbPassword the value for sys_database_config.DB_PASSWORD
     *
     * @mbggenerated
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword == null ? null : dbPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DRIVER_URL
     *
     * @return the value of sys_database_config.DRIVER_URL
     *
     * @mbggenerated
     */
    public String getDriverUrl() {
        return driverUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DRIVER_URL
     *
     * @param driverUrl the value for sys_database_config.DRIVER_URL
     *
     * @mbggenerated
     */
    public void setDriverUrl(String driverUrl) {
        this.driverUrl = driverUrl == null ? null : driverUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DB_IP
     *
     * @return the value of sys_database_config.DB_IP
     *
     * @mbggenerated
     */
    public String getDbIp() {
        return dbIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DB_IP
     *
     * @param dbIp the value for sys_database_config.DB_IP
     *
     * @mbggenerated
     */
    public void setDbIp(String dbIp) {
        this.dbIp = dbIp == null ? null : dbIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DB_PORT
     *
     * @return the value of sys_database_config.DB_PORT
     *
     * @mbggenerated
     */
    public String getDbPort() {
        return dbPort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DB_PORT
     *
     * @param dbPort the value for sys_database_config.DB_PORT
     *
     * @mbggenerated
     */
    public void setDbPort(String dbPort) {
        this.dbPort = dbPort == null ? null : dbPort.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DB_NAME
     *
     * @return the value of sys_database_config.DB_NAME
     *
     * @mbggenerated
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DB_NAME
     *
     * @param dbName the value for sys_database_config.DB_NAME
     *
     * @mbggenerated
     */
    public void setDbName(String dbName) {
        this.dbName = dbName == null ? null : dbName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.DRIVER_CLASS_NAME
     *
     * @return the value of sys_database_config.DRIVER_CLASS_NAME
     *
     * @mbggenerated
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.DRIVER_CLASS_NAME
     *
     * @param driverClassName the value for sys_database_config.DRIVER_CLASS_NAME
     *
     * @mbggenerated
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName == null ? null : driverClassName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.INITIAL_SIZE
     *
     * @return the value of sys_database_config.INITIAL_SIZE
     *
     * @mbggenerated
     */
    public Integer getInitialSize() {
        return initialSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.INITIAL_SIZE
     *
     * @param initialSize the value for sys_database_config.INITIAL_SIZE
     *
     * @mbggenerated
     */
    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.MAX_ACTIVE
     *
     * @return the value of sys_database_config.MAX_ACTIVE
     *
     * @mbggenerated
     */
    public Integer getMaxActive() {
        return maxActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.MAX_ACTIVE
     *
     * @param maxActive the value for sys_database_config.MAX_ACTIVE
     *
     * @mbggenerated
     */
    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.MAX_POOL_PREPARED_STATEMENT_PER_CONNECTION_SIZE
     *
     * @return the value of sys_database_config.MAX_POOL_PREPARED_STATEMENT_PER_CONNECTION_SIZE
     *
     * @mbggenerated
     */
    public Integer getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.MAX_POOL_PREPARED_STATEMENT_PER_CONNECTION_SIZE
     *
     * @param maxPoolPreparedStatementPerConnectionSize the value for sys_database_config.MAX_POOL_PREPARED_STATEMENT_PER_CONNECTION_SIZE
     *
     * @mbggenerated
     */
    public void setMaxPoolPreparedStatementPerConnectionSize(Integer maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.MAX_WAIT
     *
     * @return the value of sys_database_config.MAX_WAIT
     *
     * @mbggenerated
     */
    public Integer getMaxWait() {
        return maxWait;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.MAX_WAIT
     *
     * @param maxWait the value for sys_database_config.MAX_WAIT
     *
     * @mbggenerated
     */
    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.MIN_EVICTABLE_IDLE_TIME_MILLIS
     *
     * @return the value of sys_database_config.MIN_EVICTABLE_IDLE_TIME_MILLIS
     *
     * @mbggenerated
     */
    public Integer getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.MIN_EVICTABLE_IDLE_TIME_MILLIS
     *
     * @param minEvictableIdleTimeMillis the value for sys_database_config.MIN_EVICTABLE_IDLE_TIME_MILLIS
     *
     * @mbggenerated
     */
    public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.MIN_IDLE
     *
     * @return the value of sys_database_config.MIN_IDLE
     *
     * @mbggenerated
     */
    public Integer getMinIdle() {
        return minIdle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.MIN_IDLE
     *
     * @param minIdle the value for sys_database_config.MIN_IDLE
     *
     * @mbggenerated
     */
    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.POOL_PREPARED_STATEMENTS
     *
     * @return the value of sys_database_config.POOL_PREPARED_STATEMENTS
     *
     * @mbggenerated
     */
    public String getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.POOL_PREPARED_STATEMENTS
     *
     * @param poolPreparedStatements the value for sys_database_config.POOL_PREPARED_STATEMENTS
     *
     * @mbggenerated
     */
    public void setPoolPreparedStatements(String poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements == null ? null : poolPreparedStatements.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.TEST_ON_BORROW
     *
     * @return the value of sys_database_config.TEST_ON_BORROW
     *
     * @mbggenerated
     */
    public String getTestOnBorrow() {
        return testOnBorrow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.TEST_ON_BORROW
     *
     * @param testOnBorrow the value for sys_database_config.TEST_ON_BORROW
     *
     * @mbggenerated
     */
    public void setTestOnBorrow(String testOnBorrow) {
        this.testOnBorrow = testOnBorrow == null ? null : testOnBorrow.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.TEST_ON_RETURN
     *
     * @return the value of sys_database_config.TEST_ON_RETURN
     *
     * @mbggenerated
     */
    public String getTestOnReturn() {
        return testOnReturn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.TEST_ON_RETURN
     *
     * @param testOnReturn the value for sys_database_config.TEST_ON_RETURN
     *
     * @mbggenerated
     */
    public void setTestOnReturn(String testOnReturn) {
        this.testOnReturn = testOnReturn == null ? null : testOnReturn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.TEST_WHILE_IDLE
     *
     * @return the value of sys_database_config.TEST_WHILE_IDLE
     *
     * @mbggenerated
     */
    public String getTestWhileIdle() {
        return testWhileIdle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.TEST_WHILE_IDLE
     *
     * @param testWhileIdle the value for sys_database_config.TEST_WHILE_IDLE
     *
     * @mbggenerated
     */
    public void setTestWhileIdle(String testWhileIdle) {
        this.testWhileIdle = testWhileIdle == null ? null : testWhileIdle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.TIME_BETWEEN_EVICTION_RUNS_MILLIS
     *
     * @return the value of sys_database_config.TIME_BETWEEN_EVICTION_RUNS_MILLIS
     *
     * @mbggenerated
     */
    public Integer getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.TIME_BETWEEN_EVICTION_RUNS_MILLIS
     *
     * @param timeBetweenEvictionRunsMillis the value for sys_database_config.TIME_BETWEEN_EVICTION_RUNS_MILLIS
     *
     * @mbggenerated
     */
    public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_database_config.VALIDATION_QUERY
     *
     * @return the value of sys_database_config.VALIDATION_QUERY
     *
     * @mbggenerated
     */
    public String getValidationQuery() {
        return validationQuery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_database_config.VALIDATION_QUERY
     *
     * @param validationQuery the value for sys_database_config.VALIDATION_QUERY
     *
     * @mbggenerated
     */
    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery == null ? null : validationQuery.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_database_config
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DatabaseConfig other = (DatabaseConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
            && (this.getDbModel() == null ? other.getDbModel() == null : this.getDbModel().equals(other.getDbModel()))
            && (this.getDbType() == null ? other.getDbType() == null : this.getDbType().equals(other.getDbType()))
            && (this.getDbUsername() == null ? other.getDbUsername() == null : this.getDbUsername().equals(other.getDbUsername()))
            && (this.getDbPassword() == null ? other.getDbPassword() == null : this.getDbPassword().equals(other.getDbPassword()))
            && (this.getDriverUrl() == null ? other.getDriverUrl() == null : this.getDriverUrl().equals(other.getDriverUrl()))
            && (this.getDbIp() == null ? other.getDbIp() == null : this.getDbIp().equals(other.getDbIp()))
            && (this.getDbPort() == null ? other.getDbPort() == null : this.getDbPort().equals(other.getDbPort()))
            && (this.getDbName() == null ? other.getDbName() == null : this.getDbName().equals(other.getDbName()))
            && (this.getDriverClassName() == null ? other.getDriverClassName() == null : this.getDriverClassName().equals(other.getDriverClassName()))
            && (this.getInitialSize() == null ? other.getInitialSize() == null : this.getInitialSize().equals(other.getInitialSize()))
            && (this.getMaxActive() == null ? other.getMaxActive() == null : this.getMaxActive().equals(other.getMaxActive()))
            && (this.getMaxPoolPreparedStatementPerConnectionSize() == null ? other.getMaxPoolPreparedStatementPerConnectionSize() == null : this.getMaxPoolPreparedStatementPerConnectionSize().equals(other.getMaxPoolPreparedStatementPerConnectionSize()))
            && (this.getMaxWait() == null ? other.getMaxWait() == null : this.getMaxWait().equals(other.getMaxWait()))
            && (this.getMinEvictableIdleTimeMillis() == null ? other.getMinEvictableIdleTimeMillis() == null : this.getMinEvictableIdleTimeMillis().equals(other.getMinEvictableIdleTimeMillis()))
            && (this.getMinIdle() == null ? other.getMinIdle() == null : this.getMinIdle().equals(other.getMinIdle()))
            && (this.getPoolPreparedStatements() == null ? other.getPoolPreparedStatements() == null : this.getPoolPreparedStatements().equals(other.getPoolPreparedStatements()))
            && (this.getTestOnBorrow() == null ? other.getTestOnBorrow() == null : this.getTestOnBorrow().equals(other.getTestOnBorrow()))
            && (this.getTestOnReturn() == null ? other.getTestOnReturn() == null : this.getTestOnReturn().equals(other.getTestOnReturn()))
            && (this.getTestWhileIdle() == null ? other.getTestWhileIdle() == null : this.getTestWhileIdle().equals(other.getTestWhileIdle()))
            && (this.getTimeBetweenEvictionRunsMillis() == null ? other.getTimeBetweenEvictionRunsMillis() == null : this.getTimeBetweenEvictionRunsMillis().equals(other.getTimeBetweenEvictionRunsMillis()))
            && (this.getValidationQuery() == null ? other.getValidationQuery() == null : this.getValidationQuery().equals(other.getValidationQuery()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_database_config
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
        result = prime * result + ((getDbModel() == null) ? 0 : getDbModel().hashCode());
        result = prime * result + ((getDbType() == null) ? 0 : getDbType().hashCode());
        result = prime * result + ((getDbUsername() == null) ? 0 : getDbUsername().hashCode());
        result = prime * result + ((getDbPassword() == null) ? 0 : getDbPassword().hashCode());
        result = prime * result + ((getDriverUrl() == null) ? 0 : getDriverUrl().hashCode());
        result = prime * result + ((getDbIp() == null) ? 0 : getDbIp().hashCode());
        result = prime * result + ((getDbPort() == null) ? 0 : getDbPort().hashCode());
        result = prime * result + ((getDbName() == null) ? 0 : getDbName().hashCode());
        result = prime * result + ((getDriverClassName() == null) ? 0 : getDriverClassName().hashCode());
        result = prime * result + ((getInitialSize() == null) ? 0 : getInitialSize().hashCode());
        result = prime * result + ((getMaxActive() == null) ? 0 : getMaxActive().hashCode());
        result = prime * result + ((getMaxPoolPreparedStatementPerConnectionSize() == null) ? 0 : getMaxPoolPreparedStatementPerConnectionSize().hashCode());
        result = prime * result + ((getMaxWait() == null) ? 0 : getMaxWait().hashCode());
        result = prime * result + ((getMinEvictableIdleTimeMillis() == null) ? 0 : getMinEvictableIdleTimeMillis().hashCode());
        result = prime * result + ((getMinIdle() == null) ? 0 : getMinIdle().hashCode());
        result = prime * result + ((getPoolPreparedStatements() == null) ? 0 : getPoolPreparedStatements().hashCode());
        result = prime * result + ((getTestOnBorrow() == null) ? 0 : getTestOnBorrow().hashCode());
        result = prime * result + ((getTestOnReturn() == null) ? 0 : getTestOnReturn().hashCode());
        result = prime * result + ((getTestWhileIdle() == null) ? 0 : getTestWhileIdle().hashCode());
        result = prime * result + ((getTimeBetweenEvictionRunsMillis() == null) ? 0 : getTimeBetweenEvictionRunsMillis().hashCode());
        result = prime * result + ((getValidationQuery() == null) ? 0 : getValidationQuery().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_database_config
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", dbModel=").append(dbModel);
        sb.append(", dbType=").append(dbType);
        sb.append(", dbUsername=").append(dbUsername);
        sb.append(", dbPassword=").append(dbPassword);
        sb.append(", driverUrl=").append(driverUrl);
        sb.append(", dbIp=").append(dbIp);
        sb.append(", dbPort=").append(dbPort);
        sb.append(", dbName=").append(dbName);
        sb.append(", driverClassName=").append(driverClassName);
        sb.append(", initialSize=").append(initialSize);
        sb.append(", maxActive=").append(maxActive);
        sb.append(", maxPoolPreparedStatementPerConnectionSize=").append(maxPoolPreparedStatementPerConnectionSize);
        sb.append(", maxWait=").append(maxWait);
        sb.append(", minEvictableIdleTimeMillis=").append(minEvictableIdleTimeMillis);
        sb.append(", minIdle=").append(minIdle);
        sb.append(", poolPreparedStatements=").append(poolPreparedStatements);
        sb.append(", testOnBorrow=").append(testOnBorrow);
        sb.append(", testOnReturn=").append(testOnReturn);
        sb.append(", testWhileIdle=").append(testWhileIdle);
        sb.append(", timeBetweenEvictionRunsMillis=").append(timeBetweenEvictionRunsMillis);
        sb.append(", validationQuery=").append(validationQuery);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}