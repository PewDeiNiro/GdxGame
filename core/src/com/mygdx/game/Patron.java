package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Patron {

    public final String LEFT = "left", RIGHT = "right";
    private int x, y;
    private Texture texture;
    private String side;
    private boolean isAlive;
    private final int SPEED = 8;

    public Patron(Texture texture, int x, int y, String side){
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.side = side;
        isAlive = true;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getSide(){
        return side;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public Texture getTexture(){
        return texture;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setTexture(Texture texture){
        this.texture = texture;
    }

    public void setLocation(int x, int y){
        setX(x);
        setY(y);
    }

    public void dead(){
        isAlive = false;
    }

    public int getSPEED(){
        return SPEED;
    }

    public void flyPatron(){
        if (side.equals(LEFT)){
            x -= SPEED;
        }
        else{
            x += SPEED;
        }
    }


}
