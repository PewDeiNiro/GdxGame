package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	Player player;
	
	@Override
	public void create () {
		player = new Player(new Texture("player.png"), 300, 0);
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		keyBoardControl();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(player.getTexture(), player.getX(), player.getY());
		int random = (int)(Math.random() * 200 + 1);
		if (random == 10){
			Weapon weapon  = new Weapon(new Texture("weapon.png"), (int)(Math.random() * 600 + 1), 200);
			batch.draw(weapon.getTexture(), weapon.getX(), weapon.getY());
			System.out.println("spawn");
		}
		batch.end();
	}

	public void keyBoardControl(){
		if (Gdx.input.isKeyPressed(Input.Keys.A)){
			player.setLocation(player.getX() - player.SPEED, player.getY());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)){
			player.setLocation(player.getX() + player.SPEED, player.getY());
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
