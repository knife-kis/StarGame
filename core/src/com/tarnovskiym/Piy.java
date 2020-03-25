package com.tarnovskiym;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Piy {
    private TextureRegion textureRegion;
    private Vector2 position;
    private Vector2 valocity;
    private Vector2 tmp;
    private boolean active;

    public Piy(TextureAtlas atlas){
        this.textureRegion = atlas.findRegion("Piy");
        this.position = new Vector2(0,0);
        this.valocity = new Vector2(0,0);
        this.tmp = new Vector2(0,0);
        this.active = false;
    }

    public void render(SpriteBatch batch){
        if(active){
            batch.draw(textureRegion, position.x - 8, position.y - 8, 8, 8, 16,16,1,1, 0);
        }
    }

    public void update(float dt){
        if(active){
            position.mulAdd(valocity, dt);
            if(position.y > 840){
                deactivate();
            }
        }
    }
    public void setup(float x, float y, float targetX, float targetY){
        if (!active) {
            position.set(x, y);
            valocity.set(targetX, targetY).sub(x, y).nor().scl(500.0f);
            active = true;
        }
    }

    private void deactivate() {
        active = false;
    }
}
