package com.exercise.android.ivecode;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {
    private TextView textViewUrl;
    private TextView textViewResult;
    private Button buttonGo;
    private ListView list;
    private String[] listItems;
    private DownloadTask task = null;

    private class DownloadTask extends AsyncTask<String, Void, String> {
        private Context context;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                // execute http request
                ...

                // retrieve http response and save it as a string
                String line = "";
                String reply = "";
                ...

                return reply;

            } catch (Exception e) {
                return e.getMessage();
            }
        }

        protected void onPostExecute(String result) {
            try {
                // parse json to get campus codes
                JSONObject json = new JSONObject(????);
                JSONArray codeArray = json.getJSONArray(????);
                listItems = new String[codeArray.length()];
                for (int i = 0; i < ????; i++) {
                    listItems[i] = codeArray.getJSONObject(????).getString(????);
                }

                list.setAdapter(new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, ????))

                textViewResult.setText("");

            } catch (Exception e) {
                textViewResult.setText(e.getMessage());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // store references of UI components
        ...


        // set listener for button and list
        ...
    }

    public void buttonGoOnClick(View view) {
        if (task == null || task.getStatus().equals(AsyncTask.Status.FINISHED)) {
            textViewResult.setText("Loading...");
            task = new DownloadTask(this);
            task.execute(textViewUrl.getText().toString());
        }
    }

    public void ????(AdapterView<?> a, View v, int position, long id) {
        textViewResult.setText(???? + " selected.");
    }
}
