package com.example.primer_parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText salida, entrada;
    Spinner opciones;
    Button calcular ,generar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida = findViewById(R.id.numeros_output);
        entrada = findViewById(R.id.numeros_imput);
        opciones = findViewById(R.id.numeros_opciones);
        calcular = findViewById(R.id.boton_calcular);
        generar = findViewById(R.id.boton_generar);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedPosition = opciones.getSelectedItemPosition();
                String[] data= entrada.getText().toString().split(",");
                switch (selectedPosition) {
                    case 0:
                        double sumatoria = 0;
                        for (int i = 0; i < data.length; i++) {
                          sumatoria += Double.parseDouble(data[i]);
                        }
                        double promedio =sumatoria/data.length;
                        salida.setText(String.valueOf(promedio));
                        break;
                    case 1:
                        String par = "pares: ";
                        String impar = "impares: ";
                        for (int i = 0; i < data.length; i++) {
                            if (Integer.parseInt(data[i]) % 2 == 0) {
                            par = par + data[i] + ", ";
                            } else {
                                impar = impar + data[i] + ", ";
                            }
                        }
                        String par_e_impar = par + impar;
                        salida.setText(par_e_impar);
                        break;
                    case 2:
                        quickSort(data, 0, data.length - 1);
                        salida.setText(Arrays.toString(data));
                        break;
                }
            }
        });

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int longitud = random.nextInt(20) + 1;
                StringBuilder numbers = new StringBuilder();
                for (int i = 0; i < longitud; i++) {
                    if (i > 0) {
                        numbers.append(",");
                    }
                    numbers.append(random.nextInt(201) - 100);
                }
                entrada.setText(numbers.toString());
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.decodificar_codificar) {
            Intent i = new Intent(getApplicationContext(), codificar_decodificar.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (Integer.parseInt(arr[j]) < Integer.parseInt(pivot)) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

