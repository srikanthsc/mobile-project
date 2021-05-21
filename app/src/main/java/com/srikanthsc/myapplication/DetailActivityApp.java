package com.srikanthsc.myapplication;//nom du package
//import
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivityApp extends AppCompatActivity implements Interface_ActivityDetails {
    //declaration des variable
    private Button button;
    private Button button2;
    private Button button3;
    private  int positionCountry;
    private Button button4;
    private Button button5_ADD;
    private Button button6;






    TextView tCountry, tCases, tRecovered, tCritical, tActive, tTodayCases, tTotalDeaths, tTodayDeaths;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();






        positionCountry = intent.getIntExtra("position", 0);

        getSupportActionBar().setTitle("Details : " + Countries.countriesModelsList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }//activite
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openActivity3();//activite
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity4();//activite
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivityOKHTTP();//activite pour Okhttp client http
            }
        });

        button5_ADD = (Button) findViewById(R.id.button5);
        button5_ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityADD();//activite
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityr();//activite
            }
        });





        

        tCountry = findViewById(R.id.tCountry);
        tCases = findViewById(R.id.tCases);
        tRecovered = findViewById(R.id.tRecovered);
        tCritical = findViewById(R.id.tCritical);
        tActive = findViewById(R.id.tActive);
        tTodayCases = findViewById(R.id.tTodayCases);
        tTotalDeaths = findViewById(R.id.tDeaths);
        tTodayDeaths = findViewById(R.id.tTodayDeaths);

        tCountry.setText(Countries.countriesModelsList.get(positionCountry).getCountry());
        tCases.setText(Countries.countriesModelsList.get(positionCountry).getCases());
        tRecovered.setText(Countries.countriesModelsList.get(positionCountry).getRecovered());
        tCritical.setText(Countries.countriesModelsList.get(positionCountry).getCritical());
        tActive.setText(Countries.countriesModelsList.get(positionCountry).getActive());
        tTodayCases.setText(Countries.countriesModelsList.get(positionCountry).getTodayCases());
        tTotalDeaths.setText(Countries.countriesModelsList.get(positionCountry).getDeaths());
        tTodayDeaths.setText(Countries.countriesModelsList.get(positionCountry).getTodayDeaths());


    }



    private void openActivityr() {

        Intent intent = new Intent(this, Retrofit.class);
        startActivity(intent);
    }


    //ouvrir le admob de google
    private void openActivityADD() {

        Intent intent = new Intent(this, AdTestAdMob.class);
        startActivity(intent);
    }
// fin de la methode pour le admob

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //methode pour defiler la liste et selectionner l'items
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public void openActivity2() { // methode pour ouvrir activite
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


    public void openActivity3() {//methode pour ouvrir activite
        Intent intent = new Intent(this, Vaccine.class);
        startActivity(intent);
    }

    public void openActivity4() {//methode pour ouvrir activite
        Intent intent = new Intent(this, Inform.class);
        startActivity(intent);
    }

    private void openActivityOKHTTP() {// methode pour ouvrir activite


        Intent intent = new Intent(this,Okhttp_Test.class);
        startActivity(intent);
    }
}


