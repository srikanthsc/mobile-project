package com.srikanthsc.myapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Interface_MainActivity {
    View view, view1; // variable view qui permet  de construction de base de l'interface utilisateur

    private Button button; // variable bouton



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// layout de la page pricipale


        button = (Button) findViewById(R.id.button); // identifiant du bouton
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            } //permet d'ouvrier l'activite
        });


        ImageView Myimageview = findViewById(R.id.imageView2);
          getSupportActionBar().setDisplayShowHomeEnabled(true);
          getSupportActionBar().setIcon(R.drawable.ic_baseline_today_24); // utilisation d'un vector asset dans la bare

    }



    public void ListCountries(View view) { // methode pour la liste des pays


        startActivity(new Intent(getApplicationContext(), Countries.class)); // ouvrir la page

    }

    public void openActivity2(){ //methode pour ouvrir l'activite
        Intent intent = new Intent(this, MyMap.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
