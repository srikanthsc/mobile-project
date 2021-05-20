package com.srikanthsc.myapplication;// nom du package
//import
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdTestAdMob extends AppCompatActivity {
    InterstitialAd VInterstitialAd; // creation de la variable VInterstitialAD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ad_test);// mise en page de AdTestAdMob


        MobileAds.initialize(this, new OnInitializationCompleteListener() { //Utilisé pour initialiser les bibliothèques lors du démarrage de l'application, sans avoir besoin d'utiliser
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { // methode qui prend on compte L'état de l'initialisation du SDK
                createCustominterstitial(); //appel de la methode createCustominterstitial

            }
        });
    }

    private void createCustominterstitial() { // creation de la methode
        AdRequest adRequest = new AdRequest.Builder().build(); // AdRequest contient des informations utilisées pour récupérer une annonce.


        createintersitial(adRequest);// appel de la methode avec un parametre

    }
    private void createintersitial(AdRequest adRequest) { //creation de la methode

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() { // l'identifiant du interstitial qui se trove sur le site admob
            @Override

            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {  // creation de la methode

                VInterstitialAd = interstitialAd; // initialisation de la variable interstitialAd
                Log.e("TAG", "onAdLoaded"); //message afficher dans la console
                if (VInterstitialAd != null) {
                    VInterstitialAd.show(AdTestAdMob.this); // permet  d'afficher un interstitiel
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");// message afficher dans la console
                }
                VInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { //les annonces affichent et rejettent du contenu en plein écran
                    @Override
                    public void onAdDismissedFullScreenContent() { //creation de la methode onAdDismissedFullScreenContent()

                        Log.d("TAG", "The ad was dismissed."); //  message afficher dans la cnsole
                        startActivity(new Intent(AdTestAdMob.this, ActivityADAdMob.class));// est utilisée pour démarrer une nouvelle activité
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) { //creation de ma methode   onAdFailedToShowFullScreenContent

                        Log.d("TAG", "The ad failed to show."); // message afficher dans la console
                    }

                    @Override
                    public void onAdShowedFullScreenContent() { // creation de la methode onAdShowedFullScreenContent()

                        VInterstitialAd = null; // dans le cas si la variable est null
                        Log.d("TAG", "The ad was shown."); // message afficher dans la console
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) { // creation de la methode si il y a une erreur

                Log.e("TAG", loadAdError.getMessage());// message afficher dans la console
                VInterstitialAd = null; // variable  null
            }
        });
    }}
