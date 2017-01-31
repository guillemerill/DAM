package com.guillem.dam.p03_lego_parts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Sets sets;
    EditText set_code;
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_code = (EditText) findViewById(R.id.set_code);
        btn_search = (Button) findViewById(R.id.btn_search);

        init();
    }

    public void init() {
        sets = new Sets();
        boolean loaded = sets.loadFromFile(this);
        Log.d("Guillem", "Loaded: " + loaded);
        if (!loaded) downloadSets();
        else {
        }
    }

    public void downloadSets() {
        SetsDownloader dd = new SetsDownloader(this);
        dd.setOnSetsLoadedListener(new SetsDownloader.OnSetsLoadedListener() {
            @Override
            public void onSetsLoaded(boolean ok) {
                Log.d("flx", "Download result: " + ok);
                if (ok) init();
                // else askForDownload();
            }
        });
        dd.execute();
    }
}
