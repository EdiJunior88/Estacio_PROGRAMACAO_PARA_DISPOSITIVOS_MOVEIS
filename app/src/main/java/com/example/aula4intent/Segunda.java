package com.example.aula4intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


public class Segunda extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        TextView tv = new TextView(this);
        tv.setText("Segunda activity");
        setContentView(R.layout.activity_segunda);
        Bundle extras = getIntent().getExtras();
        Button button1 = (Button) findViewById(R.id.Button01);
        button1.setOnClickListener((view) -> {
                Intent i = new Intent(getApplicationContext(), Principal.class);
                startActivity(i);
        });
    }
}
