package com.example.projeto_pdm;

import android.graphics.Color;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class SwiperListener extends GestureDetector.SimpleOnGestureListener {


        int threshold = 100;
        int velocity_threshold = 100;
        View view;



            public SwiperListener(View view){

                this.view = view;
            }

                    @Override
                    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {

                        float xDiff = e2.getX()-e1.getX();

                            if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold) {
                                if (xDiff > 0) {
                                    deslizaDireita();
                                }// fim if
                                else {
                                    deslizaEsquerda();
                                }// fim else
                                return true;
                            }// fim true

                        return false;
                    }// fim return false

         public void deslizaDireita(){
            if(view.getTag().equals("cardArara") || view.getTag().equals("cardGaivota") || view.getTag().equals("cardPassaro")){
               view.setBackgroundColor(Color.GREEN);
            }
            else{
                view.setBackgroundColor(Color.RED);
            }

         }// fim metodo

        public void deslizaEsquerda(){


            if(view.getTag().equals("cardArara") || view.getTag().equals("cardGaivota") || view.getTag().equals("cardPassaro")){
                view.setBackgroundColor(Color.GREEN);
            }
            else{
                view.setBackgroundColor(Color.RED);
            }
        }// fim metodo

            }//fim if


