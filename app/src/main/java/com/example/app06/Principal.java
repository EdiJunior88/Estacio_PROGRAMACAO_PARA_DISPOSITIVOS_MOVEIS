package com.example.app06;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.io.PipedOutputStream;

public class Principal extends Activity implements View.OnClickListener {

    private Spinner spTipo;
    private RadioGroup rdgSabor;
    private EditText edtQuantidade;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        spTipo = (Spinner)findViewById(R.id.spTipo);
        rdgSabor = (RadioGroup)findViewById(R.id.rdgSabor);
        edtQuantidade = (EditText)findViewById(R.id.edtQuantidade);
        btnFinalizar = (Button)findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(this);
        carregarListaTipos();
    }

    private void carregarListaTipos(){
        String tipos[] = {"cone", "Cone Duplo", "Picolé", "Sundae"};
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipos);

        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adp);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnFinalizar){

            //Caixa de Diálogo
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.app_name);
            dlg.setMessage("Tem certeza que deseja finalizar o pedido?");
            dlg.setNegativeButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    abrirAtividade();
                }
            });
            dlg.setPositiveButton("Não", null);
            dlg.show();
        }
    }

    private void abrirAtividade(){

        //Definir Parâmetros
        String tipo = spTipo.getSelectedItem().toString();

        int sabor_id = rdgSabor.getCheckedRadioButtonId();
        RadioButton rdb = (RadioButton)findViewById(sabor_id);
        String sabor = rdb.getText().toString();

        int qtde = 0;
        if (edtQuantidade.getText().length() > 0){
            qtde = Integer.parseInt(edtQuantidade.getText().toString());
        }

        //Criar Intent
        Intent it = new Intent(this, Pedido.class);
        it.putExtra("tipo", tipo);
        it.putExtra("sabor", sabor);
        it.putExtra("quantidade", qtde);
        startActivity(it);
    }
}