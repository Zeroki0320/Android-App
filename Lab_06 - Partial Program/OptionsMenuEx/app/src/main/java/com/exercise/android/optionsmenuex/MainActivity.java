package com.exercise.android.optionsmenuex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;


public class MainActivity extends ActionBarActivity {
    public static final int aboutBtnID = Menu.FIRST;
    public static final int exitBtnID = Menu.FIRST + 1;
    public static final int helpBtnID = Menu.FIRST + 2;
    public static final int fileBtnID = Menu.FIRST + 3;
    public static final int searchBtnID = Menu.FIRST + 4;
    public static final int repairBtnID = Menu.FIRST + 5;
    public static final int editBtnID = Menu.FIRST + 6;
    public static final int openBtnID = Menu.FIRST + 7;
    public static final int saveBtnID = Menu.FIRST + 8;
    public static final int delBtnID = Menu.FIRST + 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean ????(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(0, aboutBtnID, 0, "About").setIcon(R.drawable.about);
        menu.add(0, exitBtnID, 0, "Exit").setIcon(R.drawable.exit).????;
        menu.add(0, helpBtnID, 0, "Help").setIcon(R.drawable.help);

        SubMenu filesubmenu = menu.????("File").setIcon(R.drawable.file);
        filesubmenu.????(R.drawable.file);
        filesubmenu.add(0, openBtnID, 0, "Open").setIcon(R.drawable.search);
        filesubmenu.add(0, saveBtnID, 0, "Save");
        filesubmenu.add(0, delBtnID, 0, "Delete");

        menu.add(0, searchBtnID, 0, "Search").setIcon(R.drawable.search);
        menu.add(0, repairBtnID, 0, "Repair");
        menu.add(0, editBtnID, 0, "Edit");

        return true;
    }

    @Override
    public boolean ????(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.????) {
            case aboutBtnID:
                openDialog();
                break;
            case exitBtnID:
                finish();
                break;
            case delBtnID:
                finish();
                break;
        }
        return true;
    }

    public void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This is an Options Menu");
        builder.setTitle("About");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }
}
