package com.example.a2dam_grupo5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageView=(ImageView) findViewById(R.id.imagenM);
    }

    public void launchHomepage(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void launchMappage(View view){
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void launchShoppage(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
    }

    public void CambiarFTO(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult((intent.createChooser(intent,"Selecione aplicacion")),10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Uri path=data.getData();
            imageView.setImageURI(path);
        }
    }
}