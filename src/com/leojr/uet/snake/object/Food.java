package com.leojr.uet.snake.object;

import com.leojr.uet.snake.common.CommonVls;

import java.awt.*;

public class Food {
    private int x;
    private int y;
    private Image worm;

    public Food(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getWorm() {
        return worm;
    }

    public void setWorm(Image worm) {
        this.worm = worm;
    }
}
