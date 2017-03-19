package com.leojr.uet.snake;

import com.leojr.uet.snake.common.CommonVls;
import com.leojr.uet.snake.ui.GameScreenPanel;
import com.leojr.uet.snake.ui.PlayingInfoPanel;

import javax.swing.*;

public class PlayScreen extends JFrame{
    private GameScreenPanel gameScreen;
    private PlayingInfoPanel playingInfoPanel;
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

        this.gameScreen= new GameScreenPanel();
        this.playingInfoPanel = new PlayingInfoPanel();
        add(gameScreen);
        add(playingInfoPanel);

    }

    public static void main(String args[]){
        PlayScreen playScreen = new PlayScreen();
        playScreen.setVisible(true);
    }


}
