package com.phuongletoan.game;

import com.phuongletoan.interf.Constant;
import com.phuongletoan.interf.IUpdateScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class GameManagerSnake implements Constant {
    private Snake snake;
    private Prey prey;
    private  int score=0;
    private IUpdateScore updateScore;

    public GameManagerSnake(){
        snake=new Snake();
        prey=new Prey(snake.getX(), snake.getY(), snake.getLength());

    }

    public void stepThread(long currentTime){
        showMess();
        snake.moveStep(currentTime);
        updateScoreLength();
    }


    public void drawAll(Graphics2D g2d){

        prey.drawPrey(g2d);
        snake.drawSnake(g2d);
        snake.drawEncircle(g2d);
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    public void setUpdateScore(IUpdateScore updateScore){
        this.updateScore = updateScore;
    }

    public void press(int code){
        if (code==KeyEvent.VK_DOWN&&snake.getOrientation()!=Orientation.UP){
            snake.move(Orientation.DOWN);
            updateScoreLength();
        }
        if (code==KeyEvent.VK_UP&&snake.getOrientation()!=Orientation.DOWN){
            snake.move(Orientation.UP);
            updateScoreLength();
        }
        if (code==KeyEvent.VK_LEFT&&snake.getOrientation()!=Orientation.RIGHT){
            snake.move(Orientation.LEFT);
            updateScoreLength();
        }
        if (code==KeyEvent.VK_RIGHT&&snake.getOrientation()!=Orientation.LEFT){
            snake.move(Orientation.RIGHT);
            updateScoreLength();
        }

    }
    private void updateScoreLength(){
        if (checkSnakePrey(snake.getX(),snake.getY())==true){
            score++;
            snake.setLength(snake.getLength()+1);
            prey.clearPrey();
            prey.initPrey(snake.getX(), snake.getY(), snake.getLength());
            if (updateScore!=null){
                updateScore.updateScore(score);
            }

        }
    }
    //check va chạm giữa rắn với thức ăn
    public boolean checkSnakePrey(int x[],int y[]){
        Rectangle pr=new Rectangle(prey.getX1()*SIZE,prey.getX2()*SIZE,SIZE,SIZE);
        Rectangle sn=new Rectangle(x[0]*SIZE,y[0]*SIZE,SIZE,SIZE);
//        System.out.println("xSnake: " + x[0]*SIZE);
//        System.out.println("ySnake: " +y[0]*SIZE);
//
//        System.out.println("xF: " + prey.getX1()*SIZE);
//        System.out.println("yF: " +prey.getX2()*SIZE);
//        System.out.println("=============");
        if (pr.intersects(sn)&&prey.checkShowPrey()==true){
            return true;
        }
        return false;
    }
    //đưa ra thông báo khi kết thúc trò chơi
    public void showMess(){
        boolean die=snake.checkDie();
        if (die==true){
            int result= JOptionPane.showConfirmDialog(null,
                    "Điểm của bạn: "+score+"\nBạn có muốn chơi lại không?","Kết thúc",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result==JOptionPane.YES_OPTION){
                prey.clearPrey();
                snake=new Snake();
                IUpdateScore iUpdateScore = getUpdateScore();
                clearScore(0);
                setUpdateScore(iUpdateScore);
                iUpdateScore.updateScore(0);
                prey=new Prey(snake.getX(), snake.getY(), snake.getLength());
            }else {
                System.exit(0);
            }
        }
    }

    private void clearScore(int i) {
        this.score=i;
    }

    public IUpdateScore getUpdateScore(){
        return updateScore;
    }
}
