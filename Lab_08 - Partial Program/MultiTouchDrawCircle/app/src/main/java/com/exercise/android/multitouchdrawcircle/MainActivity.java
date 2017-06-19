package com.exercise.android.multitouchdrawcircle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View drawView = new DrawableView(this);
        setContentView(drawView);
        drawView.requestFocus();
    }
}
