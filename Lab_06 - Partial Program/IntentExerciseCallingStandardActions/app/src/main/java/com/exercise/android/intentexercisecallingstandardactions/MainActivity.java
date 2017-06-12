package com.exercise.android.intentexercisecallingstandardactions;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private String[] items = {"Send SMS", "Search on Google", "Wiktionary", "Wikipedia ",
            "Show Map", "Show Street View", "Show Contact"};
    private ListView lvItem;
    Intent act;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView) findViewById(R.id.lvItem);
        lvItem.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items));

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "listitemclick", Toast.LENGTH_SHORT);

                Intent intent = null;
                switch (position) {
                    case 0:
                        act = new Intent(Intent.ACTION_VIEW);
                        act.setData(Uri.parse("sms:"));
                        startActivity(act);

                    case 1:
                        act = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.vtc.edu.hk"));
                        startActivity(act);

                    case 2:
                        act = new Intent(Intent.ACTION_VIEW,Uri.parse("https://en.wiktionary.org/wiki/android"));
                        startActivity(act);

                    case 3:
                        act = new Intent(Intent.ACTION_VIEW,Uri.parse("https://en.wikipedia.org/wiki/Android_(operating_system)"));
                        startActivity(act);

                    case 4:
                        act = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:cbll=22.3199,114.036?z=17"));
                        startActivity(act);

                    case 5:
                        act = new Intent(Intent.ACTION_VIEW,Uri.parse("google.streetview:cbll=22.3192,114.1768&cbp=1,200,,0,1"));
                        startActivity(act);

                    case 6:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/"));
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
