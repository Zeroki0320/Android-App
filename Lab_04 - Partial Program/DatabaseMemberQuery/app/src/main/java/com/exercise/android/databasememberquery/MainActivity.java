package com.exercise.android.databasememberquery;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private String[] columns = {"mid", "name", "password", "age"};
    private TableLayout tbData;
    private RadioGroup rgCase;
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = new Result(this, (TableLayout) findViewById(R.id.tbData));
        rgCase = (RadioGroup) findViewById(R.id.rgCase);
        tbData = (TableLayout)findViewById(R.id.tbData);

        initialDB();
    }

    public void initialDB() {
        try {
            SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.exercise.android.databasememberquery/MemberDB",
                    null, SQLiteDatabase.CREATE_IF_NECESSARY);
            db.execSQL("DROP TABLE IF EXISTS Member;");

            db.execSQL("CREATE TABLE Member (mid int PRIMARY KEY, name text, password text, age int);");

            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1001, 'Amy Carl', '12345', '16'); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1002, 'Helen Leung', '88888', '25'); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1003, 'Robert Chan', 'iloveu', '61'); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1004, 'Carol Wong', 'peterpan', '33'); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1005, 'Carman Wong', 'pooh', '44'); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1006, 'John Chan', 'johnchan', '28'); ");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values"
                    + "(1007, 'Paul Lam', 'apple', '16'); ");
            /* Q3a: create a SQLite Database connection */
            // [code here]

            /* Q3b: drop the table if exits */
            // SQL hints: DROP TABLE IF EXISTS Member;
            // [code here]

            /* Q3c: create a table Member */
            // SQL hints: CREATE TABLE Member (mid int PRIMARY KEY, name text, password text, age int);
            // [code here]

            /* Q3d: populate the table Member  */
            // SQL hints: INSERT INTO Member(mid, name, password, age) values (1001, 'Amy Carl', '12345', 16);
            // [code here]

            Toast.makeText(this, "Table Member is created and initialised.",
                    Toast.LENGTH_SHORT).show();


            /* Q3e: use rawQuery to show all records in TextView*/
            result.fillTable(db.rawQuery("SELECT * FROM Member ORDER BY name",null));
            db.close();

            /* close the Database connection */
            // [code here]

        } catch (SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void btnActionOnClick(View v) {
        try {
            SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.exercise.android.databasememberquery/MemberDB",
                    null, SQLiteDatabase.OPEN_READONLY);

            Cursor cursor;
            int cnt;

            switch (rgCase.getCheckedRadioButtonId()) {
                case R.id.rbCaseF:
                    /* Q3f */
                    // [code here]
                    cursor = db.rawQuery("SELECT * FROM Member WHERE Length(password) <= 6",null);
                    result.fillTable(cursor);
                    break;

                case R.id.rbCaseG:
                    /* Q3g */
                    // [code here]
                    cursor = db.query("Member",columns,"age > 25",null,null,null,"age ASC");
                    result.fillTable(cursor);
                    break;

                case R.id.rbCaseH:
                    /* Q3h */
                    // [code here]
                    cursor = db.rawQuery("SELECT count(*) FROM Member WHERE age >= 30",null);
                    cursor.moveToNext();
                    int numC = cursor.getInt(0);
                    Toast.makeText(this, "Count = " + numC, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.rbCaseI:
                    /* Q3i */
                    // [code here]
                    cursor = db.query("Member",new String[]{"count (*)"},"age>=30",null,null,null,null);
                    cursor.moveToNext();
                    int numc = cursor.getInt(0);
                    Toast.makeText(this, "Count =" + numc, Toast.LENGTH_SHORT).show();
                    break;
            }

            db.close();
        } catch (SQLiteException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
