package com.tarnovskiym;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SpaceShip {
    private Piy piy;
    private TextureRegion textureSpace;
    private Vector2 position;
    private Vector2 positionPiy;
    private float speed;
    private int hp;

    public SpaceShip(TextureAtlas atlas) {
        this.textureSpace = atlas.findRegion("SpaceShipMain");
        this.position = new Vector2(100, 10);
        this.positionPiy = new Vector2(position);
        this.piy = new Piy(atlas);
        this.speed = 300.0f;
        this.hp = 3;
    }
    public void render(SpriteBatch batch){
        batch.draw(textureSpace, position.x, position.y, 32, 26, 64, 53, 1, 1, 0.0f);
        piy.render(batch);
    }

    public void update(float dt){
        piy.update(dt);
        movingX(dt);
        piy(dt);
    }

    private void piy(float dt) {
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            piy.setup(position.x, position.y + 30, position.x, 840);
        }
        if (position.x > 840 - 64) {
            positionPiy.y = 840 - 64;
        } else {
            if(Gdx.input.isKeyPressed(Input.Keys.D)){
                positionPiy.x += speed * dt;
            }
        }
        if (position.x < 0){
            positionPiy.x = 0;
        } else {
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                positionPiy.x -= speed * dt;
            }
        }
    }

    public void renderGui(SpriteBatch batch, BitmapFont bitmapFont){

    }

    private void movingX(float dt) {
        if (position.dst(840 - 64, position.y) > speed * dt) {
            if(Gdx.input.isKeyPressed(Input.Keys.D)){
                position.x += speed * dt;
            }
        }

        if (position.dst(0, position.y) > speed * dt) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                position.x -= speed * dt;
            }
        }
    }


}
