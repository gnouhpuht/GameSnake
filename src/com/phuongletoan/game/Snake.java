package com.phuongletoan.game;

import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IUpdateScore;

import javax.swing.*;
import java.awt.*;


public class Snake implements Constant {
    private Image head = new ImageIcon(getClass().getResource("/imgs/head1.png")).getImage();
    private Image body =new ImageIcon(getClass().getResource("/imgs/body.png")).getImage();
    private Orientation orientation;
    private int length=3;
    private int x[];
    private int y[];
    private long wait=50;

    public Snake(){

        setOrientation(orientation.RIGHT);
        x=new int[LENGTH_S];
        y=new int[LENGTH_S];

        for (int i = 0; i <length ; i++) {
            x[i] = 5-i;
            y[i] = 5;
        }

    }


    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void drawSnake(Graphics2D g2d){
        g2d.setColor(Color.red);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 1 ; i < length; i++) {
            g2d.drawImage(body,x[i]*SIZE+1,y[i]*SIZE+1,SIZE ,SIZE ,null);
        }
        g2d.drawImage(head,x[0]*SIZE,y[0]*SIZE ,SIZE+2 ,SIZE +2 ,null);
    }
    public void drawEncircle(Graphics2D g2d ){
        g2d.setColor(Color.red);
        for (int i = 0; i < WIDTH_F; i++) {
            for (int j = 0; j < HEIGHT_F; j++) {
                if (i==0){
                    g2d.fillRect(i*SIZE+1  , j*SIZE+1  ,SIZE-2,SIZE-2);
                }
                if (i==WIDTH_F -SIZE+2 ){
                    g2d.fillRect(i-1, j *SIZE+1 ,SIZE-2,SIZE-2);
                }
                if (j ==0){
                    g2d.fillRect(i *SIZE+1 , j *SIZE+1 ,SIZE-2,SIZE-2);
                }
                if (j==HEIGHT_F -HEIGHT_SCORE-SIZE+2 ){
                    g2d.fillRect(i *SIZE+ 1  , j- 1,SIZE-2,SIZE-1);
                }
            }
        }

    }

    //di chuyển nhấn phím
    public void move(Orientation orientation) {
        this.orientation=orientation;
        for (int i = length-1; i >0; i--) {
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        switch (orientation){
            case RIGHT:
                x[0]++;
                break;
            case LEFT:
                x[0]--;
                break;
            case UP:
                y[0]--;
                break;
            case DOWN:
                y[0]++;
                break;
        }
    }
    //di chuyển tự động
    public void moveStep(long currentTime){
        if (currentTime% wait!=0){
            return;
        }
        for (int i = length-1; i >0; i--) {
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        switch (orientation){
            case RIGHT:
                x[0]++;
                break;
            case LEFT:
                x[0]--;
                break;
            case UP:
                y[0]--;
                break;
            case DOWN:
                y[0]++;
                break;
        }
    }

    public boolean checkDie(){
        for (int i = 0; i < WIDTH_F/SIZE; i++) {
            if (i>1&&i<WIDTH_F/SIZE){
                if (x[0] ==0 ){
                    return true;
                }
                if (x[0] ==WIDTH_F/SIZE-1){
                    return true;
                }
            }
        }
        for (int i = 0; i < (HEIGHT_F-HEIGHT_SCORE)/SIZE; i++) {
            if (i>1&&i<(HEIGHT_F-HEIGHT_SCORE)/SIZE){
                if (y[0] ==0 ){
                    return true;
                }
                if (y[0] ==(HEIGHT_F-HEIGHT_SCORE)/SIZE-1){
                    return true;
                }
            }
        }
        for (int i = 4 ; i <length ; i++) {
            if (x[0]==x[i]&&y[0]==y[i]){
                return true ;
            }
        }
        return false;

    }

}
