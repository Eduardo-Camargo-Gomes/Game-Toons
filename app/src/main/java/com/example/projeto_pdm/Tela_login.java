package com.example.projeto_pdm;

import android.content.Intent;
import android.graphics.Color; // Adicione esta linha
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projeto_pdm.databinding.ActivityTelaLoginBinding;

public class Tela_login extends AppCompatActivity {

    private EditText etApelido, etSenha;
    private Spinner spinnerIdade;
    private Button button;
    private final String senhaCorreta = "12345"; // Definição da senha correta


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        etApelido = findViewById(R.id.edit_apelido);
        etSenha = findViewById(R.id.edit_senha);
        spinnerIdade = findViewById(R.id.spinner_idade);
        button = findViewById(R.id.button);

        // Definir a cor do texto dos EditText como preto
        etApelido.setTextColor(Color.BLACK);
        etSenha.setTextColor(Color.BLACK);

        String[] idades = new String[101];
        idades[0] = "Idade";
        for (int i = 1; i <= 100; i++) {
            idades[i] = String.valueOf(i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, idades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdade.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apelido = etApelido.getText().toString();
                String senha = etSenha.getText().toString();
                String idade = spinnerIdade.getSelectedItem().toString();

                if (apelido.isEmpty() || senha.isEmpty() || idade.equals("Idade")) {
                    Toast.makeText(Tela_login.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else if (!senha.equals(senhaCorreta)) {
                    Toast.makeText(Tela_login.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Tela_login.this, Tela_Principal.class);
                    startActivity(intent);
                }// fim else
            }// fim onClick
        });// fim listener utton

        etApelido.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Toast.makeText(getApplicationContext(),"Apelido está usando o onFocus!", Toast.LENGTH_SHORT).show();
                }// fim if
            }// fim onFocs
        });// fim anonma

        etSenha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                }// fim if
                Toast.makeText(getApplicationContext(), "Senha está usando o OnFocus!", Toast.LENGTH_LONG).show();

            }// fim onFocus
        });// fim anonimo



        spinnerIdade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Idade selecionada!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }// fim OnCreate
}// fim classe
