package com.example.projeto_pdm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Tela_TracejadoMagico extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int[] images = {R.drawable.macaco, R.drawable.porquinho, R.drawable.gatinho, R.drawable.cachorrinho};
    private boolean isImageVisible = true; // Para controlar a visibilidade da imagem

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tracejado_magico);

        Button button = findViewById(R.id.button);
        Button colorButton1 = findViewById(R.id.colorButton1);
        Button colorButton2 = findViewById(R.id.colorButton2);
        Button colorButton3 = findViewById(R.id.colorButton3);
        Button colorButton4 = findViewById(R.id.colorButton4);
        Button colorButton5 = findViewById(R.id.colorButton5);
        final ImageView imageView = findViewById(R.id.translucentImage);
        final DrawingView drawingView = findViewById(R.id.drawingView);
        final Button buttonTerminar = findViewById(R.id.button_terminar);
        final TextView textView = findViewById(R.id.texTracejadomagico);

        // Listener para mudar a imagem e apagar as linhas ao clicar no botão "Mudar"
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex = (currentImageIndex + 1) % images.length;
                imageView.setImageResource(images[currentImageIndex]);
                textView.setText(getResources().getTextArray(R.array.image_names)[currentImageIndex]);
                drawingView.clearDrawing(); // Apaga o desenho ao mudar a imagem
            }
        });

        // Listeners para mudar a cor do desenho
        colorButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(Color.RED);
            }
        });

        colorButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(Color.BLUE);
            }
        });

        colorButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(Color.GREEN);
            }
        });

        colorButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(Color.YELLOW);
            }
        });

        colorButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(Color.BLACK);
            }
        });

        // Listener para ocultar e mostrar a imagem e o desenho ao clicar no botão "Terminar"
        buttonTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImageVisible) {
                    imageView.setVisibility(View.INVISIBLE);
                    drawingView.setVisibility(View.VISIBLE); // Faz o desenho aparecer
                    // Exibe a mensagem rápida
                    Toast.makeText(Tela_TracejadoMagico.this, "Parabéns, agora mostre ao seu responsável!!", Toast.LENGTH_SHORT).show();
                } else {
                    imageView.setVisibility(View.VISIBLE);
                    drawingView.setVisibility(View.VISIBLE); // Garante que o desenho esteja visível para interação
                }
                isImageVisible = !isImageVisible; // Alterna o estado de visibilidade
            }
        });
    }
}
