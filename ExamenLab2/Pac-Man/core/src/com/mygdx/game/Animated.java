package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by Lourdes Zamora on 28/09/2015.
 */


public class Animated implements Screen {


    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private TextureRegion region;

    private SpriteBatch batchsol;
    private Texture texturesol;
    private Sprite spritesol;

//Animacion1
    private static final int        FRAME_COLS = 2;         // #1
    private static final int        FRAME_ROWS = 1;         // #2

    Animation                       walkAnimation;          // #3
    Texture                         walkSheet;              // #4
    TextureRegion[]                 walkFrames;             // #5
    SpriteBatch                     spriteBatch;            // #6
    TextureRegion                   currentFrame;           // #7

    float stateTime;                                        // #8
// Animacion2
    private static final int        FRAME_COLSf = 3;         // #1
    private static final int        FRAME_ROWSf = 1;         // #2

    Animation                       walkAnimationf;          // #3
    Texture                         walkSheetf;              // #4
    TextureRegion[]                 walkFramesf;             // #5
    SpriteBatch                     spriteBatchf;            // #6
    TextureRegion                   currentFramef;           // #7

    float stateTimef;
// Animacion3
    private static final int        FRAME_COLSf2 = 3;         // #1
    private static final int        FRAME_ROWSf2 = 1;         // #2

    Animation                       walkAnimationf2;          // #3
    Texture                         walkSheetf2;              // #4
    TextureRegion[]                 walkFramesf2;             // #5
    SpriteBatch                     spriteBatchf2;            // #6
    TextureRegion                   currentFramef2;           // #7

    float stateTimef2;
// Animacion3
    private static final int        FRAME_COLSf3 = 3;         // #1
    private static final int        FRAME_ROWSf3 = 1;         // #2

    Animation                       walkAnimationf3;          // #3
    Texture                         walkSheetf3;              // #4
    TextureRegion[]                 walkFramesf3;             // #5
    SpriteBatch                     spriteBatchf3;            // #6
    TextureRegion                   currentFramef3;           // #7

    float stateTimef3;


    @Override
    public void render (float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.setProjectionMatrix(camera.combined);




        batch.begin();

        batch.draw(region, 0, 0);

        batch.end();

        stateTime += Gdx.graphics.getDeltaTime();           // #15
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);  // #16
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, 150, 150);             // #17
        spriteBatch.end();

        stateTimef += Gdx.graphics.getDeltaTime();           // #15
        currentFramef = walkAnimationf.getKeyFrame(stateTimef, true);  // #16
        spriteBatchf.begin();
        spriteBatchf.draw(currentFramef, 50, 50);             // #17
        spriteBatchf.end();

        stateTimef2 += Gdx.graphics.getDeltaTime();           // #15
        currentFramef2 = walkAnimationf2.getKeyFrame(stateTimef2, true);  // #16
        spriteBatchf2.begin();
        spriteBatchf2.draw(currentFramef2, 120, 50);             // #17
        spriteBatchf2.end();

        stateTimef3 += Gdx.graphics.getDeltaTime();           // #15
        currentFramef3 = walkAnimationf3.getKeyFrame(stateTimef3, true);  // #16
        spriteBatchf3.begin();
        spriteBatchf3.draw(currentFramef3, 200, 50);             // #17
        spriteBatchf3.end();

        batchsol.begin();

        batchsol.draw(spritesol, 250,250);

        batchsol.end();


    }

    @Override
    public void resize(int width,int height){

    }

    @Override
    public void show () {

        batchsol= new SpriteBatch();
        texturesol= new Texture("sol.png");
        spritesol= new Sprite(texturesol);
        spritesol.setScale(50,50);


        // Estas variables las usaremos para ajustar la resolución a 800x480
        float w = 800;
        float h = 480;
        //Instanciamos Camara y le ajustamos con el metodo SetToOrtho la resolución anterior.
        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        //Instanciamos Spritebatch
        batch = new SpriteBatch();
        //Instanciamos la Textura, para ello tenemos que darle la localización dentro de la carpeta ASSETS
        texture = new Texture(Gdx.files.internal("fondo-juego.png"));
        region = new TextureRegion(texture,0,0,800,480);
//ANIMACION 1
        walkSheet = new Texture(Gdx.files.internal("PacmanAnimation.png")); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS);              // #10
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.10f, walkFrames);      // #11
        spriteBatch = new SpriteBatch();                // #12
        stateTime = 0f;                         // #13
//ANIMACION 2
        walkSheetf = new Texture(Gdx.files.internal("fantasmaazul.png")); // #9
        TextureRegion[][] tmp2 = TextureRegion.split(walkSheetf, walkSheetf.getWidth()/FRAME_COLSf, walkSheetf.getHeight()/FRAME_ROWSf);              // #10
        walkFramesf = new TextureRegion[FRAME_COLSf * FRAME_ROWSf];
        int index2 = 0;
        for (int i = 0; i < FRAME_ROWSf; i++) {
            for (int j = 0; j < FRAME_COLSf; j++) {
                walkFramesf[index2++] = tmp2[i][j];
            }
        }
        walkAnimationf = new Animation(0.2f, walkFramesf);      // #11
        spriteBatchf = new SpriteBatch();                // #12
        stateTimef = 0f;
//ANIMACION 3
        walkSheetf2 = new Texture(Gdx.files.internal("fantasmarojo.png")); // #9
        TextureRegion[][] tmp3 = TextureRegion.split(walkSheetf2, walkSheetf2.getWidth()/FRAME_COLSf2, walkSheetf2.getHeight()/FRAME_ROWSf2);              // #10
        walkFramesf2 = new TextureRegion[FRAME_COLSf2 * FRAME_ROWSf2];
        int index3 = 0;
        for (int i = 0; i < FRAME_ROWSf2; i++) {
            for (int j = 0; j < FRAME_COLSf2; j++) {
                walkFramesf2[index3++] = tmp3[i][j];
            }
        }
        walkAnimationf2 = new Animation(0.2f, walkFramesf2);      // #11
        spriteBatchf2 = new SpriteBatch();                // #12
        stateTimef2 = 0f;

//ANIMACION 4
        walkSheetf3 = new Texture(Gdx.files.internal("fantasmamorado.png")); // #9
        TextureRegion[][] tmp4 = TextureRegion.split(walkSheetf3, walkSheetf3.getWidth()/FRAME_COLSf3, walkSheetf3.getHeight()/FRAME_ROWSf3);              // #10
        walkFramesf3 = new TextureRegion[FRAME_COLSf3 * FRAME_ROWSf3];
        int index4 = 0;
        for (int i = 0; i < FRAME_ROWSf3; i++) {
            for (int j = 0; j < FRAME_COLSf3; j++) {
                walkFramesf3[index4++] = tmp4[i][j];
            }
        }
        walkAnimationf3 = new Animation(0.2f, walkFramesf3);      // #11
        spriteBatchf3 = new SpriteBatch();                // #12
        stateTimef3 = 0f;


        Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/pacman_beginning.ogg"));
        sound.play();

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
