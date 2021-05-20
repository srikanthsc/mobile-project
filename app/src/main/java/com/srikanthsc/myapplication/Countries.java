package com.srikanthsc.myapplication; // nom du package
// import
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Countries extends AppCompatActivity implements Insterface_Countries  {  // classe avec une implementation

    EditText edtSearch; // initialisation de la variable
    ListView listView; // initialisation de la variable
    SimpleArcLoader simpleArcLoader; // initialisation de la variable

    public static List<CountriesModel> countriesModelsList = new ArrayList<>();  // methode qui contient la liste
    CountriesModel countriesModel; //  instanciation
    CustomAdapter customAdapter; // instanciation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries); // mise en page pour la classe Countries

        edtSearch = findViewById(R.id.edtSearch);  //id identifiant de la bare de recherche
        listView = findViewById(R.id.listView); // id identifiant de la liste
        simpleArcLoader = findViewById(R.id.loader); //id identifiant du chargement

        getSupportActionBar().setTitle("Countries"); // Titre attribuer sur la barre d'application
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Pour définir plusieurs options d'affichage
        getSupportActionBar().setDisplayShowHomeEnabled(true);//spécifie si le bouton Accueil a ou non la flèche utilisée pour la navigation

        fetchData(); //appel de la methode

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //permet de cliquer sur la liste
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // creation de la methode
                startActivity(new Intent(getApplicationContext(), DetailActivityApp.class).putExtra("position",position)); // ouvrir ou consulter une nouvelle activiter
            }
        });


        edtSearch.addTextChangedListener(new TextWatcher() { // barre de recherche
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { // methode utiliser pour appelé avant que les modifications aient été appliquées au texte

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { //appelée après les modifications du texte.

                customAdapter.getFilter().filter(s); //Renvoie un filtre qui peut être utilisé pour contraindre les données avec un modèle de filtrage
                customAdapter.notifyDataSetChanged(); // permet de signaler que les donnees sont actualiser

            }

            @Override
            public void afterTextChanged(Editable s) { // modifier le texte dans TextView partir de cette méthode.

            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //appelé chaque fois qu'un élément de votre menu d'options est sélectionné.
        if(item.getItemId()==android.R.id.home)




                                                finish();


        
        return super.onOptionsItemSelected(item);
    }

    private void fetchData() {  //creation de la methode fetchData() pour utiliser l'api

        //String url  = "https://corona.lmao.ninja/v2/countries/";
        String url  = "http://www.json-generator.com/api/json/get/bTzfdlcXSa?indent=2"; // API stocker sur le serveur initilisation avec une variable
        simpleArcLoader.start();// le chargemenent commence avec le Arcloader

        StringRequest request = new StringRequest(Request.Method.GET, url, //objet StringRequest request
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { //methode onResponse

                        try { // gerer les execption avec try catch
                            JSONArray jsonArray = new JSONArray(response); // objet JSONArray

                            for(int i=0;i<jsonArray.length();i++){  //parcourir la liste du fichier json qui se trouve sur le serveur
                                // prend on compte 10 variable pour afficher le resultat sur l'ecran
                                JSONObject jsonObject = jsonArray.getJSONObject(i); // json prend on compte les variables qui si trouve sur ce fichier

                                String countryName = jsonObject.getString("country"); // variable contryname
                                String cases = jsonObject.getString("cases");// variable cases
                                String todayCases = jsonObject.getString("todayCases"); //variable todayCases
                                String deaths = jsonObject.getString("deaths"); // variable deaths
                                String todayDeaths = jsonObject.getString("todayDeaths"); // variable todayDeaths
                                String recovered = jsonObject.getString("recovered"); // variable recovered
                                String active = jsonObject.getString("active"); // variable active
                                String critical = jsonObject.getString("critical"); //variable critical

                                JSONObject object = jsonObject.getJSONObject("countryInfo"); // variable object
                                String flagUrl = object.getString("flag"); // variable flagUrl

                                countriesModel = new CountriesModel(flagUrl,countryName,cases,todayCases,deaths,todayDeaths,recovered,active,critical);
                                countriesModelsList.add(countriesModel);


                            }

                            customAdapter = new CustomAdapter(Countries.this, countriesModelsList);
                            listView.setAdapter(customAdapter);
                            simpleArcLoader.stop();// arreter le chargement
                            simpleArcLoader.setVisibility(View.GONE);






                        } catch (JSONException e) { // traite les exeptions
                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                Toast.makeText(Countries.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

}