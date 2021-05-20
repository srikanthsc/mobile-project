package com.srikanthsc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityADAdMob extends AppCompatActivity {
    private Button buttonAD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_d);


        buttonAD = (Button) findViewById(R.id.buttonR);
        buttonAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityReturn();
            }
        });
    }

    private void openActivityReturn() {


        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}