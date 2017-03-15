package com.leojr.uet.snake.object;


import com.leojr.uet.snake.animation.Animation;
import com.leojr.uet.snake.common.CommonVls;
import com.leojr.uet.snake.ui.GameScreen;

import java.awt.*;
import java.util.Random;

import static com.leojr.uet.snake.common.CommonVls.*;

public class Snake {
    private int length = 3; // Length of Snake
    private int []x = new int[ARR_SIZE]; // Snake's coordinates are stored in the array
    private int []y = new int[ARR_SIZE];; // Snake's coordinates are stored in the array
    private int direction; // Derection of the snake
    private int beginTime;

    private int currentImage;
    private Animation animation;

    public Snake(){
        /*
        Set location, length and direction of the snake
         */
        this.direction = GO_DOWN;
        this.x[0] = 5;
        this.y[0] = 4;

        this.x[1] = 5;
        this.y[1]= 3;

        this.x[2] = 5;
        this.y[2]= 2;

        beginTime = 0;
        CommonVls.loadImage();
        currentImage = 0;
        animation = new Animation(CommonVls.SNAKE);
    }

    public void update(int [][]bgGame){
        if(System.currentTimeMillis()- beginTime > GAME_SPEED){
            if(currentImage>=2){
                currentImage =0;
            }
            eatFood(bgGame);
            move();
            /*
            If your code like that
                "
                move();
                eatFood(bgGame);
                "
            program will have BIG BUG =="
             */
            beginTime = (int) System.currentTimeMillis();
        }

    }

    /*
    Drawn snake
     */
    public void paintSnake(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.drawImage(animation.getCurrentImg(this.direction),x[0]*20-5 ,y[0]*20-5,null);
        for (int i = 1; i <length ; i++) {
            graphics.drawImage(CommonVls.snakeBody,x[i]*20 ,y[i]*20,null);
        }
    }

    private void move(){
        for (int i = this.getLength() - 1; i > 0 ; i--) {
                x[i] = x[i-1];
                y[i] = y[i-1];
        }
        switch (this.direction){
            case GO_UP:
                y[0]--;
                break;
            case GO_DOWN:
                y[0]++;
                break;
            case GO_LEFT:
                x[0]--;
                break;
            case GO_RIGHT:
                x[0]++;
                break;
        }
        if(x[0]<0) x[0] = 24;
        if(x[0]>24) x[0] = 0;
        if(y[0]>24) y[0] = 0;
        if(y[0]<0) y[0] = 24;
    }

    public void setDirection(int direction){
        if(this.direction != -direction){ //Snake can't go counterclockwise
            this.direction = direction;
        }

    }

    public void eatFood(int [][]bgGame){
        if(bgGame[x[0]][y[0]] == FOOD_LOCATION){
            bgGame[x[0]][y[0]] = 0;
            length++;
            bgGame[setNewFoodLocation().getX()][setNewFoodLocation().getY()] = CommonVls.FOOD_LOCATION;
        }
    }

    public int getLength(){
        return this.length;
    }
    public void setLength(int length){
        this.length = length;
    }
    private Food setNewFoodLocation(){
        Random r = new Random();
        int x;
        int y;
        do {
            x = r.nextInt(24);
            y = r.nextInt(24);
        }while (isFoodInsideSnake(x,y));
        return new Food(x,y);
    }
    private boolean isFoodInsideSnake(int x, int y){
        for (int i = 0; i < this.length; i++) {
            if(this.x[i]==x&&this.y[i]==y){
                return true;
            }
        }
        return false;
    }
}
