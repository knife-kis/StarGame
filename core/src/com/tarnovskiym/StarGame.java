package com.tarnovskiym;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture grenade;
	Texture bom;
	private float x;
	private float y;
	private float t;
	private float i;
	private float xBom;
	private float yBom;
	private float sizeBomX;
	private float sizeBomY;

	@Override
	public void create () {
		batch = new SpriteBatch();
		grenade = new Texture("grenade.png");
		bom = new Texture("bom.png");
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		t++;
		Gdx.gl.glClearColor(0.1f, 0.3f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (t > 250) {
			xBom = x;
			yBom = y;
			if (i < 10) {
				i++;
				batch.draw(bom, xBom--, yBom--, sizeBomX += 15.0f, sizeBomY += 15.0f);
			}
		} else {
			update(dt, t);
			batch.draw(grenade, x, y, 30, 30);
		}
		batch.end();
	}

	public void update(float dt, float t){
		x += 50.0f * dt;
		y += 120 * dt - (t * t) / 11190;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		grenade.dispose();
		bom.dispose();
	}
}
