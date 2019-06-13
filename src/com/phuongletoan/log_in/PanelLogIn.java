package com.phuongletoan.log_in;

import com.phuongletoan.config.XuLyLogIn;
import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IRemoveLogin;
import com.phuongletoan.screen.FrameGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class PanelLogIn extends JPanel implements Constant {
    private JButton btnLogIn;
    private JButton btnCancel;
    private JPasswordField tvPass;
    private JTextField tvUser;
    private JLabel lbUser;
    private JLabel lbPass;
    private JLabel lbLogIn;
    private IRemoveLogin iremove;

    public PanelLogIn(){
        setSize(WIDTH_LOG,HEIGHT_LOG);
        setLayout(null);
        setBackground(Color.gray);
        setFocusable(true);
        initLogIn();

    }
    private void initLogIn(){
        lbLogIn=new JLabel();
        lbLogIn.setSize(100,30);
        lbLogIn.setFont(new Font("",Font.BOLD,18));
        lbLogIn.setText("Đăng Nhập");
        lbLogIn.setLocation(150,50);
        add(lbLogIn);

        lbUser=new JLabel();
        lbUser.setFont(new Font("",Font.BOLD,14));
        lbUser.setText("Tài Khoản: ");
        lbUser.setSize(100,30);
        lbUser.setLocation(50,100);
        add(lbUser);

        tvUser=new JTextField();
        tvUser.setLocation(150,100);
        tvUser.setSize(180,30);
        add(tvUser);


        lbPass=new JLabel();
        lbPass.setFont(new Font("",Font.BOLD,14));
        lbPass.setText("Mật Khẩu: ");
        lbPass.setSize(100,30);
        lbPass.setLocation(50,150);
        add(lbPass);

        tvPass=new JPasswordField();
        tvPass.setLocation(150,150);
        tvPass.setSize(180,30);
        add(tvPass);

        btnLogIn=new JButton();
        btnLogIn.setSize(100,30);
        btnLogIn.setText("Đăng Nhập");
        btnLogIn.setLocation(WIDTH_LOG/4-50,HEIGHT_LOG-100);
        add(btnLogIn);
        btnLogIn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iremove.removeLogin();
                xuLy();
            }
        });

        btnCancel=new JButton();
        btnCancel.setSize(100,30);
        btnCancel.setText("Hủy");
        btnCancel.setLocation(WIDTH_LOG-150,HEIGHT_LOG-100);
        add(btnCancel);
        btnCancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void setRemove(IRemoveLogin rm) {
        this.iremove=rm;
    }
    private void xuLy(){
        String user =tvUser.getText();
        String pass=String.valueOf(tvPass.getPassword());
        XuLyLogIn xuLyLogIn=new XuLyLogIn();
        try {
            int kq=xuLyLogIn.login(user,pass);
            if (kq==1){
                FrameGame frameGame =new FrameGame();
                frameGame.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"đăng nhập không thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
