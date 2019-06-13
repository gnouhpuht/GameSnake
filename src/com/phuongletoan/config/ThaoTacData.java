package com.phuongletoan.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThaoTacData {
    public ResultSet selectDl(String sql){
        Connection connection=new JDBC_Connection().getConnection();
        PreparedStatement pre;
        ResultSet resultSet=null;
        try {
            pre=connection.prepareStatement(sql);
            resultSet=pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
//    public ResultSet selectScore(String sql){
//        Connection connection=new JDBC_Connection().getConnection();
//        PreparedStatement pre;
//        ResultSet resultSet=null;
//        try {
//            pre=connection.prepareStatement(sql);
//            resultSet=pre.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return resultSet;
//    }
}
