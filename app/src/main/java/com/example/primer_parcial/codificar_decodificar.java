package com.example.primer_parcial;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class codificar_decodificar extends AppCompatActivity {

    EditText entrada;
    Button codificar, decodificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codificar_decodificar);
        entrada = (EditText) findViewById(R.id.imput_text);
        codificar = (Button) findViewById(R.id.codificate);
        decodificar = (Button) findViewById(R.id.decodificate);

        decodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoOriginal = entrada.getText().toString();
                String textoCodificado = codificarTexto(textoOriginal);
                entrada.setText(textoCodificado);
            }
        });

        codificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoCodificado = entrada.getText().toString();
                String textoDecodificado = decodificarTexto(textoCodificado);
                entrada.setText(textoDecodificado);
            }
        });
    }

    private String codificarTexto(String texto) {
        texto = texto.replace('a', '@');
        texto = texto.replace('e', '3');
        texto = texto.replace('i', '1');
        texto = texto.replace('o', '8');
        texto = texto.replace('u', '5');
        texto = texto.replace('m', '&');
        texto = texto.replace('n', '(');
        texto = texto.replace('p', ')');
        texto = texto.replace('r', '#');

        return texto;
    }

    private String decodificarTexto(String texto) {
        texto = texto.replace('@', 'a');
        texto = texto.replace('3', 'e');
        texto = texto.replace('1', 'i');
        texto = texto.replace('8', 'o');
        texto = texto.replace('5', 'u');
        texto = texto.replace('&', 'm');
        texto = texto.replace('(', 'n');
        texto = texto.replace(')', 'p');
        texto = texto.replace('#', 'r');

        return texto;
    }
}