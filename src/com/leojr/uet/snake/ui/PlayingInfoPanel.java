package com.leojr.uet.snake.ui;

import com.leojr.uet.snake.common.CommonVls;

import javax.swing.*;
import java.awt.*;

public class PlayingInfoPanel extends JPanel{
    private int level = 1;

    public PlayingInfoPanel(){
        this.setSize(272,552);

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void paint(Graphics graphics){
        //Draw BackGround
        graphics.setColor(Color.CYAN);
        graphics.fillRect(528,0, 272,552);

        //Draw String to show level of player
        graphics.setColor(Color.BLACK);
        graphics.setFont(graphics.getFont().deriveFont(28.0f));
        graphics.drawString("LEVEL: " + level,600,100);

        //Draw rectangle around panel
        graphics.setColor(Color.RED);
        graphics.drawRect(CommonVls.GAME_WIDTH,0,CommonVls.PLAY_INFO_WIDTH,CommonVls.PLAY_INFO_HEIGHT - 30);
        graphics.drawRect(CommonVls.GAME_WIDTH + 1 ,0 + 1 ,CommonVls.PLAY_INFO_WIDTH - 2,CommonVls.PLAY_INFO_HEIGHT - 32);
        graphics.drawRect(CommonVls.GAME_WIDTH + 2,0 + 2,CommonVls.PLAY_INFO_WIDTH - 4,CommonVls.PLAY_INFO_HEIGHT - 34 );
        graphics.drawRect(CommonVls.GAME_WIDTH + 3,0 + 3,CommonVls.PLAY_INFO_WIDTH - 6,CommonVls.PLAY_INFO_HEIGHT - 36);
    }
}
