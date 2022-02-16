package com.example.gestionefileaisa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLeggi;
    Button btnScrivi;
    TextView visualizzaFile;
    EditText nomeFile;
    Gestore gestore= new Gestore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeggi= findViewById(R.id.btnLeggi);
        btnScrivi= findViewById(R.id.btnScrivi);
        visualizzaFile= findViewById(R.id.visualizzaFile);
        nomeFile= findViewById(R.id.nomeFile);
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testo= gestore.leggiFile(nomeFile.getText().toString(), getApplicationContext());
                visualizzaFile.setText(testo);
            }
        });

        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito= gestore.scriviFile("prova.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_LONG).show();
            }
        });

    }
}