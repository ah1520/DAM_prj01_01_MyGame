package com.dam.mygame;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnJouer;
    private EditText etNumber;
    private TextView tvResult;

    int nbUser, nbRandom;

    private static final String TAG = "MainActivity";


    /** Méthode d'initialisation des widgets // lien Java et design */
    private void initUI(){
        btnJouer = findViewById(R.id.btnJouer);
        etNumber = findViewById(R.id.etNumber);;
        tvResult= findViewById(R.id.tvResult);
    }

    //private method(){
        //Utilise initUI
    //}

    private void generateRandomNumber(){
        Random rand = new Random();
        nbRandom = rand.nextInt(6);
    }

    /**Première méthode pour ajouter une action au bouton*/
    public void devine(View view){
        String nb = etNumber.getText().toString().trim();
        nbUser = Integer.parseInt(nb);
        
        //Affichage dans le log
        Log.i(TAG, "le nombre random est : "+nbRandom + " Le nb de l'utilisateur est "+ nbUser);

        //while (true) {
            if (nb =="") {
                nb = etNumber.getText().toString().trim();
                nbUser = Integer.parseInt(nb);
            } else {
                nb = etNumber.getText().toString().trim();
                nbUser = Integer.parseInt(nb);

                if (nbRandom == nbUser) {
                    tvResult.setText(" Bravo! Vous avez deviné mon nombre");
                    tvResult.setVisibility(View.VISIBLE);

                    etNumber.setText("");
                    generateRandomNumber();
                } else if (nbUser > 5 || nbUser < 0) {
                    tvResult.setText(" Veuillez saisir un nombre entre 0 et 5!");
                    tvResult.setVisibility(View.VISIBLE);
                } else {
                    tvResult.setText(" Le nombre n'est pas le bon, rejouer...");
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        //}
    }

    /**Ajouter une action au bouton*/
    public void devine2(View view) {
        btnJouer.setOnClickListener(new OnClickListener() {

            //nbUser = etNumber.getText().toString().trim();
            @Override
            public void onClick (View v){
                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText(nbUser);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo: à faire

        initUI();
        generateRandomNumber();
        tvResult.setText("");
        etNumber.setText("");

        btnJouer.setOnClickListener(new OnClickListener() {
            //nbUser = etNumber.getText().toString().trim();
            @Override
            public void onClick (View v){
                String saisie = etNumber.getText().toString().trim();
                if (saisie == "")
                    tvResult.setText("Veuillez saisir un nombre entre 0 et 5");
                else {
                    tvResult.setVisibility(View.VISIBLE);
                    devine(v);
                }
            }
        });

    }
}