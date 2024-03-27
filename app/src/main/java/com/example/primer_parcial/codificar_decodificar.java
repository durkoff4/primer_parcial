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
    String textoOriginal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codificar_decodificar);
        entrada = findViewById(R.id.imput_text);
        codificar = findViewById(R.id.codificate);
        decodificar = findViewById(R.id.decodificate);

        decodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoCodificado = entrada.getText().toString();
                String textoDecodificado = decodificarTexto(textoCodificado, textoOriginal);
                entrada.setText(textoDecodificado);
            }
        });

        codificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoOriginal = entrada.getText().toString();
                String textoCodificado = codificarTexto(textoOriginal);
                entrada.setText(textoCodificado);
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

    private String decodificarTexto(String textoCodificado, String textoOriginal) {
        if (textoOriginal.isEmpty()) {
            return textoCodificado;
        }
        StringBuilder textoDecodificado = new StringBuilder();
        for (int i = 0; i < textoCodificado.length(); i++) {
            char caracterCodificado = textoCodificado.charAt(i);
            char caracterOriginal = textoOriginal.charAt(i % textoOriginal.length());
            if (caracterCodificado == '@' && caracterOriginal == 'a') {
                textoDecodificado.append('a');
            } else if (caracterCodificado == '3' && caracterOriginal == 'e') {
                textoDecodificado.append('e');
            } else if (caracterCodificado == '1' && caracterOriginal == 'i') {
                textoDecodificado.append('i');
            } else if (caracterCodificado == '8' && caracterOriginal == 'o') {
                textoDecodificado.append('o');
            } else if (caracterCodificado == '5' && caracterOriginal == 'u') {
                textoDecodificado.append('u');
            } else if (caracterCodificado == '&' && caracterOriginal == 'm') {
                textoDecodificado.append('m');
            } else if (caracterCodificado == '(' && caracterOriginal == 'n') {
                textoDecodificado.append('n');
            } else if (caracterCodificado == ')' && caracterOriginal == 'p') {
                textoDecodificado.append('p');
            } else if (caracterCodificado == '#' && caracterOriginal == 'r') {
                textoDecodificado.append('r');
            } else {
                textoDecodificado.append(caracterCodificado);
            }
        }

        return textoDecodificado.toString();
    }
}