package com.example.a2dam_grupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    private EditText mUser;
    private EditText mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser=(EditText) findViewById(R.id.usuatio_log);
        mPass=(EditText) findViewById(R.id.password_log);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void launchHomepage(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


}