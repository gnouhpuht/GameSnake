package com.phuongletoan.config;

import com.phuongletoan.game.TaiKhoan;

import java.sql.ResultSet;
import java.sql.SQLException;

public class XuLyLogIn {
    public int login(String user, String pass)throws SQLException {
        String sql="select * from taikhoan where tennguoidung='"+user+"'and matkhau='"+pass+"'";
        ResultSet resultSet=new ThaoTacData().selectDl(sql);
        TaiKhoan taiKhoan=new TaiKhoan();
//        System.out.println(user);
//        System.out.println(pass);
        while (resultSet.next()){
            taiKhoan.setUserName(resultSet.getString("tennguoidung"));
            taiKhoan.setPassword(resultSet.getString("matkhau"));
        }
        if (taiKhoan.getUserName()!=null){
            return 1;
        }
        else return 0;
    }

//    public int score(String user, int score)throws SQLException{
//        String sql="select * from score where idtaikhoan='"+user+"'and diem='"+score+"'";
//        ResultSet resultSet=new ThaoTacData().selectScore(sql);
//    }
}
