package com.example.projeto_pdm;

import android.graphics.Color;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

public class Card {

    int imagemJogo;
    String nomeJogo;
    String descricaoJogo;
    int cordeFundo;



    public Card(int imagemJogo, String nomeJogo, String descricaoJogo, int cordeFundo) {
        this.imagemJogo = imagemJogo;
        this.nomeJogo = nomeJogo;
        this.descricaoJogo = descricaoJogo;
        this.cordeFundo = cordeFundo;
    }


    public int getCordeFundo() {
        return cordeFundo;
    }

    public void setCordeFundo(int cordeFundo) {
        this.cordeFundo = cordeFundo;
    }

    public int getImagemJogo() {
        return imagemJogo;
    }

    public void setImagemJogo(int imagemJogo) {
        this.imagemJogo = imagemJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getDescricaoJogo() {
        return descricaoJogo;
    }

    public void setDescricaoJogo(String descricaoJogo) {
        this.descricaoJogo = descricaoJogo;
    }

} //fim classe



