package com.myspringbt.demo.dataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 对数据源  和mybatis
 */
@Configuration
public class DataSourcesConfig {


    @Bean(name = "db1")
    @Qualifier("db1")
    @ConfigurationProperties(prefix = "spring.datasource.primary") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "db2")
    @Qualifier("db2")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.secondary") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

}