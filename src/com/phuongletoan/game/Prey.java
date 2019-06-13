package com.phuongletoan.game;

import com.phuongletoan.interf.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Prey implements Constant {
//    public static int pr[][]=new int[X][Y];
    private int pr[][];

    private int x1,x2;
    private Image prey=new ImageIcon(getClass().getResource("/imgs/candy5.png")).getImage();
    public Prey(int x[], int y[], int length){
        pr=new int[X][Y];
        initPrey( x, y, length);

    }

    public int[][] getPr() {
        return pr;
    }

    public void setPr(int[][] pr) {
        this.pr = pr;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void initPrey(int x[], int y[], int le){
        Random rd=new Random();
        int a=X-3;
        int b=Y-3;

        while (true){
            boolean isOkCreate=true;
            x1=rd.nextInt(a)+1;
            x2=rd.nextInt(b)+1;
            Rectangle reFuit = new Rectangle(x1, x2, SIZE, SIZE);
            for (int i = 0; i < le; i++){
                Rectangle re = new Rectangle(x[i], y[i], SIZE, SIZE);
                if ( reFuit.intersects(re)){
                    isOkCreate=false;
                    break;
                }
            }
            if (isOkCreate){
                break;
            }
        }
        pr[x1][x2]=1;
    }
    //kiểm tra xuất hiện thức ăn
    public boolean checkShowPrey(){
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (pr[i][j]==1){
                    return true;
                }
            }
        }
        return false;
    }
    public void drawPrey(Graphics2D g2d){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i <X ; i++) {
            for (int j = 0; j < Y; j++) {
                if (pr[i][j]==1){
                    g2d.setColor(Color.yellow);
                    g2d.drawImage(prey,i*SIZE+1,j*SIZE+1,18,18,null);
                }

            }
        }
    }
    public void clearPrey(){
        for (int i = 0; i <X ; i++) {
            for (int j = 0; j <Y ; j++) {
                pr[i][j]=0;
            }
        }
    }
}
