package com.guillem.dam.llancador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Iniciem els Buttons i els hi assignem un onClick

        Button nav = (Button) findViewById(R.id.btn_nav);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Introduïm l'enllaç i li enviem al view
                Uri uri = Uri.parse("http://www.stucom.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button img = (Button) findViewById(R.id.btn_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciem una nova layout
                Intent intent = new Intent(MainActivity.this, ImgActivity.class);
                startActivity(intent);
            }
        });

        Button telf = (Button) findViewById(R.id.btn_telf);
        telf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciem una nova layout
                Intent intent = new Intent(MainActivity.this, TelfActivity.class);
                startActivity(intent);
            }
        });

        Button msg = (Button) findViewById(R.id.btn_msg);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciem una nova layout
                Intent intent = new Intent(MainActivity.this, MsgActivity.class);
                startActivity(intent);
            }
        });

    }


}
