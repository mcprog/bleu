package com.mcprog.bleu.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	public static Texture loadingSheet;
	public static TextureRegion[] loadingFrames;
	public static TextureRegion loadingFrameCurrent;
	public static Animation loadingAnimation;
	public static Texture tile;

	public static void load () {
		loadingSheet = new Texture(Gdx.files.internal("loadingsheet.png"));
		TextureRegion[][] temp = TextureRegion.split(loadingSheet, 16, 16);
		loadingFrames = new TextureRegion[16];
		int index = 0;
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++ j) {
				loadingFrames[index++] = temp[i][j];
			}
		}
		
		loadingAnimation = new Animation(.2F, loadingFrames);
		
		tile = new Texture(Gdx.files.internal("tile.png"));
	}
}
