package com.example.a2dam_grupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Home extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void launchHomepage(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void launchMappage(View view){
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    public void launchShoppage(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
    }
}