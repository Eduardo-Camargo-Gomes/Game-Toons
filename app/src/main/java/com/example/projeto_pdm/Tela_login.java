package com.example.projeto_pdm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Tela_login extends AppCompatActivity {

    private EditText etApelido, etSenha;
    private Spinner spinnerIdade;
    private CheckBox checkBox;
    private final String senhaCorreta = "12345"; // Definição da senha correta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        // Inicializa os componentes da interface
        etApelido = findViewById(R.id.edit_apelido);
        etSenha = findViewById(R.id.edit_senha);
        spinnerIdade = findViewById(R.id.spinner_idade);
        checkBox = findViewById(R.id.checkBox);
        AppCompatButton button = findViewById(R.id.button);

        // Definir a cor do texto dos EditText como preto
        etApelido.setTextColor(Color.BLACK);
        etSenha.setTextColor(Color.BLACK);

        // Configura o Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.idade_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdade.setAdapter(adapter);

        // Configura o OnCheckedChangeListener para o CheckBox
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(Tela_login.this, "CheckBox marcado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Tela_login.this, "CheckBox desmarcado", Toast.LENGTH_SHORT).show();
            }
        });

        // Configura o botão de avançar
        button.setOnClickListener(v -> {
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
            }
        });

        // Configura o OnFocusChangeListener para o EditText apelido
        etApelido.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                Toast.makeText(getApplicationContext(), "Apelido está usando o onFocus!", Toast.LENGTH_SHORT).show();
            }
        });

        // Configura o OnFocusChangeListener para o EditText senha
        etSenha.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                Toast.makeText(getApplicationContext(), "Senha está usando o OnFocus!", Toast.LENGTH_LONG).show();
            }
        });

        // Configura o OnItemSelectedListener para o Spinner idade
        spinnerIdade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) { // Ignora o item de "Idade" como um item selecionado
                    Toast.makeText(getApplicationContext(), "Idade selecionada!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Não faz nada quando nenhum item é selecionado
            }
        });
    }
}