package com.srikanthsc.myapplication;   // nom du package
// import
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


// creation d'une webview
// definition webview: permet d'afficher les contenus Web dans les applications Android
public class Activity2 extends AppCompatActivity {
    private WebView webViewwho; // creation d'une variable webview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);  // acces a la layout de la webview

        webViewwho = (WebView) findViewById(R.id.webview); // id identifiant de la webview

        webViewwho.setWebViewClient(new WebViewClient()); // permet d'obtenir le webview client

        webViewwho.loadUrl("https://covid19.who.int/");  // url pour afficher le contenue dans la webview

        WebSettings webSettings = webViewwho.getSettings(); //permet Gèrer l'état des paramètres pour une WebView. Lorsqu'une WebView est créée pour la première fois, elle obtient un ensemble de paramètres par défaut
        webSettings.setJavaScriptEnabled(true); //permet  d'activer le JavaScript en appelant la méthode setJavaScriptEnabled (true) sur les paramètres Web pour une WebView.
    }
    @Override
    public void onBackPressed() {   // methode qui permet d'appelé lorsque l'activité a détecté la pression de l'utilisateur sur la touche Retour
        if (webViewwho.canGoBack()) {  // permet d'obtient une WebView a un élément d'historique de retour
            webViewwho.goBack();   // permet de naviguez en arrière dans l'historique du navigateur
        } else {
            super.onBackPressed();  //  détecte la pression de l'utilisateur sur la touche Retour.
        }
    }

    }
