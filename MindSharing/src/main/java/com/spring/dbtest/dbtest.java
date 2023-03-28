package com.spring.dbtest;

import java.sql.*;

public class dbtest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:~/test;AUTO_SERVER=TRUE";
        Connection conn = DriverManager.getConnection(url);
        System.out.println("Connected to H2 database.");
        conn.close();
    }
}