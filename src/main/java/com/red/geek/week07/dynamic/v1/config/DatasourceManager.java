package com.red.geek.week07.dynamic.v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * DatasourceManager
 *
 * @author red
 * @class_name DatasourceManager
 * @date 2021-05-02
 */
@Component
public class DatasourceManager {

    @Autowired
    @Qualifier("master")
    DataSource masterDatasource;

    @Autowired
    @Qualifier("slave1")
    DataSource slave1Datasource;

    public DataSource getSlaveDatasource() {
        return slave1Datasource;
    }
}
