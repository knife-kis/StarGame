package com.tarnovskiym;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private TextureRegion textureSpace;
//	private BitmapFont font32;
	private TextureAtlas atlas;
	private SpaceShip spaceShipMain;
	private Heart heart;
	private StringBuilder sb;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.atlas = new TextureAtlas("game.pack");
		this.spaceShipMain = new SpaceShip(atlas);
		this.textureSpace = atlas.findRegion("Space");
		this.heart = new Heart(atlas);
//		this.font32 = new BitmapFont(Gdx.files.internal("font32.fnt"));
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0.9f, 0.9f, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		drawSpace();
		spaceShipMain.render(batch);
		heart.render(batch);
		update(dt);
		batch.end();
	}

	public void update(float dt){
		spaceShipMain.update(dt);
	}

	private void drawSpace() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				batch.draw(textureSpace, i * 80, j * 80);
			}
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
