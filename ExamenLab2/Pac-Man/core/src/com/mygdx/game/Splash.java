package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

/**
 * Created by Lourdes Zamora on 27/09/2015.
 */
public class Splash implements Screen {
    private Sprite splash;
    private SpriteBatch Batchsplash;
    private TweenManager tManager;
    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tManager.update(delta);

        Batchsplash.begin();
        splash.draw(Batchsplash);
        Batchsplash.end();
    }

    @Override
    public void resize(int width,int height){

    }

    @Override
    public void show () {

        tManager= new TweenManager();
        Tween.registerAccessor(Sprite.class,new SpritesT());
        Batchsplash=new SpriteBatch();
        Texture SpriteTexture= new Texture("PacmanSplashScreen.png");
        splash= new Sprite(SpriteTexture);
        splash.setCenter(640 / 2, 400 / 2);
        splash.setSize(640, 400);

        Tween.set(splash, SpritesT.alpha).target(0).start(tManager);
        Tween.to(splash, SpritesT.alpha, 2).target(1).repeatYoyo(1,0.5f).setCallback(new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
               ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
            }
        }).start(tManager);
        tManager.update(Float.MIN_VALUE);
    }

    @Override
    public void hide () {

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void dispose () {
        Batchsplash.dispose();
        splash.getTexture().dispose();
    }



}
