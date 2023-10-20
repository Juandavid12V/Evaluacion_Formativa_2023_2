package com.example.uceva2023_2;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    private String estacionActual;
    private HashMap<String, String> estacionesMap;
    private Button buttonPlay, buttonStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listViewEstaciones = findViewById(R.id.listaEstaciones);

        String[] estaciones = {
                "Radio 1",
                "Radio 2",
                "Radio 3",
                "Radio 4",
                "Radio 5"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.items_estacion,
                estaciones
        );

        listViewEstaciones.setAdapter(adapter);
        listViewEstaciones.setOnItemClickListener((parent, view, position, id) -> {
            String estacionSeleccionada = estaciones[position];
            Intent ir = new Intent(this, MainActivity3.class);
            ir.putExtra("nombreEstacion", estacionSeleccionada);
            startActivity(ir);
        });
    }

}