package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;

import javax.management.monitor.Monitor;
import java.awt.*;

public class Weapon extends GameObject{

    private Texture texture;
    private int x, y;
    private boolean isAlive;
    private final int G = 3;
    private Player player;

    public Weapon(Texture texture, int x, int y, Player player){
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.player = player;
        isAlive = true;

    }

    public Texture getTexture(){
        return texture;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setLocation(int x, int y){
        setX(x);
        setY(y);
    }

    public boolean isAlive(){
        return isAlive;
    }

    private void die(){
        isAlive = false;
    }

    private void checkDie(){
        if (y <= 1 || checkCollision()){
            die();
        }
        if (y <= 1){
            player.setCount(0);
        }
    }

    private void fall(){
        if (isAlive){
            y -= G;
        }
    }

    public void iteration(){
        checkDie();
        fall();
    }

    private boolean checkCollision(){
        if (Math.abs(x - player.getX()) <= 50 && Math.abs(y - player.getY()) <= 130){
            player.setCount(player.getCount() + 1);
            return true;
        }
        return false;
    }

}
