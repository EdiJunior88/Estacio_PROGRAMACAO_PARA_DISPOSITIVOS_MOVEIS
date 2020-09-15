package com.example.somatoria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityPrincipal extends Activity {
    EditText numero1;
    EditText numero2;
    Button botaoAdicionar;
    int sum;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageone);
        numero1 = (EditText) findViewById(R.id.edtNumero1);
        numero2 = (EditText) findViewById(R.id.edtNumero2);
        botaoAdicionar = (Button) findViewById(R.id.btnSomar);
        botaoAdicionar.setOnClickListener(new AddButtonClickHandler());
    }

    public class AddButtonClickHandler implements OnClickListener{
        public void onClick(View view){
            int num1 = Integer.parseInt(numero1.getText().toString());
            int num2 = Integer.parseInt(numero2.getText().toString());
            Intent explcitIntent = new Intent(ActivityPrincipal.this,
                    ActivityResultado.class);
            explcitIntent.putExtra("SOMA", num1 + "+" + num2 + "=" + (num1 + num2));
            startActivity(explcitIntent);
        }
    }
}
