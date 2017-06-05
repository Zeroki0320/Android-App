package com.exercise.android.storageexercise;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends ActionBarActivity {

    private final static String NOTES = "notes.txt";

    private EditText txtData;
    private Button btnWriteSDFile;
    private Button btnReadSDFile;
    private Button btnClearScreen;
    private Button btnClose;
    private CheckBox cbSDCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind GUI elements with local controls
        txtData = (EditText) findViewById(R.id.txtData);
        btnWriteSDFile = (Button) findViewById(R.id.btnWriteSDFile);
        btnReadSDFile = (Button) findViewById(R.id.btnReadSDFile);
        btnClearScreen = (Button) findViewById(R.id.btnClearScreen);
        btnClose = (Button) findViewById(R.id.btnClose);
        cbSDCard = (CheckBox) findViewById(R.id.cbSDCard);

        // Restore preference
        SharedPreferences settings = getSharedPreferences("my_preferred_Choices", Context.MODE_PRIVATE);
        Boolean prefSDCard = settings.getBoolean("prefSDCard", false);
        if (prefSDCard)
            cbSDCard.setChecked(true);

    }

    public void buttonClick(View view) {

        switch (view.getId()) {

            case R.id.btnWriteSDFile:
                // write on SD card file data from the text box
                if (cbSDCard.isChecked()) {
                    try{
                        File myFile= new File("/sdcard/mysdfile.txt");
                        myFile.createNewFile();
                        FileOutputStream fOut = new FileOutputStream(myFile);
                        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                        myOutWriter.append(txtData.getText());
                        myOutWriter.close();
                        fOut.close();
                        Toast.makeText(getBaseContext(),
                                "Writing SD - mysdfile.txt", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                // write as file
                else {
                    try {
                        OutputStreamWriter out = new OutputStreamWriter(openFileOutput(NOTES, 0));
                        out.write(txtData.getText().toString());
                        out.close();
                        Toast.makeText(getBaseContext(),
                                "Writing file - Notes.txt'", Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.btnReadSDFile:
                // Read from the SD card
                if (cbSDCard.isChecked()) {
                    try{
                        // Part(c)-codes for reading the file form SD card *******
                        File myFile= new File("/sdcard/mysdfile.txt");
                        myFile.createNewFile();
                        FileOutputStream fOut = new FileOutputStream(myFile);
                        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                        myOutWriter.append(txtData.getText());
                        myOutWriter.close();
                        Toast.makeText(getBaseContext(), "Reading SD - mysdfile.txt", Toast.LENGTH_LONG).show();
                    }
                    catch(Exception e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                // Read from file
                else {
                    try {
                        InputStream in = openFileInput(NOTES);
                        if (in!=null) {
                            InputStreamReader tmp = new InputStreamReader(in);
                            BufferedReader reader = new BufferedReader(tmp);
                            String str;
                            StringBuffer buf = new StringBuffer();
                            while ((str= reader.readLine()) != null) {
                                buf.append(str+"\n");
                            }
                            in.close();
                            txtData.setText(buf.toString());
                            Toast.makeText(getBaseContext(),
                                    "Reading file - Notes.txt'", Toast.LENGTH_SHORT).show();

                        }//if
                    }
                    catch (java.io.FileNotFoundException e) {
                        // that's OK, we probably haven't created it yet
                    }
                    catch(Exception e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                break;


            case R.id.btnClearScreen:
                // clear text box
                txtData.setText("");
                break;

            case R.id.btnClose:
                finish();
                break;
        }
    }

    @Override
    protected void onStop(){
        super.onStop();


        SharedPreferences settings = getSharedPreferences("my_preferred_Choices", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("prefSDCard", cbSDCard.isChecked());
        editor.commit();

    }
}
