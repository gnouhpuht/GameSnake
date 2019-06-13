package com.phuongletoan.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
    public final static String classForName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final static String url="jdbc:sqlserver://localhost:1433;databaseName=gamesnake";
    public final static String user="sa";
    public final static String pass="12345";

    public Connection getConnection(){
        try {
            Class.forName(classForName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn=null;

        try {
            conn= DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
