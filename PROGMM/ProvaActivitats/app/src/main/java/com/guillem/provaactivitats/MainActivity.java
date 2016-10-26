package com.guillem.provaactivitats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSegona = (Button) findViewById(R.id.btn_segona);
        btnSegona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIEM SEGONA ACTIVITAT
                Intent intent = new Intent(MainActivity.this, SegonaActivity.class);
                intent.putExtra("id", 27);
                intent.putExtra("title", "Prova");
                startActivity(intent);
            }
        });
    }
}
