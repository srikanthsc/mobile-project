package com.srikanthsc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Vaccine extends AppCompatActivity {


    RecyclerView rcv;

    int[] programImage={R.drawable.jj,R.drawable.moderna,R.drawable.pfizer};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        rcv=(RecyclerView)findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        String arr[]={"Moderna","Pfizer","Covishield","sputnik ","Astrazeneca",""};
        rcv.setAdapter(new ProgramAdapter(arr));



    }
}