package com.exercise.android.lab_03_ex3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    /** Called when the activity is first created. */
    private RadioGroup rgOperator;
    private RadioButton rbAdd, rbSub, rbMul, rbDiv ;
    private Button btnCalculate;
    private EditText etNum1, etNum2;
    private TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*** TO BE COMPLETED ***/
    }

    public void btnCalculateOnClick(View view) {
        /*** TO BE COMPLETED ***/
    }
}
