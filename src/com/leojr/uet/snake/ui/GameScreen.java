package com.leojr.uet.snake.ui;

import com.leojr.uet.snake.animation.Animation;
import com.leojr.uet.snake.common.CommonVls;
import com.leojr.uet.snake.object.Food;
import com.leojr.uet.snake.object.Snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameScreen extends JPanel implements Runnable,KeyListener {
    private Thread thread;
    private int[][] bgGame = new int[CommonVls.ARR_SIZE][CommonVls.ARR_SIZE];
    private int x;
    private int gameSpeed;
    private Snake snake;
    private int beginTime;
    private Food food;
    private Animation animationFood;

    public GameScreen(){
        food = new Food(10,10);
        snake = new Snake();
        thread = new Thread(this);
        thread.start();
        beginTime = 0;
        bgGame[food.getX()][food.getY()] = CommonVls.FOOD_LOCATION;
        CommonVls.loadImage();
        animationFood = new Animation(CommonVls.FOOD);
    }

    //Draw Game Broad
    public void paintBgGame(Graphics graphics){
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0,0,CommonVls.SCREEN_WIDTH,CommonVls.SCREEN_HEIGHT);
        for (int i = 0; i < CommonVls.ARR_SIZE ; i++) {
            for (int j = 0; j <CommonVls.ARR_SIZE ; j++) {
                //Draw worm like food for snake
                if(bgGame[i][j] == CommonVls.FOOD_LOCATION){
                    graphics.drawImage(animationFood.getCurrentImg(0),i*CommonVls.FOOD_SIZE -6 ,j*CommonVls.FOOD_SIZE - 6,null);

                }
            }
        }
    }

    @Override
    public void paint(Graphics g){
        paintBgGame(g); // Draw background game
        snake.paintSnake(g);// Draw UNDER background game
    }

    @Override
    public void run() {

        while(true){
            snake.update(bgGame);
            repaint();
            try {
                thread.sleep(CommonVls.GAME_SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
