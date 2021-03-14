package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Player {

    private Texture texture;
    private int x, y;
    public final int SPEED = 4;

    public Player(Texture texture, int x, int y){
        this.texture = texture;
        this.x = x;
        this.y = y;
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

}
