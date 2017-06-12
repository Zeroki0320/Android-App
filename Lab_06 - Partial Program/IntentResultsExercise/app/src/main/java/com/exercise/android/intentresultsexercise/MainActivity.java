package com.exercise.android.intentresultsexercise;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MainActivity extends ActionBarActivity {
    private static final int REQUEST_CODE = 3434;
    private int trial = 0;
    Intent act ;
    Timer timer = new Timer();
    double starttime;
    private TextView TVmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TVmsg = (TextView)findViewById(R.id.TVmsg);
    }

    public void run(){
        double millis = System.currentTimeMillis() - starttime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds     = seconds % 60;

        TVmsg.setText(String.format("%d:%02d", minutes, seconds));
    }


        public void clickHandler (View view){

        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("playTime")) {
                TextView tv = (TextView) findViewById(R.id.TVmsg);

            }
        }
    }
}
