package com.exercise.android.networkgreeting1a;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {
    /* Called when the activity is first created. */
    private EditText edTextUrl;
    private TextView textViewGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTextUrl = (????) findViewById(R.id.????);
        textViewGreeting = (????) findViewById(R.id.????);
    }

    public void getGreeting(View view) {
        try {
            textViewGreeting.setText("");

            // prepare URL and execute http request
            HttpClient client = new ????;
            HttpGet request = new ????;
            HttpResponse response = ????;

            // process http response
            BufferedReader rd = new ????;
            ....

            textViewGreeting.????(????);

        } catch (Exception e) {
            textViewGreeting.setText(e.getMessage());
        }
    }

    public void changeRed(View view) {
        textViewGreeting.setBackgroundColor(Color.RED);
    }

    public void changeGreen(View view) {
        textViewGreeting.setBackgroundColor(Color.GREEN);
    }
}
