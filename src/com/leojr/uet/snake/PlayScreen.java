package com.leojr.uet.snake;

import com.leojr.uet.snake.common.CommonVls;
import com.leojr.uet.snake.ui.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayScreen extends JFrame{
    private GameScreen gameScreen;
    public PlayScreen(){
        init();
        compoments();
    }

    private void compoments() {
        addKeyListener(gameScreen);
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(CommonVls.SCREEN_WIDTH,CommonVls.SCREEN_HEIGHT);
        this.setResizable(false);
        this.setLocation(300,100);

        this.gameScreen= new GameScreen();
        add(gameScreen);
    }

    public static void main(String args[]){
        PlayScreen playScreen = new PlayScreen();
        playScreen.setVisible(true);
    }


}
