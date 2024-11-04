package com.example.dolar_real;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void comanda(View view){

        EditText editMesa;
        EditText editvalor;
        EditText editpedido;
        EditText editvgorjeta;
        TextView textResultado;

        editMesa = findViewById(R.id.editmesa);
        editpedido = findViewById(R.id.editpedido);
        editvalor = findViewById(R.id.editvalor);
        textResultado = findViewById(R.id.textResultado);
        editvgorjeta = findViewById(R.id.editvgorjeta);

        Double valorpedido = Double.parseDouble(editvalor.getText().toString());
        Double valorgorjeta = Double.parseDouble(editvgorjeta.getText().toString());

        Double valorpedidot = valorpedido+(valorpedido*(valorgorjeta/100));

        textResultado.setText(String.format("Valor Total do Pedido: R$ %.2f", valorpedidot));;


    }
}