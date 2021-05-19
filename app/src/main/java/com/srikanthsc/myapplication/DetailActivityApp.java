package com.srikanthsc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivityApp extends AppCompatActivity implements Interface_ActivityDetails {
    private Button button;
    private Button button2;
    private Button button3;
    private  int positionCountry;
    private Button button4;


    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;


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
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityOKHTTP();
            }
        });

        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);

        tvCountry.setText(Countries.countriesModelsList.get(positionCountry).getCountry());
        tvCases.setText(Countries.countriesModelsList.get(positionCountry).getCases());
        tvRecovered.setText(Countries.countriesModelsList.get(positionCountry).getRecovered());
        tvCritical.setText(Countries.countriesModelsList.get(positionCountry).getCritical());
        tvActive.setText(Countries.countriesModelsList.get(positionCountry).getActive());
        tvTodayCases.setText(Countries.countriesModelsList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(Countries.countriesModelsList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(Countries.countriesModelsList.get(positionCountry).getTodayDeaths());


    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


    public void openActivity3() {
        Intent intent = new Intent(this, Vaccine.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, Inform.class);
        startActivity(intent);
    }

    private void openActivityOKHTTP() {


        Intent intent = new Intent(this,Okhttp_Test.class);
        startActivity(intent);
    }
}


