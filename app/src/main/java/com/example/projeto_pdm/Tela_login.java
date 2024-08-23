package com.example.projeto_pdm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Tela_login extends AppCompatActivity {

    private EditText etApelido, etEmail;
    private Spinner spinnerIdade;
    private Button btnSubmeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        etApelido = findViewById(R.id.edit_apelido);
        etEmail = findViewById(R.id.edit_senha);
        spinnerIdade = findViewById(R.id.spinner_idade);

        // Cria um array de idades e adiciona o item "Idade" como o primeiro item
        String[] idades = new String[101];
        idades[0] = "Idade";
        for (int i = 1; i <= 100; i++) {
            idades[i] = String.valueOf(i);
        }

        // Configura o ArrayAdapter com o array de idades
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, idades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdade.setAdapter(adapter);

        // Configura o evento de clique do botão
        btnSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apelido = etApelido.getText().toString();
                String email = etEmail.getText().toString();
                String idade = spinnerIdade.getSelectedItem().toString();

                Toast.makeText(Tela_login.this,
                        "Apelido: " + apelido + "\nEmail: " + email + "\nIdade: " + idade,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
