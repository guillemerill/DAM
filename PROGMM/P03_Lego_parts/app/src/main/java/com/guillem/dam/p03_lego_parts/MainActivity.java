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
        if (!loaded) downloadCurrencies();
        else {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Calendar c = Calendar.getInstance();
            String now = sdf.format(c.getTime());
            c.add(Calendar.DATE, -1);
            String yesterday = sdf.format(c.getTime());
            boolean valid = now.equals(sets.getTime()) || yesterday.set.getTime()) || yesterday.equs(currencies.getTime());
            if (!valid) askForDownload();
            else updateSpinners();
        }
    }

    public void downloadCurrencies() {
        CurrenciesDownloader dd = new CurrenciesDownloader(this);
        dd.setOnCurrenciesLoadedListener(new OnCurrenciesLoadedListener() {
            @Override
            public void onCurrenciesLoaded(boolean ok) {
                Log.d("flx", "Download result: " + ok);
                if (ok) init();
                else askForDownload();
            }
        });
        dd.execute();
    }

    public void askForDownload() {

        if (currencies != null) {
            if (currencies.getTime() != null) {
                String title = getResources().getString(R.string.update_currencies_title);
                String msg = getResources().getString(R.string.last_update_message);
                String btnOk = getResources().getString(R.string.button_download);
                String btnNo = getResources().getString(R.string.button_not_now);
                msg = msg.replaceAll("@", currencies.getTime());
                new AlertDialog.Builder(this).setTitle(title).setMessage(msg)
                        .setPositiveButton(btnOk, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.downloadCurrencies();
                            }
                        })
                        .setNegativeButton(btnNo, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.init();
                            }
                        })
                        .show();
                return;
            }
        }
        String title = getResources().getString(R.string.notify_empty_file_title);
        String msg = getResources().getString(R.string.notify_empty_file_message);
        new AlertDialog.Builder(this).setTitle(title).setMessage(msg).show();
    }
}
