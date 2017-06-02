package com.exercise.android.lab_03_ex3;

import android.provider.MediaStore;
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

        rbAdd = (RadioButton)findViewById(R.id.rbAdd);
        rbSub = (RadioButton)findViewById(R.id.rbSub);
        rbMul = (RadioButton)findViewById(R.id.rbMul);
        rbDiv = (RadioButton)findViewById(R.id.rbDiv);
        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        etNum1 = (EditText)findViewById(R.id.etNum1);
        etNum2 = (EditText)findViewById(R.id.etNum2);



    }

    public void btnCalculateOnClick(View view) {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ans = 0;
                double value1 =Double.parseDouble(etNum1.getText().toString());
                double value2 =Double.parseDouble(etNum2.getText().toString());
                if(rbAdd.isChecked()){
                    ans = value1+value2;
                }
                if(rbSub.isChecked()){
                    ans = value1-value2;
                }
                if(rbMul.isChecked()){
                    ans = value1*value2;
                }
                if(rbDiv.isChecked()){
                    ans= value1/value2;
                }
                tvAnswer.setText((int) ans);
            }
        });
    }
}
