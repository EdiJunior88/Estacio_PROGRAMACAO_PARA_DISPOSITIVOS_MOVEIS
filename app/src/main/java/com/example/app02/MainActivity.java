package com.example.app02;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    //ATRIBUTOS
    private EditText edtPeso;
    private EditText edtAltura;
    private EditText edtResultado;
    private Button btnCalcular;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERENCIAR OS CONTROLES
        edtPeso = (EditText)findViewById(R.id.edtPeso);
        edtAltura = (EditText)findViewById(R.id.edtAltura);
        edtResultado = (EditText)findViewById(R.id.edtResultado);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);

        //ASSOCIAR TRATADOR DE EVENTOS
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //TRATADOR DE EVENTOS
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnCalcular){
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado = (peso / Math.pow(altura, 2));

            edtResultado.setText(String.format("%.2f", resultado));
        } else if (v.getId() == R.id.btnLimpar){
            edtPeso.setText("");
            edtAltura.setText("");
            edtResultado.setText("");
            edtPeso.requestFocus();
        }
    }
}