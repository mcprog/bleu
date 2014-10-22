package com.mcprog.bleu.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mcprog.bleu.Bleu;
import com.mcprog.bleu.lib.Assets;
import com.mcprog.bleu.lib.BleuConstants;

public class GameScreen implements Screen {

	private Bleu game;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle rect1;
	
	private float stateTime;
	
	public GameScreen(Bleu game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, BleuConstants.WIDTH, BleuConstants.HEIGHT);
		
		batch = new SpriteBatch();
		
		rect1 = new Rectangle(100, 100, 100, 100);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		stateTime += delta;
		Assets.loadingFrameCurrent = Assets.loadingAnimation.getKeyFrame(stateTime * 2f, true);
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		for (int i = 32; i < 64 * 9; i += 64) {
			for (int j = 32; j < 64 * 9; j += 64) {
				if (Gdx.input.getX() / 2 > i && Gdx.input.getX() / 2 < i + 64 && BleuConstants.HEIGHT - Gdx.input.getY() > j && BleuConstants.HEIGHT - Gdx.input.getY() < j + 64) {
					batch.draw(Assets.loadingSheet, i, j);
				} else {
					
					batch.draw(Assets.tile, i, j);
				}
			}
		}
		batch.end();
		System.out.println(Gdx.input.getX() + ", " + Gdx.input.getY());
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
