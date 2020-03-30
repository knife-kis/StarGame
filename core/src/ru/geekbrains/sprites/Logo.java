package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;

public class Logo extends Sprite {
    public Logo(Texture texture) throws GameException {
        super(new TextureRegion(texture));
    }

    @Override
    public void update(float delta) {

        if (Gdx.input.justTouched()) {
            dst.set(Gdx.input.getX(), 600 - Gdx.input.getY());
        }
        pos.mulAdd(dst.cpy().sub(pos).nor(), delta);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        pos.set(worldBounds.pos);
        pos.set(-0.33f,-0.5f);
    }
}
