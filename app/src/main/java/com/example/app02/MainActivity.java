package com.example.app02;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    //ATRIBUTOS
    private EditText edtPeso;
    private EditText edtAltura;
    private EditText edtResultado;
    private Button btnCalcular;
    private Button btnLimpar;
    private Object dialog;

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
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado = (peso / Math.pow(altura, 2));
            AlertDialog.Builder dlg = new
                    AlertDialog.Builder(this);
            dlg.setTitle(R.string.app_name);
            dlg.setMessage(String.format("IMC = %.2f", resultado));
            dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick (DialogInterface dialog, int which){
                }
            });
            dlg.show();
        } else if (v.getId() == R.id.btnLimpar) {
            edtPeso.setText("");
            edtAltura.setText("");
            edtResultado.setText("");
            edtPeso.requestFocus();
            Toast.makeText(this, "Os dados foram apagados com sucesso!", Toast.LENGTH_LONG).show();
        }
    }
}