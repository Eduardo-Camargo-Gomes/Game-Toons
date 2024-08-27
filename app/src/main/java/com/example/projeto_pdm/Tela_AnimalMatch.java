package com.example.projeto_pdm;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela_AnimalMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_animal_match);
        Button btnterminar = findViewById(R.id.button_terminar);
        CardView cardArara = findViewById(R.id.arara);
        CardView cardVaca = findViewById(R.id.vaca);
        CardView cardElefante = findViewById(R.id.elefante);
        CardView cardGuaxinim = findViewById(R.id.guaxinim);
        CardView cardGaivota = findViewById(R.id.gaivota);
        CardView cardPassaro = findViewById(R.id.passaro);
        TextView pontuacao = findViewById(R.id.textPontuacao);

        GestureDetector gestureDetector1 = new GestureDetector(this,new SwiperListener(cardArara));








    }// fim onCreate
}// fim Classe