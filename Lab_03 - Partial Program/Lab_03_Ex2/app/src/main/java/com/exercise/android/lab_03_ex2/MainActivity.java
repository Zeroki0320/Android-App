package com.exercise.android.lab_03_ex2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    /** Called when the activity is first created. */
    private CheckBox cbCream, cbSugar;
    private RadioGroup rgCoffeeType;
    private RadioButton rbLatte, rbMocha, rbCappuccino ;
    private Button btPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbLatte = (RadioButton)findViewById(R.id.rbLatte);
        rbMocha = (RadioButton)findViewById(R.id.rbMocha);
        rbCappuccino = (RadioButton)findViewById(R.id.rbCappuccino);
        cbCream = (CheckBox)findViewById(R.id.cbCream);
        cbSugar = (CheckBox)findViewById(R.id.cbSugar);
        btPay = (Button)findViewById(R.id.btPay);



    }

    public void btPayOnClick(View v) {
        btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg= "";

                if(rbLatte.isChecked())
                    msg += "Latte Coffee";

                if(rbMocha.isChecked())
                    msg += "Mocha Coffee";

                if(rbCappuccino.isChecked())
                    msg += "Cappuccino Coffee";

                if(cbCream.isChecked())
                    msg += "& Cream";

                if(cbSugar.isChecked())
                    msg += "& Sugar";

                Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_SHORT).show();


            }
        });
    }
}
