package com.mcprog.bleu.piece;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mcprog.bleu.lib.Assets;

public class Tile {

	private Texture normal;
	private Texture activated;
	private int x;
	private int y;
	private int state;
	
	private static final int STATE_NORMAL = 0;
	private static final int STATE_ACTIVATED = 1;
	private static final int STATE_ERROR = 2;
	
	public Tile (int x, int y) {
		this.x = x;
		this.y = y;
		state = 0;
		normal = Assets.tile;
		activated = Assets.loadingSheet;
	}
	
	public void draw (SpriteBatch batch, Vector3 touch) {
		if (touch.x > x && touch.x < x + 64 && touch.y > y && touch.y < y + 64) {
			activate();
		}
		if (state == STATE_NORMAL) {
			batch.draw(normal, x, y);
		}
		else if (state == STATE_ACTIVATED) {
			batch.draw(activated, x, y);
		}
		else if (state == STATE_ERROR) {
			batch.draw(Assets.agrande, x, y);
		}
	}
	
	public void activate () {
		if (state == STATE_NORMAL) {
			state = STATE_ACTIVATED;
		}
		else if (state == STATE_ACTIVATED) {
			state = STATE_ERROR;
		}
	}
}
