package com.example.projeto_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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

        cardArara.setTag("cardArara");
        cardGaivota.setTag("cardGaivota");
        cardPassaro.setTag("cardPassaro");
        cardElefante.setTag("cardElefante");
        cardGuaxinim.setTag("cardGuaxinim");
        cardVaca.setTag("cardVaca");

        GestureDetector gestureDetector1 = new GestureDetector(this,new SwiperListener(cardArara));
        GestureDetector gestureDetector2 = new GestureDetector(this,new SwiperListener(cardPassaro));
        GestureDetector gestureDetector3 = new GestureDetector(this,new SwiperListener(cardGaivota));
        GestureDetector gestureDetector4 = new GestureDetector(this,new SwiperListener(cardElefante));
        GestureDetector gestureDetector5 = new GestureDetector(this,new SwiperListener(cardGuaxinim));
        GestureDetector gestureDetector6 = new GestureDetector(this,new SwiperListener(cardVaca));

        cardArara.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return gestureDetector1.onTouchEvent(event);
            }
        });

        cardPassaro.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector2.onTouchEvent(event);
            }
        });

        cardGaivota.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector3.onTouchEvent(event);
            }
        });

        cardElefante.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector4.onTouchEvent(event);
            }
        });

        cardGuaxinim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector5.onTouchEvent(event);
            }
        });

        cardVaca.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector6.onTouchEvent(event);
            }
        });

        btnterminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_AnimalMatch.this, Tela_Principal.class);
                       startActivity(intent);
                Toast.makeText(Tela_AnimalMatch.this, "Parabéns,você concluiu o desafio!", Toast.LENGTH_SHORT).show();
            }// fim onclick
        });
    }// fim onCreate
}// fim Classe