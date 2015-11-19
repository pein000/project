package com.one.shop;

import com.alibaba.druid.pool.DruidDataSource;
import com.one.shop.settings.JdbcConnectionSettings;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
@MapperScan(basePackages="com.one.shop.persistence")
public class DatabaseConfig {

    @Autowired
    private JdbcConnectionSettings jdbcConnectionSettings;

    @Bean
    public DataSource dataSource() {
        return buildDruidDatabasePoll();
        //return buildH2Database();
    }

    private DataSource buildDruidDatabasePoll() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(jdbcConnectionSettings.getDriver());
        ds.setUsername(jdbcConnectionSettings.getUsername());
        ds.setPassword(jdbcConnectionSettings.getPassword());
        ds.setUrl(jdbcConnectionSettings.getUrl());
        ds.setMaxActive(jdbcConnectionSettings.getMaxActive());
        ds.setValidationQuery(jdbcConnectionSettings.getValidationQuery());
        ds.setTestOnBorrow(jdbcConnectionSettings.getTestOnBorrow());
        ds.setTestOnReturn(jdbcConnectionSettings.getTestOnReturn());
        ds.setTestWhileIdle(jdbcConnectionSettings.getTestWhileIdle());
        ds.setTimeBetweenEvictionRunsMillis(jdbcConnectionSettings.getTimeBetweenEvictionRunsMillis());
        ds.setMinEvictableIdleTimeMillis(jdbcConnectionSettings.getMinEvictableIdleTimeMillis());
        return ds;
    }

    private EmbeddedDatabase buildH2Database() {
        return new EmbeddedDatabaseBuilder().setType(H2).build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

}
