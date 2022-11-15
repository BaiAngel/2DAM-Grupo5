package com.example.a2dam_grupo5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Shop extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    FragmentTransaction Transaccion;
    Fragment Iniciofragmento,fragmentoObjetos, fragmentoPlasticos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Iniciofragmento=new Iniciofragmento();
        fragmentoObjetos =new Obj_plasticp();
        fragmentoPlasticos=new Plasticos();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments,Iniciofragmento).commit();
    }
    public void SwitchShop(View view){
        Transaccion=getSupportFragmentManager().beginTransaction();
    switch (view.getId())
    {
        case R.id.Objetos: Transaccion.replace(R.id.contenedorFragments,fragmentoPlasticos).commit();
            break;
        case R.id.Plasticos: Transaccion.replace(R.id.contenedorFragments, fragmentoObjetos).commit();
            break;
    }

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

    public void launchShoppage(View view){
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
    }
}