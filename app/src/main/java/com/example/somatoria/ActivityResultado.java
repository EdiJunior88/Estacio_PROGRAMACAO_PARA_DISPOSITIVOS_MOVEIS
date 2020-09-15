package com.example.somatoria;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView resultado;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        resultado = (TextView) findViewById(R.id.resultView);
        Intent intent = getIntent();
        String sum = (String) intent.getSerializableExtra("SOMA");
        resultado.setText(sum);
    }
}