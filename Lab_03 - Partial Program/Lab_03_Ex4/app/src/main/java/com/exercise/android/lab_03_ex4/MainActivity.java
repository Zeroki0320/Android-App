package com.exercise.android.lab_03_ex4;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ListActivity {

    private TextView selection;
    private String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items =getResources().getStringArray(R.array.planets_array);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,items));
        selection=(TextView)findViewById(R.id.selection);



    }

    public void onListItemClick(ListView parent, View v, int position, long id){
        selection.setText(items[position]);
    }
}
