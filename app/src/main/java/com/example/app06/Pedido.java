package com.example.app06;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pedido extends Activity implements View.OnClickListener {

    private Button btnVoltar;
    private TextView txtPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        txtPedido = (TextView)findViewById(R.id.txtPedido);
        btnVoltar.setOnClickListener(this);

        //RECEBER dados da Atividade Principaç
        Intent it = getIntent();
        String tipo = it.getStringExtra("tipo");
        String sabor = it.getStringExtra("sabor");
        int quantidade = it.getIntExtra("quantidade", 0);
        double vltotal = 0;

        if (tipo.equals("Cone")){
            vltotal = quantidade * 2.50;
        } else if (tipo.equals("Cone Duplo")){
            vltotal = quantidade * 4.50;
        } else if (tipo.equals("Picolé")){
            vltotal = quantidade * 1.50;
        } else {
            vltotal = quantidade * 8.00;
        }

        //Exibir o resultado
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo = ").append(tipo).append("\n");
        sb.append("Sabor = ").append(sabor).append("\n");
        sb.append("Quantidade = ").append(quantidade).append("\n");
        sb.append("\n").append("\n");
        sb.append("Valor Total = ").append(String.format("%.2f", vltotal)).append("\n");
        txtPedido.setText(sb.toString());
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnVoltar){
            onBackPressed();
        }
    }
}