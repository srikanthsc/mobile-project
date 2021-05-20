package com.srikanthsc.myapplication;//nom du package
//import
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//utilisation de Okhttp

public class Okhttp_Test extends AppCompatActivity {
    private TextView okhttp;//variable pour afficher le contenue de l'api utiliser pour afficher les pays
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp__test);

        okhttp = findViewById(R.id.text_view);
        OkHttpClient client = new OkHttpClient();
        String url = "http://www.json-generator.com/api/json/get/bTzfdlcXSa?indent=2";//url de l'api
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
    }
            @Override
            public void onResponse(Call call, Response responseok) throws IOException {
                if (responseok.isSuccessful()) {
                    final String myResponse = responseok.body().string();
                    Okhttp_Test.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            okhttp.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}
