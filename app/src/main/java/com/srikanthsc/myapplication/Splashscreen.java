package com.srikanthsc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class Splashscreen extends AppCompatActivity {
    private final int SPLASH_SCREEN_TIMEOUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);



           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(intent);
                   finish();
               }
           }, SPLASH_SCREEN_TIMEOUT);
    }
}