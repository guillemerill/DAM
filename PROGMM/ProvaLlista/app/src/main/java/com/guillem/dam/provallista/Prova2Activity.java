package com.guillem.dam.provallista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prova2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova2);

        ListView llista2 = (ListView) findViewById(R.id.llista2);

        List<Map<String, String>> dades = new ArrayList<>();
        Map<String, String> producte1 = new HashMap<String, String>();
        producte1.put("Producte", "Disc dur 1TByte");
        producte1.put("Preu", "70€");
        dades.add(producte1);
        Map<String, String> producte2 = new HashMap<String, String>();
        producte2.put("Producte", "Monitor 25'");
        producte2.put("Preu", "180€");
        dades.add(producte2);

        SimpleAdapter adapter = new SimpleAdapter(
                Prova2Activity.this,
                dades,
                android.R.layout.simple_list_item_2,
                new String[] { "Producte", "Preu" },
                new int[] { android.R.id.text1, android.R.id.text2 });
        llista2.setAdapter(adapter);
    }
}
