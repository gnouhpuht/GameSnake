package com.phuongletoan.screen;

import com.phuongletoan.game.GameManagerSnake;
import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IUpdateScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanelPlay extends JPanel implements KeyListener,Runnable, Constant {
    private GameManagerSnake gameManagerSnake;
    private long time;
    private Thread thread;

    public GamePanelPlay(){
        setSize(WIDTH_F,HEIGHT_F-HEIGHT_SCORE);
        setLocation(0,0);
        gameManagerSnake=new GameManagerSnake();
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(this);
        initThread();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        gameManagerSnake.drawAll(g2d);
    }

    private void initThread(){
        thread=new Thread(this);
        thread.start();
    }
    public void setUpdateScore(IUpdateScore updateScore){
        gameManagerSnake.setUpdateScore(updateScore);
    }
    @Override
    public void run() {
        while (true){
            gameManagerSnake.stepThread(time);
            repaint();
            try {
//                wait(3);
//                notify();
                thread.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time+=1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        gameManagerSnake.press(code);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
