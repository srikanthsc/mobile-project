package com.srikanthsc.myapplication;//nom du packahe
//import
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//classe utiliser pour afficher la liste des vaccins
public class Vaccine extends AppCompatActivity {


    RecyclerView rcv; //variable pour la recycleview

    int[] programImage={R.drawable.po};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        rcv=(RecyclerView)findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        String arr[]={"Moderna","Pfizer","Covishield","sputnik ","Astrazeneca",""};//creation de la liste
        rcv.setAdapter(new ProgramAdapterRecyclerView(arr));



    }
}