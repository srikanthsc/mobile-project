package com.srikanthsc.myapplication; // nom du package
// import
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityADAdMob extends AppCompatActivity {
    private Button buttonAD;//creation d'une variable prive variable pour le bouton de retour
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_d); // mise en page du bouton dans le fichier activity_a_d_d.xml


        buttonAD = (Button) findViewById(R.id.buttonR);  // identifiant du bouton
        buttonAD.setOnClickListener(new View.OnClickListener() {  // le code execute ce qui est   ecrit dans onClick (View) après que l'utilisateur a appuyé sur le bouton.
            @Override
            public void onClick(View v) {  // permet l'appel d'instance setOnClickListener interne, et permet de donner l'atribut du bouton
                openActivityReturn(); // appel de la methode pour le retour a la page principale de l'application
            }
        });
    }

    private void openActivityReturn() {  // creation de la methode


        Intent intent = new Intent(this,MainActivity.class); // les intents sont des messages asynchrones qui permettent aux composants d'application de demander des fonctionnalités à partir d'autres composants Android.
        startActivity(intent); //est utilisée pour démarrer une nouvelle activité
    }
}