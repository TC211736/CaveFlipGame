package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TitleScreen extends ScreenAdapter {

    MyGdxGame game;
    ShapeRenderer shape;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font12;


    public TitleScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
        shape = new ShapeRenderer();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("testFont.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;
        font12  = generator.generateFont(parameter);
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(1, 0, 0, 1);
        shape.rect(170, 290, 300, 300);
        shape.setColor(1, 0, 0, 1);
        shape.rect(810, 290, 300, 300);
        shape.setColor(1, 0, 0, 1);
        shape.rect(1450, 290, 300, 300);
        shape.end();

        game.batch.begin();
        //font12.draw(game.batch, "Title Screen!", Gdx.graphics.getWidth() * .25f, (Gdx.graphics.getHeight() * .5f) + 50);
       // font12.draw(game.batch, "Camera Test", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .5f);
        //font12.draw(game.batch, "Press space to play.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        font12.draw(game.batch, "Shop", 250, 480);
        font12.draw(game.batch, "Play", 900, 480);
        font12.draw(game.batch, "Exit", 1550, 480);
        game.batch.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        generator.dispose();

    }
}

