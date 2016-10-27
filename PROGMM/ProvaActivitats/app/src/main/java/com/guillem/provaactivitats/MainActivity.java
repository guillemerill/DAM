package com.guillem.provaactivitats;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnProva1 = (Button) findViewById(R.id.btn_prova1);
        btnProva1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIEM SEGONA ACTIVITAT
                Intent intent = new Intent(MainActivity.this, SegonaActivity.class);
                intent.putExtra("id", 27);
                intent.putExtra("title", "Prova");

                startActivity(intent);
            }
        });

        Button btnProva2 = (Button) findViewById(R.id.btn_prova2);
        btnProva2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.9gag.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button btnFotos = (Button) findViewById(R.id.btn_fotos);
        btnFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhotoViewer.class);
                startActivity(intent);
            }
        });
    }
}
