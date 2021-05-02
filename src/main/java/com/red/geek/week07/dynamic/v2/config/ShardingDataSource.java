package com.red.geek.week07.dynamic.v2.config;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingsphere.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * ShardingDataSource
 *
 * @author red
 * @class_name ShardingDataSource
 * @date 2021-05-02
 */
@Slf4j
@Component
public class ShardingDataSource {

    private static final String DATASOURCE_PREFIX = "sharding.jdbc.datasource.ds-";

    @Autowired
    private Environment environment;

    private DataSource createDatasource() {
        String[] hosts = environment.getProperty("sharding.jdbc.datasource.names").split(",");
        String master = hosts[0];
        String[] slaves = Arrays.copyOfRange(hosts, 1, hosts.length);
        MasterSlaveRuleConfiguration configuration = new MasterSlaveRuleConfiguration(master, master, Arrays.asList(slaves));

        try {
            return MasterSlaveDataSourceFactory.createDataSource(createDataSourceMap(hosts), configuration, Collections.emptyMap(),
                    new Properties());
        } catch (SQLException e) {
            log.error("创建数据源异常, 异常信息: {}", e.getMessage(), e);
        }
        return null;
    }

    private Map<String, DataSource> createDataSourceMap(String[] hosts) {
        Map<String, DataSource> dataSourceMap = new HashMap<>(hosts.length);
        for (String host: hosts) {
            String prefix = DATASOURCE_PREFIX + host;
            dataSourceMap.put(host, createHikariDataSource(prefix));
        }
        return dataSourceMap;
    }

    private DataSource createHikariDataSource(String prefix) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(environment.getProperty(prefix + ".driver-class-name"));
        dataSource.setJdbcUrl(environment.getProperty(prefix + ".url"));
        dataSource.setUsername(environment.getProperty(prefix + ".username"));
        dataSource.setPassword(environment.getProperty(prefix + ".password"));
        return dataSource;
    }

}
