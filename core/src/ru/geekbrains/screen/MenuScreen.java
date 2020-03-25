package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 posImg;
    private Vector2 posKursor;
    private Vector2 tmp;
    private float speed;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        posImg = new Vector2();
        posKursor = new Vector2(0, 0);
        tmp = new Vector2();
        speed = 100;
    }

    @Override
    public void render(float delta) {
       update(delta);
       draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        posKursor.set(screenX, Gdx.graphics.getHeight() - screenY);
        return false;
    }

    private void update(float delta) {
        tmp.set(posKursor).sub(posImg).nor().scl(speed);
        if (posImg.dst(posKursor) > speed * delta){
            posImg.mulAdd(tmp, delta);
        } else {
            posImg.set(posKursor);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(0.5f, 0.7f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, posImg.x, posImg.y);
        batch.end();
    }

}
