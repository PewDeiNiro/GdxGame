package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import javax.xml.soap.Text;
import java.util.ArrayList;

public class Player extends GameObject{

    private Texture textureLeft, textureRight;
    private int x, y;
    public final int SPEED = 4;
    private String side;
    public final String LEFT = "left", RIGHT = "right";
    private int count;
    private ArrayList<Patron> patrons = new ArrayList<>();

    public Player(Texture textureLeft, Texture textureRight, int x, int y){
        this.textureLeft = textureLeft;
        this.textureRight = textureRight;
        this.x = x;
        this.y = y;
        side = LEFT;
    }

    public Texture getTexture(){
        if (side.equals(LEFT)){
            return textureLeft;
        }
        return textureRight;
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

    public void setSide(String side){
        this.side = side.equals(LEFT) || side.equals(RIGHT) ? side.equals(LEFT) ? LEFT : RIGHT : this.side;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void shoot(){
        if (count > 0){
            Patron patron = new Patron(new Texture("weapon.png"), x, y, side);
            patrons.add(patron);
            count--;
        }
    }

    public ArrayList<Patron> getPatrons(){
        for (int i = 0; i < patrons.size(); i++){
            Patron patron = patrons.get(i);
            if (!patron.isAlive()){
                patrons.remove(i);
            }
        }
        return patrons;
    }

}
