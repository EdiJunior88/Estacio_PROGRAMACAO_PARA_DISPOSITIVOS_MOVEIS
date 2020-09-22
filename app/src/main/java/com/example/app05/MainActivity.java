package com.example.app05;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Spinner spnNomes;
    private Spinner spnCidades;
    private Button btnCadastrar;
    private List<String> listaCidadades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnNomes = (Spinner) findViewById(R.id.spnNomes);
        spnCidades = (Spinner) findViewById(R.id.spnCidades);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        spnNomes.setOnItemSelectedListener(this);
        spnCidades.setOnItemSelectedListener(this);
        btnCadastrar.setOnClickListener(this);

        carregarListaNomes();
        carregarListaCidades();
    }

    //CARREGAR lista de nomes do RESOURCE
    private void carregarListaNomes() {
        ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource(this, R.array.lista_nomes, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNomes.setAdapter(adp);
    }

    //CARREGAR lista de cidades do ARRAYLIST
    private void carregarListaCidades() {
        listaCidadades = new ArrayList<String>();
        listaCidadades.add("Americana");
        listaCidadades.add("Araraquara");
        listaCidadades.add("Batatais");
        listaCidadades.add("Campinas");
        listaCidadades.add("Limeira");
        listaCidadades.add("Ribeirão Preto");
        listaCidadades.add("São Paulo");

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaCidadades);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCidades.setAdapter(adp);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCadastrar) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.app_name);
            dlg.setMessage("");
            dlg.setPositiveButton("OK", null);
            dlg.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Exibir item selecionado
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}