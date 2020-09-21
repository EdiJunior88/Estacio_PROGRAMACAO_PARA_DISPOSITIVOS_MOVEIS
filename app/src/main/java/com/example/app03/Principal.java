package com.example.app03;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class Principal extends Activity implements View.OnClickListener, CheckBox.OnCheckedChangeListener {

    private CheckBox ckbCi;
    private CheckBox ckbFu;
    private CheckBox ckbGa;
    private CheckBox ckbIn;
    private CheckBox ckbLi;
    private CheckBox ckbTe;
    private TextView txtSel;
    private Button btnEx;
    private Button btnDes;
    private int cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckbCi = (CheckBox)findViewById(R.id.ckbCinema);
        ckbFu = (CheckBox)findViewById(R.id.ckbFutebol);
        ckbGa = (CheckBox)findViewById(R.id.ckbGastronomia);
        ckbIn = (CheckBox)findViewById(R.id.ckbInformatica);
        ckbLi= (CheckBox)findViewById(R.id.ckbLiteratura);
        ckbTe = (CheckBox)findViewById(R.id.ckbTeatro);
        txtSel = (TextView)findViewById(R.id.txtSel);
        btnEx = (Button)findViewById(R.id.btnExibir);
        btnDes = (Button)findViewById(R.id.btnDesmarcar);
        ckbCi.setOnCheckedChangeListener(this);
        ckbFu.setOnCheckedChangeListener(this);
        ckbGa.setOnCheckedChangeListener(this);
        ckbIn.setOnCheckedChangeListener(this);
        ckbLi.setOnCheckedChangeListener(this);
        ckbTe.setOnCheckedChangeListener(this);
        btnEx.setOnClickListener(this);
        btnDes.setOnClickListener(this);

        cont = 0;
        exibirSelecionados();
    }

    private void exibirSelecionados(){
        //Recuperar o texto no TextView
        String txt = getResources().getString(R.string.txt_selecionados);
        txtSel.setText(String.format("%s = %d", txt, cont));
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnExibir:
                String txt = "Temas Selecionados\n\n";
                txt += ckbCi.isChecked()?"Cinema\n":"";
                txt += ckbFu.isChecked()?"Futebol\n":"";
                txt += ckbGa.isChecked()?"Gastronomia\n":"";
                txt += ckbIn.isChecked()?"Informática\n":"";
                txt += ckbLi.isChecked()?"Literatura\n":"";
                txt += ckbTe.isChecked()?"teatrio\n":"";

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage(txt);
                dlg.setPositiveButton("OK", null);
                dlg.show();
                break;

            case R.id.btnDesmarcar:
                ckbCi.setChecked(false);
                ckbFu.setChecked(false);
                ckbGa.setChecked(false);
                ckbIn.setChecked(false);
                ckbLi.setChecked(false);
                ckbTe.setChecked(false);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if (isChecked == true){
            cont++;
        } else {
            cont--;
        }
        exibirSelecionados();
    }
}