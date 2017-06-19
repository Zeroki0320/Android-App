package com.exercise.android.simplefingerpaint;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {
    private DrawableView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView = new DrawableView(this);
        setContentView(drawView);
        drawView.requestFocus();
    }
}
