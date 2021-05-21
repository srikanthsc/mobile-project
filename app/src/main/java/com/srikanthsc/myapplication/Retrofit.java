package com.srikanthsc.myapplication;//nom du package
//import
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
//probleme de configuration sur le retrofit

//retrofit pour afficher une liste de geste barriere avec une api creer


public class Retrofit extends AppCompatActivity {
   private RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        rc = findViewById(R.id.recyclerviewh);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://www.json-generator.com/api/json/get/bPifBFnKwi?indent=2")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                JSON json=retrofit.create(JSON.class);
                Call<List<ModelRetrofit>> call;
        call = json.getPost();
        call.enqueue(new Callback<List<ModelRetrofit>>() {
                    @Override
                    public void onResponse(Call<List<ModelRetrofit>> call, Response<List<ModelRetrofit>> response) {
                          if (response.isSuccessful()){
                              Toast.makeText(Retrofit.this,response.code(),Toast.LENGTH_SHORT).show();
                              return;
                          }
                          List<ModelRetrofit> retrofitList = response.body();
                          RetrofitAdapter retrofitAdapter = new RetrofitAdapter(Retrofit.this,retrofitList);

                    }

                    @Override
                    public void onFailure(Call<List<ModelRetrofit>> call, Throwable t) {
                        Toast.makeText(Retrofit.this,t.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });
    }
}