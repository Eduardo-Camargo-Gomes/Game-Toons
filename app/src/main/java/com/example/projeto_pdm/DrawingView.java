package com.example.projeto_pdm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {

    private Paint paint;
    private List<Point> points;
    private Point lastPoint = null;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED); // Cor inicial
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND); // Linhas com extremidades arredondadas

        points = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Desenhar linhas suaves
        if (points.size() > 1) {
            for (int i = 1; i < points.size(); i++) {
                Point point = points.get(i);
                Point prevPoint = points.get(i - 1);

                if (prevPoint != null && point != null) {
                    canvas.drawLine(prevPoint.x, prevPoint.y, point.x, point.y, paint);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastPoint = new Point(x, y);
                points.add(lastPoint);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                Point newPoint = new Point(x, y);
                points.add(newPoint);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                lastPoint = null;
                break;
        }
        return true;
    }

    public void setPaintColor(int color) {
        paint.setColor(color);
    }

    public void clearDrawing() {
        points.clear();
        invalidate();
    }

    private static class Point {
        float x, y;

        Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
