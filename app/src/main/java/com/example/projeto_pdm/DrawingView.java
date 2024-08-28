package com.example.projeto_pdm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {

    private Paint paint;
    private Path path;
    private List<Stroke> strokes = new ArrayList<>(); // Lista de traços
    private int currentColor = Color.BLACK; // Cor inicial
    private float strokeWidth = 10f; // Largura do traço
    private GestureDetector gestureDetector;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                clearDrawing(); // Limpa o desenho ao detectar um toque duplo
                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Stroke stroke : strokes) {
            paint.setColor(stroke.color);
            paint.setStrokeWidth(stroke.strokeWidth);
            canvas.drawPath(stroke.path, paint); // Desenha o traço
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            return true;
        }

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(x, y);
                strokes.add(new Stroke(currentColor, strokeWidth, path)); // Adiciona um novo traço
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                path.lineTo(x, y);
                invalidate();
                break;
        }

        return true;
    }

    public void setPaintColor(int color) {
        currentColor = color;
    }

    public void clearDrawing() {
        strokes.clear();
        invalidate();
    }

    // Classe que representa um traço
    private static class Stroke {
        int color;
        float strokeWidth;
        Path path;

        Stroke(int color, float strokeWidth, Path path) {
            this.color = color;
            this.strokeWidth = strokeWidth;
            this.path = path;
        }
    }
}
