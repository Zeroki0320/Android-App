package com.exercise.android.intentresultsexercise;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class GameActivity extends ActionBarActivity {
    private long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        startTime = System.currentTimeMillis();
        TextView tvName = (TextView) findViewById(R.id.TVname);
        TextView tvTrial = (TextView) findViewById(R.id.TVtrial);
        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("name"));
        tvTrial.setText(""+intent.getIntExtra("trial", 0));
    }

    public void onFinish(View view) {
        finish();
    }

    @Override
    public void finish() {
        long finishTime = System.currentTimeMillis();
        int elapsedTime = (int) (finishTime-startTime)/1000;
        Intent result = new Intent();
        result.putExtra("playTime", elapsedTime+"");
        setResult(RESULT_OK, result);
        super.finish();
    }
}
