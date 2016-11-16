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

        Button nav = (Button) findViewById(R.id.b1);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.stucom.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button img = (Button) findViewById(R.id.b2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImgActivity.class);
                startActivity(intent);
            }
        });

        Button telf = (Button) findViewById(R.id.b3);
        telf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelfActivity.class);
                startActivity(intent);
            }
        });

        Button msg = (Button) findViewById(R.id.b4);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelfActivity.class);
                startActivity(intent);
            }
        });

/*
// Opció 2
Intent intent = new Intent(Intent.ACTION_SEND);
intent.putExtra(Intent.EXTRA_EMAIL , "felix.galindo@stucom.com");
intent.putExtra(Intent.EXTRA_TEXT, "Cos del correu");
intent.setType("text/plain");
startActivity(Intent.createChooser(intent, "Tria el client de correu"));


        */
    }


}
