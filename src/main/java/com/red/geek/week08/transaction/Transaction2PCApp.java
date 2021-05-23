package com.red.geek.week08.transaction;

import io.shardingsphere.core.constant.transaction.TransactionType;
import io.shardingsphere.shardingjdbc.transaction.TransactionTypeHolder;
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author red
 * @class_name Transaction2PCApp
 * @date 2021-05-23
 */
public class Transaction2PCApp {

    public static void main(String[] args) throws SQLException, IOException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(new File("sharding-databases-tables.yaml"));

        TransactionTypeHolder.set(TransactionType.XA);

        Connection connection = dataSource.getConnection();
        String sql = "insert into t_order(user_id, order_id) VALUES (?, ?)";

        // 模拟主键冲突
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            for (int i = 1; i < 11; i++) {
                statement.setLong(1, i);
                statement.setLong(2, i);
                statement.executeUpdate();
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            for (int i = 1; i < 11; i++) {
                statement.setLong(1, i + 5);
                statement.setLong(2, i + 5);
                statement.executeUpdate();
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }

        connection.close();
    }
}
