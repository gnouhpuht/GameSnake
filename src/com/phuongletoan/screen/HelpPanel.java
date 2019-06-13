package com.phuongletoan.screen;

import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IBackHelp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HelpPanel extends JPanel implements Constant {
    private JButton btnBack;
    private IBackHelp iBackHelp;
    private Image help;
    public HelpPanel(){
        setSize(WIDTH_F,HEIGHT_F);
        setLayout(null);
        help=new ImageIcon(getClass().getResource("/imgs/help.png")).getImage();
        initHelp();
    }

    private void initHelp(){
        btnBack=new JButton();
        btnBack.setSize(100,50);
        btnBack.setBackground(Color.yellow);
        btnBack.setLocation(WIDTH_F/2-50,HEIGHT_F-150);
        btnBack.setFont(new Font("Bradley Hand ITC",Font.BOLD,28));
        btnBack.setBorder(BorderFactory.createLineBorder(Color.black,1));
        btnBack.setText("Back");


        add(btnBack);
        btnBack.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               iBackHelp.backHelp();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.drawImage(help,0,0,WIDTH_F,HEIGHT_F,null);
    }

    public void setRemove(IBackHelp iBackHelp) {
        this.iBackHelp=iBackHelp;
    }
}
