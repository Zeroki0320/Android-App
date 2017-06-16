package com.exercise.android.contextmenuex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    public static final int aboutBtnID = Menu.FIRST;
    public static final int exitBtnID = Menu.FIRST + 1;
    public static final int helpBtnID = Menu.FIRST + 2;
    public static final int searchBtnID = Menu.FIRST + 3;
    public static final int fileBtnID = Menu.FIRST + 4;
    public static final int openBtnID = Menu.FIRST + 5;
    public static final int saveBtnID = Menu.FIRST + 6;
    public static final int delBtnID = Menu.FIRST + 7;
    public static final int sendBtnID = Menu.FIRST + 8;
    public static final int readBtnID = Menu.FIRST + 9;

    private ImageView img_photo;
    private ImageView img_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_photo = (ImageView) findViewById(R.id.photo);
        img_mail = (ImageView) findViewById(R.id.mail);

        registerForContextMenu(img_photo);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //create a menu for img_photo
        if (v.getId() == img_photo.getId())
            populatePhotoContextMenu(menu);

        //create a menu for img_mail
        if(v.getId() == img_mail.getId())
            populateMailContextMenu(menu);
    }

    private void populatePhotoContextMenu(Menu menu) {
        menu.add(0, aboutBtnID, 0, "About");
        menu.add(0, exitBtnID, 0, "Exit");
        menu.add(0, helpBtnID, 0, "Help");
        menu.add(0, searchBtnID, 0, "Search");
        SubMenu filesubmenu = menu.addSubMenu("File");
        filesubmenu.setHeaderIcon(R.drawable.file);
        filesubmenu.add(0, openBtnID, 0, "Open");
        filesubmenu.add(0, saveBtnID, 0, "Save");
        filesubmenu.add(0, delBtnID, 0, "Delete");
    }

    private void populateMailContextMenu(Menu menu) {
        menu.add(0, sendBtnID, 0, "Send Email");
        menu.add(0, readBtnID, 0, "Read Email");
    }

    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
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
        builder.setMessage("This is a Context Menu");
        builder.setTitle("About");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }
}
