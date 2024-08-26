package com.example.projeto_pdm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.projeto_pdm.databinding.ActivityTelaPrincipalBinding;

public class Tela_Principal extends AppCompatActivity {

    ActivityTelaPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        binding = ActivityTelaPrincipalBinding.inflate(getLayoutInflater());

        View magicoView = findViewById(R.id.magico);
        View tracoView = findViewById(R.id.traco);
        View matchView = findViewById(R.id.match);
        ImageButton pesquisa = binding.imagePesquisa;
        
        pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_Principal.this, PesquisaActivity.class);
                startActivity(intent);
            }
        });

        magicoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_Principal.this, PesquisaActivity.class);
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


    }// fim on Create
}
