package com.leojr.uet.snake.common;


import com.leojr.uet.snake.animation.Animation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CommonVls {
    public static final String IS_STOPPED = "PRESS SPACE TO CONTINUE";

    public static final int GAME_WIDTH = 528;
    public static final int GAME_HEIGHT = 552;
    public static final int ARR_SIZE = 25;
    public static final int FOOD_SIZE = 20;
    public static final int PADDING = 14;
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 552;
    public static final int PLAY_INFO_WIDTH = 266;
    public static final int PLAY_INFO_HEIGHT = 552;

    public static final int GO_UP = 1;
    public static final int GO_DOWN = -1;
    public static final int GO_LEFT = 2;
    public static final int GO_RIGHT = -2;
    public static final int GAME_SPEED = 500;
    public static final int FOOD_LOCATION = 5;
    public static final int SNAKE = 10;
    public static final int FOOD = 15;

    public static BufferedImage sprite;

    public static Image snakeHead;
    public static Image snakeBody;
    public static Image snakeGoLeft;
    public static Image snakeGoDown;
    public static Image snakeGoUp;
    public static Image snakeGoRight;

    public static Image worm;
    public static Image worm2;
    public static Image worm3;


    public static void loadImage(){
        try {
            sprite = ImageIO.read(new File("RESOURCE/sprite1.png"));
            snakeHead = sprite.getSubimage(2,3,30,30);
            snakeBody = ImageIO.read(new File("RESOURCE/snake_body.png"));

            snakeGoLeft = sprite.getSubimage(75,3,30,30);
            snakeGoDown = sprite.getSubimage(39,3,30,30);
            snakeGoRight = sprite.getSubimage(110,3,30,30);
            snakeGoUp = sprite.getSubimage(145,3,30,30);

            worm = sprite.getSubimage(2,40,30,30);
            worm2 = sprite.getSubimage(32,40,30,30);
            worm3 = sprite.getSubimage(64,40,30,30);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
