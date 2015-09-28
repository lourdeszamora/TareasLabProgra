package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;



import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;


/**
 * Created by Lourdes Zamora on 27/09/2015.
 */
public class MainMenu implements Screen {
    private Sound sound;
    private Stage stage;
    private Table table;
    private TextButton exit;

    private Skin skin;

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);

        stage.draw();

    }

    @Override
    public void resize(int width,int height){

    }

    @Override
    public void show () {
        sound = Gdx.audio.newSound(Gdx.files.internal("sounds/pacman_beginning.ogg"));
        sound.play();


        stage=new Stage();
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), new TextureAtlas("ui/atlas.pack"));

        table = new Table(skin);
        table.setFillParent(true);





        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        TextButton buttonPlay = new TextButton("PLAY", skin, "big");
        buttonPlay.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.addAction(sequence(moveTo(0, -stage.getHeight(), .5f), run(new Runnable() {

                    @Override
                    public void run() {
                        ((Game) Gdx.app.getApplicationListener()).setScreen(new Animated());
                        sound.dispose();
                    }
                })));
            }
        });
        buttonPlay.pad(20);


        exit = new TextButton("Exit", skin, "big");
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                sound.dispose();
            }
        });
        exit.pad(20);

        Label heading = new Label("PAC-MAN", skin, "big");
        heading.setFontScale(2);

        table.add(heading).spaceBottom(100).row();
        table.add(buttonPlay).spaceBottom(15).row();

        table.add(exit);

        stage.addActor(table);


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

    }
}
