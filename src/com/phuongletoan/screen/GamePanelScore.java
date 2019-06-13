package com.phuongletoan.screen;

import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IUpdateScore;

import javax.swing.*;
import java.awt.*;

public class GamePanelScore extends JPanel implements Constant, IUpdateScore {
    private int score;

    public GamePanelScore(){
        setBackground(Color.gray);
        setSize(WIDTH_F,HEIGHT_SCORE);
        setLocation(0,HEIGHT_F-HEIGHT_SCORE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.red);
        g2d.setFont(new Font("",Font.BOLD,24));
        g2d.drawString("Scores: "+score+" ",10,30);
    }

    @Override
    public void updateScore(int score) {
        this.score=score;
//        System.out.println("score: " + score);
        repaint();
    }
}
