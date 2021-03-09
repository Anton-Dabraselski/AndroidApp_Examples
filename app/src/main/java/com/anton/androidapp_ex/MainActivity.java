package com.anton.androidapp_ex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private EditText login;
    public Button btn, close, act_calculator;
    final  String TAG = "MainActivity";
    final String _login = "anton";
    final String _pass = "12345";

    TextView loginpass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        Log.i(TAG, "OnCreate");

        loginpass = findViewById(R.id.textView4);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = findViewById(R.id.editTextTextPersonName);
                pass = findViewById(R.id.editTextTextPassword);

                btn.setText("Done!");
                btn.setBackgroundColor(Color.RED);

                String login_ = login.getText().toString();
                String pass_ = pass.getText().toString();
                //int pass_ = Integer.parseInt(pass.getText().toString());

                Log.i(TAG, "Login: " + login_ + " Password: " + pass_);

                if(login_.equals(_login)  && pass_.equals(_pass)){
                    Toast.makeText(getApplicationContext(), "Login: " + login_ +", Password: " + pass_, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login and password is not correct!", Toast.LENGTH_LONG).show();
                }
                //loginpass.setText("Login:" + login_ + ", Password: " + pass_);
                //Toast.makeText(getApplicationContext(), "Login:" + login_ + ", Password: " + pass_, Toast.LENGTH_LONG).show();
                login.setText("");
                pass.setText("");
            }
        });

        close = findViewById(R.id.button3);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("Attention! Do you want to close this application?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
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
                alert.setTitle("Close application");
                alert.show();
                Log.i(TAG, "OnClick - Close app");
            }
        });

        act_calculator = findViewById(R.id.bnt_calculator);
        act_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart");
    }

    public void addListenerOnButton(){

    }

}