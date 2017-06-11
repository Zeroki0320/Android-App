package com.exercise.android.geocoding;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {
    /**
     * Called when the activity is first created.
     */
    private EditText editTextLatitude;
    private EditText editTextLongitude;
    private TextView textViewAddress;
    private RadioGroup radioGroupLanguage;
    private Button buttonGo;
    private DownloadTask task = null;

    private class DownloadTask extends AsyncTask<String, Void, String> {

        private String url;

        public DownloadTask() {
            // prepare url
            String url =
                    "http://maps.googleapis.com/maps/api/geocode/json?latlng=";
            ...
        }

        @Override
        protected String doInBackground(String... values) {
            try {
                // execute http request
                ...

                // retrieve http response and save it as a String
                ...

                // parse json to get address; need to check status
                JSONObject json = new JSONObject(reply);
                ...
            } catch (Exception e) {
                return e.getMessage();
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            ????.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references for widgets
        ...


        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonGoOnClick();
            }
        });
    }

    public void buttonGoOnClick() {
        if (task == null || task.getStatus().equals(AsyncTask.Status.FINISHED)) {
            textViewAddress.setText("Loading...");
            task = new DownloadTask();
            task.execute();
        }
    }
}
