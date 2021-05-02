package com.red.geek.week07.dynamic.v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * DatasourceConfig
 *
 * @author red
 * @class_name DatasourceConfig
 * @date 2021-05-02
 */
@Configuration
public class DatasourceConfig {

    @Autowired
    Environment env;


    @Primary
    @Bean(name = "master")
    public DataSource masterDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("master.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("master.datasource.url"));
        dataSource.setUsername(env.getProperty("master.datasource.username"));
        dataSource.setPassword(env.getProperty("master.datasource.password"));
        return dataSource;
    }

    @Bean(name = "slave1")
    public DataSource slave1DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("slave1.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("slave1.datasource.url"));
        dataSource.setUsername(env.getProperty("slave1.datasource.username"));
        dataSource.setPassword(env.getProperty("slave1.datasource.password"));
        return dataSource;
    }
}
