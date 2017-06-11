package com.exercise.android.networkgreeting1b;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    private DownloadTask task = null;

    private class DownloadTask extends ????<String, Void, String> {
        @Override
        protected String doInBackground(String... values) {
            String reply = "";
            try {
                // prepare URL and execute http request
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet(values[0]);
                HttpResponse response = client.execute(request);

                // process http response
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println("reply:" + line);
                    reply += line;
                }
                Log.d("doInBackground", "get data complete");
                rd.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return reply;
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void ????(String result) {
            textViewGreeting.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTextUrl = (EditText) findViewById(R.id.edTextUrl);
        textViewGreeting = (TextView) findViewById(R.id.textViewGreeting);
    }

    public void getGreeting(View view) {
        if (task == null || task.getStatus().equals(AsyncTask.Status.FINISHED)) {
            textViewGreeting.setText("Loading...");
            task = new DownloadTask();
            ????.????(edTextUrl.getText().toString());
        }
    }

    public void changeRed(View view) {
        textViewGreeting.setBackgroundColor(Color.RED);
    }

    public void changeGreen(View view) {
        textViewGreeting.setBackgroundColor(Color.GREEN);
    }
}
