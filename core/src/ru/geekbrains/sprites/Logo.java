package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.exception.GameException;
import ru.geekbrains.math.Rect;

public class Logo extends Sprite {
    public Logo(Texture texture) throws GameException {
        super(new TextureRegion(texture));
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.justTouched()){
            dst.set(Gdx.input.getX(), Gdx.input.getY());
        }
        v.set(dst).sub(pos).nor();
        if (pos.dst(dst) > delta) {
            pos.mulAdd(v, delta);
        } else {
            pos.set(dst);
        }

    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        pos.set(worldBounds.pos);
    }
}
