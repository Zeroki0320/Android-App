package com.exercise.android.databasememberquery;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Member;


public class MainActivity extends ActionBarActivity {
    private String[] columns = {"mid", "name", "password", "age"};
    private TableLayout tbData;
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = new Result(this, (TableLayout) findViewById(R.id.tbData));
        initialDB();
    }

    public void initialDB() {
        try {
            SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.exercise.android.databasememberquery/MemberDB",
                    null, SQLiteDatabase.CREATE_IF_NECESSARY);
            /* Q2a */
            db.execSQL("DROP TABLE IF EXISTS Member;");

            /* Q2b */
            db.execSQL("CREATE TABLE Member (mid int PRIMARY KEY, name text, password text, age int);");

            /* Q2c */
            db.execSQL("INSERT INTO Member(mid, name, password, age) values "
                    + "(1001, 'Amy Carl', '12345', 16); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1002, 'Helen Leung', '88888', 25); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1003, 'Robert Chan', 'iloveu', 61); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1004, 'Carol Wong', 'peterpan', 33); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1005, 'Carman Wong', 'pooh', 44); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1006, 'John Chan', 'johnchan', 28); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1007, 'Paul Lam', 'apple', 16); ");

            Toast.makeText(this, "Table Member is created and initialised.",
                    Toast.LENGTH_SHORT).show();

            result.fillTable(db.rawQuery("SELECT * FROM Member", null));
            db.close();
        } catch (SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void btnDBInitialOnClick(View v) {
        initialDB();
    }

    public void btnActionOnClick(View v) {
        try {
            SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.exercise.android.databasememberquery/MemberDB",
                    null, SQLiteDatabase.CREATE_IF_NECESSARY);

            /* Q4a */
            // Insert
            // [code here]
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1008, 'Ronald Tang', 'ilovehk', 66); ");

            // Update
            // [code here]
            db.execSQL("UPDATE Member SET password = winnie where mid=1005 ");

            // Delete
            // [code here]
            db.execSQL("DELETE FROM Member WHERE mid = 1003")
            /* Q4b */
            // Insert
            // [code here]
            public int insert(Member member){
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(Member.mid, 1003);
                db.insert(Member.TABLE, null, values);
            }
            }
            // Update
            // [code here]

            // Delete
            // [code here]

            result.fillTable(db.query("Member", columns, null, null, null, null, null));

            db.close();
        } catch (SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
