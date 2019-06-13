package com.phuongletoan.screen;

import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IRemoveMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel implements Constant {
    private JButton btnPlay;
    private JButton btnExit;
    private JButton btnHelp;
    private IRemoveMenu iRemove;
    private Image bg;

    public MenuPanel(){
        setSize(WIDTH_F,HEIGHT_F);
        setLayout(null);
        bg=new ImageIcon(getClass().getResource("/imgs/bg_menu.png")).getImage();
        initPlay();
    }

    private void initPlay(){
        btnPlay=new JButton();
        btnPlay.setSize(100,50);
        btnPlay.setBackground(Color.yellow);
        btnPlay.setLocation(WIDTH_F-200,100);
        btnPlay.setFont(new Font("Bradley Hand ITC",Font.BOLD,28));
        btnPlay.setBorder(BorderFactory.createLineBorder(Color.black,1));

        btnPlay.setText("Play");

        add(btnPlay);
        btnPlay.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iRemove.removePlay();
            }
        });

        btnHelp=new JButton();
        btnHelp.setSize(100,50);
        btnHelp.setBackground(Color.yellow);
        btnHelp.setLocation(WIDTH_F-200,HEIGHT_F/2-50);
        btnHelp.setFont(new Font("Bradley Hand ITC",Font.BOLD,28));
        btnHelp.setBorder(BorderFactory.createLineBorder(Color.black,1));
        btnHelp.setText("Help");

        add(btnHelp);
        btnHelp.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iRemove.removeHelp();
            }
        });

        btnExit=new JButton();
        btnExit=new JButton();
        btnExit.setSize(100,50);
        btnExit.setBackground(Color.yellow);
        btnExit.setLocation(WIDTH_F-200,HEIGHT_F-200);
        btnExit.setFont(new Font("Bradley Hand ITC",Font.BOLD,28));
        btnExit.setBorder(BorderFactory.createLineBorder(Color.black,1));
        btnExit.setText("Exit");

        add(btnExit);
        btnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.drawImage(bg,0,0,WIDTH_F,HEIGHT_F,null);
    }

    public void setRemove(IRemoveMenu rm) {
        this.iRemove=rm;
    }
}
