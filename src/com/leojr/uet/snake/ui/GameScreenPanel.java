package com.leojr.uet.snake.ui;

import com.leojr.uet.snake.animation.Animation;
import com.leojr.uet.snake.common.CommonVls;
import com.leojr.uet.snake.object.Food;
import com.leojr.uet.snake.object.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameScreenPanel extends JPanel implements Runnable,KeyListener {
    private Thread thread;
    private int[][] bgGame = new int[CommonVls.ARR_SIZE][CommonVls.ARR_SIZE];
    private int x;
    private int gameSpeed;
    private Snake snake;
    private long beginTime;
    private Food food;
    private Animation animationFood;
    private boolean isPaused;
    private long stopTime;
    private boolean isEnabledTextStop;
    private boolean isGameOver;

    public GameScreenPanel(){
        food = new Food(10,10); //Creat food
        snake = new Snake();
        isGameOver = false;
        thread = new Thread(this);
        thread.start();
        bgGame[food.getX()][food.getY()] = CommonVls.FOOD_LOCATION; //Creat food location
        CommonVls.loadImage();
        animationFood = new Animation(CommonVls.FOOD);
        this.setSize(CommonVls.GAME_WIDTH, CommonVls.GAME_HEIGHT);
        this.isPaused = false;
        this.isEnabledTextStop = false;
    }

    //Draw Game Board
    private void paintBgGame(Graphics graphics){
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0,0,CommonVls.GAME_WIDTH ,CommonVls.GAME_HEIGHT );
        for (int i = 0; i < CommonVls.ARR_SIZE ; i++) {
            for (int j = 0; j <CommonVls.ARR_SIZE ; j++) {
                //Draw worm like food for snake
                if(bgGame[i][j] == CommonVls.FOOD_LOCATION){
                    graphics.drawImage(animationFood.getCurrentImg(0),
                            i*CommonVls.FOOD_SIZE - 6 + CommonVls.PADDING ,j*CommonVls.FOOD_SIZE - 6 + CommonVls.PADDING,null);

                }
            }
        }

    }
    private void paintFence(Graphics graphics){
        //Draw Rectangle around game panel
        graphics.setColor(Color.RED);
        graphics.drawRect(0,0,CommonVls.GAME_WIDTH, CommonVls.GAME_HEIGHT - 30);
        graphics.drawRect(1,1,CommonVls.GAME_WIDTH - 2, CommonVls.GAME_HEIGHT - 32);
        graphics.drawRect(2,2,CommonVls.GAME_WIDTH - 4, CommonVls.GAME_HEIGHT - 34);
        graphics.drawRect(3,3,CommonVls.GAME_WIDTH - 6, CommonVls.GAME_HEIGHT - 36);

    }

    @Override
    public void paint(Graphics g){
        paintBgGame(g); // Draw background game
        snake.paintSnake(g);// Draw UNDER background game
        paintFence(g);

        //Draw String: Press Space to play
        if(isPaused&&!isGameOver){
            if(isEnabledTextStop){
                g.setColor(Color.GREEN);
                g.setFont(g.getFont().deriveFont(28.0f));
                g.drawString(CommonVls.IS_STOPPED,60,250);
            }

        }
        if(isGameOver){
            if(isEnabledTextStop){
                g.setColor(Color.GREEN);
                g.setFont(g.getFont().deriveFont(24.0f));
                g.drawString("PRESS SPACE TO PLAY NEW GAME",60,300);
            }
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont(28.0f));
            g.drawString("Game Over",190,250);
        }

    }


    @Override
    public void run() {
        while(true){
            beginTime = 0;
            stopTime = 0;
            while(!isPaused){
                if(System.currentTimeMillis() - beginTime > CommonVls.GAME_SPEED){
                    snake.update(bgGame);
                    if(snake.isDead()){
                        isGameOver = true;
                        isPaused = true;
                    }
                    repaint();
                    beginTime =  System.currentTimeMillis();
                }

            }
            while (isPaused){
                if(System.currentTimeMillis() - stopTime > 500){
                    isEnabledTextStop = !isEnabledTextStop;
                    repaint();
                    stopTime = System.currentTimeMillis();
                }
            }
            while (isGameOver){
                repaint();
                if(System.currentTimeMillis() - stopTime >500){
                    isEnabledTextStop = !isEnabledTextStop;
                    repaint();
                    stopTime = System.currentTimeMillis();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                snake.setDirection(CommonVls.GO_UP);
                System.out.println("Key Pressed W");
                break;
            case KeyEvent.VK_S:
                snake.setDirection(CommonVls.GO_DOWN);
                System.out.println("Key Pressed S");
                break;
            case KeyEvent.VK_D:
                snake.setDirection(CommonVls.GO_RIGHT);
                System.out.println("Key Pressed D");
                break;
            case KeyEvent.VK_A:
                snake.setDirection(CommonVls.GO_LEFT);
                System.out.println("Key Pressed A");
                break;
            case KeyEvent.VK_SPACE:
                if(!isGameOver){
                    isPaused = !isPaused;
                }else {
                    isGameOver = !isGameOver;
                }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
