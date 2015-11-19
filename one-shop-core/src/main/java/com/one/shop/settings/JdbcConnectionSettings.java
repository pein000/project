package com.one.shop.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by pein on 2015/11/9.
 */
@Component
@ConfigurationProperties(locations = "classpath:druid.properties", ignoreUnknownFields = false, prefix = "jdbc")
public class JdbcConnectionSettings {
    private String driver;
    private String url;
    private String username;
    private String password;
    private int maxActive;
    private int minIdle;
    private int maxIdle;
    private int maxWait;
    private String validationQuery = "/* ping */ select 1";
    private Boolean testOnBorrow = false;
    private Boolean testOnReturn = false;
    private Boolean testWhileIdle = true;
    private long timeBetweenEvictionRunsMillis = 60000;
    private long minEvictableIdleTimeMillis = -1;


    public String getDriver() {
        return driver;
    }


    public void setDriver( String driver ) {
        this.driver = driver;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl( String url ) {
        this.url = url;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername( String username ) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword( String password ) {
        this.password = password;
    }


    public int getMaxActive() {
        return maxActive;
    }


    public void setMaxActive( int maxActive ) {
        this.maxActive = maxActive;
    }


    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxIdle() {
        return maxIdle;
    }


    public void setMaxIdle( int maxIdle ) {
        this.maxIdle = maxIdle;
    }


    public int getMaxWait() {
        return maxWait;
    }


    public void setMaxWait( int maxWait ) {
        this.maxWait = maxWait;
    }


    public String getValidationQuery() {
        return validationQuery;
    }


    public void setValidationQuery( String validationQuery ) {
        this.validationQuery = validationQuery;
    }


    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }


    public void setTestOnBorrow( Boolean testOnBorrow ) {
        this.testOnBorrow = testOnBorrow;
    }


    public Boolean getTestOnReturn() {
        return testOnReturn;
    }


    public void setTestOnReturn( Boolean testOnReturn ) {
        this.testOnReturn = testOnReturn;
    }


    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }


    public void setTestWhileIdle( Boolean testWhileIdle ) {
        this.testWhileIdle = testWhileIdle;
    }


    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }


    public void setTimeBetweenEvictionRunsMillis( long timeBetweenEvictionRunsMillis ) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }


    public long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }


    public void setMinEvictableIdleTimeMillis( long minEvictableIdleTimeMillis ) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

}
