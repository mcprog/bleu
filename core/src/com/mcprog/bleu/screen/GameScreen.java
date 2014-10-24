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
import com.badlogic.gdx.math.Vector3;
import com.mcprog.bleu.Bleu;
import com.mcprog.bleu.lib.Assets;
import com.mcprog.bleu.lib.BleuConstants;
import com.mcprog.bleu.piece.Tile;

public class GameScreen implements Screen {

	private Bleu game;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle rect1;
	private Tile tile1;
	private Tile[][] tiles;
	
	private float stateTime;
	private Vector3 touch;
	
	public GameScreen(Bleu game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, BleuConstants.WIDTH, BleuConstants.HEIGHT);
		
		batch = new SpriteBatch();
		
		rect1 = new Rectangle(100, 100, 100, 100);
		tiles = new Tile[9][9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				tiles[i][j] = new Tile(i * 64 + 32, j * 64 + 32);
			}
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		stateTime += delta;
		Assets.loadingFrameCurrent = Assets.loadingAnimation.getKeyFrame(stateTime * 2f, true);
		
		touch = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
//				
				tiles[i][j].draw(batch, touch);
			}
		}
		batch.end();
		
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
