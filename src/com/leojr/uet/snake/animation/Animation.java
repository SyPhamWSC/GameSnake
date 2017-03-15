package com.leojr.uet.snake.animation;

import com.leojr.uet.snake.common.CommonVls;

import java.awt.*;
import java.util.ArrayList;

public class Animation {
    private ArrayList<Image> img;
    private int type;
    private int current;

    public Animation(int type){
        this.type = type;
        img = new ArrayList<>();
        initAnimation();
        int current =0;
    }

    private void initAnimation() {
        if(type == CommonVls.SNAKE){
            img.add(CommonVls.snakeHead);//Index = 0;
            img.add(CommonVls.snakeGoDown);//Index = 1;
            img.add(CommonVls.snakeGoUp);//Index = 2;
            img.add(CommonVls.snakeGoLeft);//Index =3;
            img.add(CommonVls.snakeGoRight);//Index =4
        }
        if(type == CommonVls.FOOD){
            img.add(CommonVls.worm3);
            img.add(CommonVls.worm2);
            img.add(CommonVls.worm);
        }
    }

    public Image getCurrentImg(int direction){
        current++;
        int currentImg = 0;
        if(type == CommonVls.SNAKE){
            if(current == 0){
                currentImg = 0;
            } else if(current == 1){
                if(direction == CommonVls.GO_DOWN){
                    currentImg = 1;
                }
                if(direction == CommonVls.GO_UP){
                    currentImg = 2;
                }
                if(direction == CommonVls.GO_LEFT){
                    currentImg = 3;
                }
                if(direction == CommonVls.GO_RIGHT){
                    currentImg = 4;
                }
            }else {
                current =0;
            }
        }else if (type == CommonVls.FOOD){
            switch (current){
                case 0:
                    currentImg = 0;
                    break;
                case 1:
                    currentImg = 1;
                    break;
                case 2:
                    currentImg = 2;
                    break;
                default: current = 0;
            }
        }
        return img.get(currentImg);
    }



}
