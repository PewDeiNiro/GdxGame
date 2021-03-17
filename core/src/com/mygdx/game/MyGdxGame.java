package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class MyGdxGame extends ApplicationAdapter {

	static SpriteBatch batch;
	Player player;
	ArrayList<Weapon> weapons = new ArrayList<>();
	Label counter;
	
	@Override
	public void create () {
		player = new Player(new Texture("playerLeft.png"), new Texture("playerRight.png"),300, 0);
		batch = new SpriteBatch();
		counter = new Label("0", new Label.LabelStyle(new BitmapFont(), Color.RED));
		counter.setX(600);
		counter.setY(450);

	}

	@Override
	public void render () {
		for (int i = 0; i < weapons.size(); i++){
			weapons.get(i).iteration();
		}
		keyBoardControl();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(new Texture("background.png"), 0, 0);
		batch.draw(player.getTexture(), player.getX(), player.getY());
		int random = (int)(Math.random() * 200 + 1);
		if (random == 10){
			Weapon weapon  = new Weapon(new Texture("weapon.png"), (int)(Math.random() * 600 + 1), 500, player);
			weapons.add(weapon);
		}
		for (int i = 0; i < weapons.size(); i++){
		    Weapon weapon = weapons.get(i);
		    if (weapon.isAlive()){
				batch.draw(weapon.getTexture(), weapon.getX(), weapon.getY());
			}
		    else{
		    	weapons.remove(i);
			}
        }

		counter.setText(player.getCount() + "");
		counter.draw(batch, 1);
		player.flyPatrons();
		batch.end();
	}

	public void keyBoardControl(){
		if (Gdx.input.isKeyPressed(Input.Keys.A)){
			player.setLocation(player.getX() - player.SPEED, player.getY());
			player.setSide(player.LEFT);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)){
			player.setLocation(player.getX() + player.SPEED, player.getY());
			player.setSide(player.RIGHT);
		}
		if (player.getX() < -8){
			player.setX(-8);
		}
		else if (player.getX() > 550){
			player.setX(550);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			dispose();
		}
		if (true){
			player.shoot();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

}
