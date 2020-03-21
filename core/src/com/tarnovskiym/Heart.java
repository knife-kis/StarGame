package com.tarnovskiym;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Heart {
    private TextureRegion textureHeart;
    private Vector2 position;

    public Heart(TextureAtlas atlas){
        this.textureHeart = atlas.findRegion("Serdce64");
        this.position = new Vector2(0,0);
    }
    public void update(float dt){

    }

    public void render(SpriteBatch batch){
        batch.draw(textureHeart, -50, 64, 64, 64, 64, 64, 0.2f, 0.2f, 0.0f);
        batch.draw(textureHeart, -50, 50, 64, 64, 64, 64, 0.2f, 0.2f, 0.0f);
        batch.draw(textureHeart, -50, 36, 64, 64, 64, 64, 0.2f, 0.2f, 0.0f);
    }
}
