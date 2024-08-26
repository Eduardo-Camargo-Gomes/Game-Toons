package com.example.projeto_pdm;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.example.projeto_pdm.databinding.ActivityPesquisaBinding;
import com.example.projeto_pdm.databinding.CardListaBinding;

import java.util.ArrayList;
import java.util.List;

public class CardsAdapter extends BaseAdapter {

    List<Card> listaCartao;
    List<Card> listaCartaoCompleta;
    Context context;
    LayoutInflater inflater;
    CardListaBinding binding;



    public CardsAdapter(List<Card> listaCartao, Context context) {
        this.listaCartao = new ArrayList<>(listaCartao);
       this.listaCartaoCompleta = new ArrayList<>(listaCartao);
        this.context = context;
    }


    @Override
    public int getCount() {
        return listaCartao.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCartao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public void filter(String texto){
            listaCartao.clear();

            if(texto.isEmpty()){
                listaCartao.addAll(listaCartaoCompleta);
            }//fim if

        else{
            String filtragem = texto.toLowerCase().trim();

            for(Card cartao : listaCartaoCompleta){
                if(cartao.getNomeJogo().toLowerCase().trim().contains(filtragem)){
                    listaCartao.add(cartao);
                }//fim if
            }// fim for
            }// fim else
        notifyDataSetChanged();
    }// fim metodo

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       if(convertView == null){
           binding = CardListaBinding.inflate(LayoutInflater.from(context),parent,false);
           convertView = binding.getRoot();
           convertView.setTag(binding);
       }//fim if
        else{
            binding = (CardListaBinding)convertView.getTag();
       }
        View cartao = binding.cartaoItem;
        ImageView imagemJogo = binding.imagemItem;
        TextView nomeJogo = binding.nomeJogoItem;
        TextView descricaoJogo = binding.descricaoJogoLista;

        // modificacoes
        imagemJogo.setImageResource(listaCartao.get(position).getImagemJogo());
        nomeJogo.setText(listaCartao.get(position).getNomeJogo());
        descricaoJogo.setText(listaCartao.get(position).getDescricaoJogo());

        binding.getRoot().setCardBackgroundColor(ContextCompat.getColor(context, listaCartao.get(position).getCordeFundo() ));

        return convertView ;
    }// fim getView
}// fim classe
