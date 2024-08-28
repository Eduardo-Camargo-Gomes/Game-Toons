package com.example.projeto_pdm;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Primeira_tela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentMainAcitivty = new Intent(
                        Primeira_tela.this,
                        Tela_login.class);
                startActivity(intentMainAcitivty);
                finish();
            }
        },3000);
    }
}