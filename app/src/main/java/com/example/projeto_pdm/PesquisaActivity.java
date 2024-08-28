package com.example.projeto_pdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.projeto_pdm.databinding.ActivityPesquisaBinding;
import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    ActivityPesquisaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        binding = ActivityPesquisaBinding.inflate(getLayoutInflater());

        EditText barraPesquisa = findViewById(R.id.edit_pesquisa);
        ListView listView = findViewById(R.id.lista_cards);
        List<Card> cartoes = new ArrayList<>();

            Card cartao1 = new Card(R.drawable.img3,"Tracejado mágico", "Complete a forma dos animais com criatividade", R.color.vermelho);
            Card cartao2 = new Card(R.drawable.img4,"Desafio do traço", "Trace o melhor caminho para chegar ao objetivo!", R.color.azul);
            Card cartao3 = new Card(R.drawable.img5,"Animal match", "Arraste corretamente e marque pontos!", R.color.amarelo);
            cartoes.add(cartao1);
            cartoes.add(cartao2);
            cartoes.add(cartao3);

            CardsAdapter adaptador = new CardsAdapter(cartoes,PesquisaActivity.this);

           barraPesquisa.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
               adaptador.filter(s.toString());
                }// fim override

                @Override
                public void afterTextChanged(Editable s) {
                }// fim metodo
            });

        listView.setAdapter(adaptador);
    }// fim onCreate
}// fim classe