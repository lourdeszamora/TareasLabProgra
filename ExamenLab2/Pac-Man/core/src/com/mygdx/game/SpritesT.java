package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

/**
 * Created by Lourdes Zamora on 27/09/2015.
 */



public class SpritesT implements TweenAccessor<Sprite> {

    public static final int alpha=0;
    public int  getValues(Sprite target, int tweenType,float[] returnValues){
        switch(tweenType){
            case alpha:
                returnValues[0]=target.getColor().a;
                return 1;
            default:
                assert false;
                return -1;
        }

    }

    public void setValues(Sprite target, int tweenType,float[] newValues){

        switch(tweenType){
            case alpha:
                target.setColor(target.getColor().r,target.getColor().g,target.getColor().b,newValues[0]);

            default:
                assert false;
        }
    }
}
