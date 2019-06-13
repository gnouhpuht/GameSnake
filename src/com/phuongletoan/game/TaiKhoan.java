package com.phuongletoan.game;

public class TaiKhoan {
    private String userName;
    private String password;

    public TaiKhoan(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public TaiKhoan() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
