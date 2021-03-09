package com.anton.androidapp_ex;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    public Button close, btnsum, btn_enter, btn_minus, btn_mult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_act);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        EditText number = findViewById(R.id.inter_number);
        TextView txt_res = (TextView) findViewById(R.id.textView);
        btnsum = findViewById(R.id.btn_sum);
        btn_enter = findViewById(R.id.enter);
        int result = 0;
        int[] res = {0};
        int[] arr;

        btnsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(number.getText().toString());
                if(v.getId() == btnsum.getId()){
                    res[0] += num;
                    number.setText("");
                }
            }
        });

        btn_minus = findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(number.getText().toString());
                if(res[0] == 0){ res[0] = num;}
                if(v.getId() == btn_minus.getId()){
                    res[0] -= num;
                    number.setText("");
                }
            }
        });

        btn_mult = findViewById(R.id.btn_mult);
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(number.getText().toString());
                if(v.getId() == btn_mult.getId()){
                    res[0] = res[0] * num;
                    number.setText("");
                }
            }
        });


        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_res.setText(Integer.toString(res[0]));
                number.setText("");
                res[0] = 0;

              if(number.equals("")){
                  Toast.makeText(getApplicationContext(), "Enter your number!", Toast.LENGTH_LONG).show();
              }
            }
        });

        close = findViewById(R.id.button5);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Calculator.this);
                a_builder.setMessage("Attention! Do you want to close Calculator?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Close Calculator");
                alert.show();
            }
        });

    }

//    public void Calcolate(View v){
//    }


}