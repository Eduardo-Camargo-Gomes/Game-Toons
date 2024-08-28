package com.example.projeto_pdm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
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

        // Configuração do GestureDetector para detectar duplo toque
        GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                // Ações quando ocorre um duplo toque
                Toast.makeText(Tela_TracejadoMagico.this, "Duplo toque detectado!", Toast.LENGTH_SHORT).show();
                return super.onDoubleTap(e);
            }
        });

        drawingView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        // Listener para mudar a imagem e apagar as linhas ao clicar no botão "Mudar"
        button.setOnClickListener(v -> {
            currentImageIndex = (currentImageIndex + 1) % images.length;
            imageView.setImageResource(images[currentImageIndex]);
            textView.setText(getResources().getTextArray(R.array.image_names)[currentImageIndex]);
            drawingView.clearDrawing(); // Apaga o desenho ao mudar a imagem
        });

        // Listeners para mudar a cor do desenho
        colorButton1.setOnClickListener(v -> drawingView.setPaintColor(Color.RED));
        colorButton2.setOnClickListener(v -> drawingView.setPaintColor(Color.BLUE));
        colorButton3.setOnClickListener(v -> drawingView.setPaintColor(Color.GREEN));
        colorButton4.setOnClickListener(v -> drawingView.setPaintColor(Color.YELLOW));
        colorButton5.setOnClickListener(v -> drawingView.setPaintColor(Color.BLACK));

        // Listener para ocultar e mostrar a imagem e o desenho ao clicar no botão "Terminar"
        buttonTerminar.setOnClickListener(v -> {
            if (isImageVisible) {
                imageView.setVisibility(View.INVISIBLE);
                drawingView.setVisibility(View.VISIBLE); // Faz o desenho aparecer
                // Exibe a mensagem rápida
                Toast.makeText(Tela_TracejadoMagico.this, "Parabéns, agora mostre ao seu responsável!!", Toast.LENGTH_SHORT).show();
                // Descomente as linhas abaixo se desejar redirecionar para outra atividade
                // Intent intent = new Intent(Tela_TracejadoMagico.this, Tela_Principal.class);
                // startActivity(intent);
            } else {
                imageView.setVisibility(View.VISIBLE);
                drawingView.setVisibility(View.VISIBLE); // Garante que o desenho esteja visível para interação
            }
            isImageVisible = !isImageVisible; // Alterna o estado de visibilidade
        });
    }
}