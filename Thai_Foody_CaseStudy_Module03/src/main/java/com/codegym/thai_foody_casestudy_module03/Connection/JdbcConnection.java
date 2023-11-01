package com.codegym.thai_foody_casestudy_module03.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String CONN_URL = "jdbc:mysql://localhost:3306/thai_foody_casestudy_module03_database?useUnicode=true&amp;characterEncoding=utf8";
//    private static final String CONN_URL = "jdbc:mysql://localhost:3306/thai_foody_casestudy_module03_database?useUnicode=true&characterEncoding=utf8";

    private static final String CONN_URL = "jdbc:mysql://localhost:3306/thai_foody_casestudy_module03_database?useUnicode=true&characterEncoding=utf8";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection connection;
        try {
            // load Driver
            Class.forName(DRIVER);
            // tạo kết nối toi Driver
            connection = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for jdbc connection!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not find database!");
            e.printStackTrace();
        }
        return null;
    }

}
