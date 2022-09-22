package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class LoginScreen extends ScreenAdapter {
    MyGdxGame game;

    public LoginScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        game.setScreen(new TitleScreen(game));

    }
}
