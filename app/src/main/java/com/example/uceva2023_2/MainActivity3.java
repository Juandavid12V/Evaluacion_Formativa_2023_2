package com.example.uceva2023_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView tv3;
    int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Bundle received = getIntent().getExtras();
        tv3 = findViewById(R.id.tv3);
        tv3.setText(received.getString("username") + "" + received.getString("passwd"));

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy",Toast.LENGTH_LONG).show();
    }

    public void Volver(View d){
        //Toast.makeText(this, "Hola 2", Toast.LENGTH_LONG).show();
        Intent ir = new Intent(this, MainActivity2.class);
        startActivity(ir);
    }

    public void contar(View d){
        contador++;
        tv3.setText("Contador: "+ contador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.agree) {
            Toast.makeText(this, "agree", Toast.LENGTH_LONG).show();
        } else if (id == R.id.badThread) {
            Toast.makeText(this, "badThread", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contadorEjemplo",contador);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contadorEjemplo");
    }
}