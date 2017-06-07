package com.exercise.android.databasequery;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private String[] columns = {"sID", "sPassword", "sName", "sGender"};
    private RadioButton rbSID, rbAsc;
    private TableLayout tbData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbSID = (RadioButton)findViewById(R.id.rb_sID);
        rbAsc = (RadioButton)findViewById(R.id.rb_asc);
        tbData = (TableLayout)findViewById(R.id.tbData);

        initialDB();
    }

    public void initialDB() {
        // Create a database if it does not exist
        try {
            SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.exercise.android.databasequery/eBidDB",
                    null, SQLiteDatabase.CREATE_IF_NECESSARY);
            db.execSQL("DROP TABLE IF EXISTS Seller;");

            db.execSQL("CREATE TABLE Seller (sID int PRIMARY KEY, sPassword text, sName text, sGender text);");

            db.execSQL("INSERT INTO Seller(sID, sPassword, sName, sGender) values"
                    + "(1001, 'pswd1001', 'Susan', 'F'); ");
            db.execSQL("INSERT INTO Seller(sID, sPassword, sName, sGender) values"
                    + "(1002, 'pswd1002', 'Peter', 'M'); ");
            db.execSQL("INSERT INTO Seller(sID, sPassword, sName, sGender) values"
                    + "(1003, 'pswd1003', 'Wendy', 'F'); ");
            db.execSQL("INSERT INTO Seller(sID, sPassword, sName, sGender) values"
                    + "(1004, 'pswd1004', 'Mandy', 'F'); ");
            db.execSQL("INSERT INTO Seller(sID, sPassword, sName, sGender) values"
                    + "(1005, 'pswd1005', 'Josephine', 'F'); ");

            Toast.makeText(this, "Table Seller is created and initialised.",
                    Toast.LENGTH_SHORT).show();

            fillTable(db.rawQuery("select * from Seller order by sName", null));
            db.close();
        } catch (SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void fillTable(Cursor cursor) throws SQLiteException {
        tbData.removeAllViews();
        fillInfo(true, "sID", "sName", "sGender");
        while (cursor.moveToNext()) {
            fillInfo(false,
                    cursor.getString(cursor.getColumnIndex("sID")),
                    cursor.getString(cursor.getColumnIndex("sName")),
                    cursor.getString(cursor.getColumnIndex("sGender")));
        }
    }

    public void fillInfo(boolean header, String sID, String sName, String sGender) {
        TableRow tr = new TableRow(this);
        if (header)
            tr.setBackgroundColor(0x33B5E5FF);
        TextView id = new TextView(this);
        id.setText(sID);
        id.setPadding(10, 10, 10, 10);
        TextView name = new TextView(this);
        name.setText(sName);
        name.setPadding(10, 10, 10, 10);
        TextView gender = new TextView(this);
        gender.setText(sGender);
        gender.setPadding(10, 10, 10, 10);

        tr.addView(id);
        tr.addView(name);
        tr.addView(gender);
        tbData.addView(tr);
    }

    public void btnShowOnClick(View v) {
        /* check the value of radio buttons */

        String sortBy = "";
        String order = "";
        if(rbSID.isChecked())
            sortBy = "sID";
        else
            sortBy = "sName";

        if(rbAsc.isChecked())
            order = "ASC";
        else
            order = "DESC";

        try {
            /* make SQLite Database connection with read only */
            SQLiteDatabase db =SQLiteDatabase.openDatabase("/data/data/com.exercise.android.databasequery/eBidDB",null,SQLiteDatabase.OPEN_READONLY);

            /* set cursor to query the information */
            String [] args = {sortBy,order};
            Cursor cursor = db.query("Seller",columns,null,null,null,null,sortBy+" "+order);
            fillTable(cursor);

            /* close the Database */
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
