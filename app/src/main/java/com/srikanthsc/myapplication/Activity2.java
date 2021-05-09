package com.srikanthsc.myapplication;

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



public class Activity2 extends AppCompatActivity {
    private WebView webViewwho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        webViewwho = (WebView) findViewById(R.id.webview);
        webViewwho.setWebViewClient(new WebViewClient());
        webViewwho.loadUrl("https://covid19.who.int/");

        WebSettings webSettings = webViewwho.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webViewwho.canGoBack()) {
            webViewwho.goBack();
        } else {
            super.onBackPressed();
        }
    }

    }
