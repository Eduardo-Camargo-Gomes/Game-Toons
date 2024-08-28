package com.example.projeto_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Tela_DesafioTraco extends AppCompatActivity {

    private DrawingView drawingView;
    private Button buttonChangeImage;
    private Button buttonFinish;
    private ImageView translucentImage;
    private TextView textTracejadoMagico;
    private boolean imageVisible = true;
    private boolean hasFinished = false;
    private int currentImageIndex = 0; // Índice da imagem atual

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_desafio_traco);

        drawingView = findViewById(R.id.drawingView);
        buttonChangeImage = findViewById(R.id.button);
        buttonFinish = findViewById(R.id.button_terminar);
        translucentImage = findViewById(R.id.translucentImage);
        textTracejadoMagico = findViewById(R.id.texTracejadomagico);

        buttonChangeImage.setOnClickListener(v -> {
            changeImage(); // Troca a imagem e limpa o desenho
            drawingView.clearDrawing(); // Limpa o desenho
        });

        buttonFinish.setOnClickListener(v -> {
            if (hasFinished) {
                // Se já terminou, mostra a imagem e o desenho
                translucentImage.setVisibility(View.VISIBLE);
                hasFinished = false;
            } else {
                // Se ainda não terminou, oculta a imagem e o desenho permanece
                // Esta @VISIBLE, porque no traço o desnho não pode sumir
                translucentImage.setVisibility(View.VISIBLE);
                showToast("Parabéns, agora mostre ao seu responsável!!");
                Intent intent = new Intent(Tela_DesafioTraco.this, Tela_Principal.class);
                startActivity(intent);
                hasFinished = false;
            }


        });
    }

    private void changeImage() {
        // Array com as imagens e nomes
        int[] imageResources = {
                R.drawable.caminhogalinha,
                R.drawable.caminhoestrela,
                R.drawable.caminhonoel
        };

        String[] imageNames = getResources().getStringArray(R.array.image_names);

        // Atualiza o índice da imagem atual
        currentImageIndex = (currentImageIndex + 1) % imageResources.length;

        // Troca a imagem e o texto
        translucentImage.setImageResource(imageResources[currentImageIndex]);
        //muda o texto junto com a imagemo
        //textTracejadoMagico.setText(imageNames[currentImageIndex]);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
