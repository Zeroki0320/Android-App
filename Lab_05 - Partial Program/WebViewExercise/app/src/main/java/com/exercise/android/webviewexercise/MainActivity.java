package com.exercise.android.webviewexercise;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    /**
     * Called when the activity is first created.
     */
    Button buttonGo;
    EditText editTextUrl;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGo = ????;
        editTextUrl = ????;
        webView = ????;

        // The following code is to force WebView to load links
        // To force the WebView to load links ...
        ...

        buttonGo.setOnClickListener(new View.OnClickListener() {
            // define an inner class to handle onClick events
            // refer to lecture notes WebViewExample.java
            ...
        });

        editTextUrl.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
            // define an inner class to handle onKey events
            // refer to lecture notes WebViewExample.java
            ...
            }
        });
    }

    public void openBrowser() {
        ...
    }
}
