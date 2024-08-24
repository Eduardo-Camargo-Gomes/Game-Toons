package com.example.projeto_pdm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tela_Principal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        // Encontre as Views pelo ID
        View magicoView = findViewById(R.id.magico);
        View tracoView = findViewById(R.id.traco);
        View matchView = findViewById(R.id.match);

        magicoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_Principal.this, Tela_TracejadoMagico.class);
                startActivity(intent);
            }
        });

        tracoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_Principal.this, Tela_DesafioTraco.class);
                startActivity(intent);
            }
        });

        matchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_Principal.this, Tela_AnimalMatch.class);
                startActivity(intent);
            }
        });
    }
}
