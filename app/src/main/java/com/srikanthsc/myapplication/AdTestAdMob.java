package com.srikanthsc.myapplication;

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
    InterstitialAd VInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ad_test);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                createCustominterstitial();

            }
        });
    }

    private void createCustominterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();


        createintersitial(adRequest);

    }
    private void createintersitial(AdRequest adRequest) {

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override

            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                VInterstitialAd = interstitialAd;
                Log.e("TAG", "onAdLoaded");
                if (VInterstitialAd != null) {
                    VInterstitialAd.show(AdTestAdMob.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
                VInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {

                        Log.d("TAG", "The ad was dismissed.");
                        startActivity(new Intent(AdTestAdMob.this, ActivityADAdMob.class));
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {

                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                        VInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                Log.e("TAG", loadAdError.getMessage());
                VInterstitialAd = null;
            }
        });
    }}
