package com.example.projeto_pdm;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

        public class SwiperListener extends GestureDetector.SimpleOnGestureListener {



        int threshold = 100;
        int velocity_threshold = 100;
        View view;

            public SwiperListener(View view){
                this.view = view;
            }

        GestureDetector.SimpleOnGestureListener simpleOnGestureListener =
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {

                        float xDiff = e2.getX() - e1.getX();
                        float yDiff = e2.getY() - e1.getY();

                        if (Math.abs(xDiff) > Math.abs(yDiff)) {
                            if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold) {
                                if (xDiff > 0) {
                                    deslizaDireita();
                                }// fim if
                                else {
                                    deslizaEsquerda();
                                }// fim else

                                return true;

                            }// fim if

                        }// fim if math
                        return false;
                    }
                };

         public void deslizaDireita(){

         }// fim metodo

        public void deslizaEsquerda(){

        }// fim metodo

}// fim classe