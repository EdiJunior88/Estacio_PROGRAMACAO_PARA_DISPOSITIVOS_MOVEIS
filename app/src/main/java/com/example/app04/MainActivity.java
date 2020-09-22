package com.example.app04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup rdgAlter;
    private Button btnOK;
    private final String CORRETA="E";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgAlter = (RadioGroup)findViewById(R.id.rdgAlter);
        btnOK = (Button)findViewById(R.id.btnOK);

        rdgAlter.setOnCheckedChangeListener(this);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String txt = "";
        if (rdgAlter.getCheckedRadioButtonId() == R.id.rdbE){
            txt = "Parabéns, alternativa correta!";
        }else{
            txt = "Você não acertou, tente novamente.";
        }

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle(R.string.app_name);
        dlg.setMessage(txt);
        dlg.setPositiveButton("OK", null);
        dlg.show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
        //Retornar o TEXTO do radioButton selecionado
        RadioButton rdb = (RadioButton)findViewById(group.getCheckedRadioButtonId());

        Toast.makeText(this, rdb.getText(), Toast.LENGTH_SHORT).show();
    }
}