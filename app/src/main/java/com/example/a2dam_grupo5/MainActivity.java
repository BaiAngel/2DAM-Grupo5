package com.example.a2dam_grupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    private EditText mUser;
    private EditText mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = (EditText) findViewById(R.id.usuatio_log);
        mPass = (EditText) findViewById(R.id.password_log);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void launchHomepage(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        String user = mUser.getText().toString();
        String pass = mPass.getText().toString();
        String userData = "";
        String passData = "";
        //new FetchUser(user, pass).execute(userData, passData);
        TextView mUserr = (TextView) findViewById(R.id.usuatio_log);
        TextView mPasss = (TextView) findViewById(R.id.password_log);
        if (mUserr.getText().toString().equals("admin") && mPasss.getText().toString().equals("admin")||mUserr.getText().toString().equals("arnau") && mPasss.getText().toString().equals("arnau1")||mUserr.getText().toString().equals("sadfg") && mPasss.getText().toString().equals("1234")) {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
        }

    }
}