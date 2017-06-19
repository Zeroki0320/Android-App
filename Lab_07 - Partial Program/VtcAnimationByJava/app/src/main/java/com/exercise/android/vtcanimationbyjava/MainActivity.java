package com.exercise.android.vtcanimationbyjava;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Vector;


public class MainActivity extends ActionBarActivity {
    private Button btnOriginal, btnReverse, btnRandom;
    private ImageView animImage;
    private AnimationDrawable originalAnim, reverseAnim, randomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animImage = (ImageView) findViewById(R.id.vtc);
        btnOriginal = (Button) findViewById(R.id.btnOriginal);
        btnReverse = (Button) findViewById(R.id.btnReverse);
        btnRandom = (Button) findViewById(R.id.btnRandom);

        originalAnim = (AnimationDrawable) getResources().getDrawable(R.drawable.vtc);
        originalAnim.setOneShot(true);
        originalAnim.setVisible(true, true);

        reverseAnim = new AnimationDrawable();
        for (int i = originalAnim.getNumberOfFrames() - 1; i >= 0; i--)
            reverseAnim.addFrame(originalAnim.getFrame(i), originalAnim.getDuration(i));
        reverseAnim.setOneShot(true);
        reverseAnim.setVisible(true, true);

        ////////////////////////////////////////
        Vector frameVector = new Vector();
        randomAnim = new AnimationDrawable();
        // copy the frames from originalAnim to frameVector

        randomAnim.addFrame(originalAnim.getFrame(0),250);
        for(int i =1;i<originalAnim.getNumberOfFrames()-1;i++){
            frameVector.add(originalAnim.getFrame(i));
        }


        // randomly remove a frame from frameVector and store it into randomAnim
        // set the duration of all frames to 250 ms
        while(!frameVector.isEmpty()){
            randomAnim.addFrame((Drawable)frameVector.remove((int)(Math.random()*frameVector.size())),250);
        }
        // append the last frame in orginalAnim to randomAnim
		randomAnim.addFrame(originalAnim.getFrame(originalAnim.getNumberOfFrames()-1),250);
        randomAnim.setOneShot(true);
        randomAnim.setVisible(true,true);


        ////////////////////////////////////////

        btnOriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animImage.setImageDrawable(originalAnim);
                originalAnim.start();
                originalAnim.setVisible(true, true);
            }
        });

        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animImage.setImageDrawable(reverseAnim);
                reverseAnim.start();
                reverseAnim.setVisible(true, true);
            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animImage.setImageDrawable(randomAnim);
                randomAnim.start();
                randomAnim.setVisible(true, true);
            }
        });
    }
}
