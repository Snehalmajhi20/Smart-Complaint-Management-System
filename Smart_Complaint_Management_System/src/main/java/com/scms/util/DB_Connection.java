package com.scms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

    private static Connection conn = null;

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/scms_db";
        String username = "root";
        String password = "****";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("✔ Database Connected Successfully!");
            }

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }

        return conn;
    }
}