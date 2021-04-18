package com.red.geek.week05.database.jdbc;

import com.red.geek.week05.bean.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * JdbcApp
 *
 * @author red
 * @class_name JdbcApp
 * @date 2021-04-17
 */
public class JdbcApp {

    private Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insert(Connection connection, Object... params) {
        PreparedStatement pstmt = null;
        try {
            connection.setAutoCommit(false);
            String sql = "insert into table user_info values(?, ?)";
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void batch(Connection connection, List<User> users) {
        PreparedStatement pstmt = null;
        try {
            connection.setAutoCommit(false);
            String sql = "insert into table user_info values(?, ?)";
            pstmt = connection.prepareStatement(sql);
            for (User user : users) {
                pstmt.setString(1, user.getUsername());
                pstmt.setInt(2, user.getAge());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<User> query(Connection connection, Object... params) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> results = new LinkedList<User>();
        try {
            String sql = "select * from user_info where id = ?";
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                int age = rs.getInt("age");
                results.add(new User(username, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return results;
    }

}
