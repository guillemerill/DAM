package com.guillem.dam.provallista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prova3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova3);

        ListView llista3 = (ListView) findViewById(R.id.llista3);

        List<Map<String, String>> dades = new ArrayList<>();
        Map<String, String> producte1 = new HashMap<String, String>();
        producte1.put("Producte", "Disc dur 1TByte");
        producte1.put("Preu", "70€");
        producte1.put("Stock", "Disponible en Stock");
        dades.add(producte1);
        Map<String, String> producte2 = new HashMap<String, String>();
        producte2.put("Producte", "Monitor 25'");
        producte2.put("Preu", "180€");
        producte2.put("Stock", "No disponible fins el 04/07/2017");
        dades.add(producte2);

        SimpleAdapter adapter = new SimpleAdapter(
                Prova3Activity.this,
                dades,
                R.layout.llista3_item,
                new String[] { "Producte", "Preu", "Stock" },
                new int[] { R.id.nom, R.id.preu, R.id.stock });
        llista3.setAdapter(adapter);
    }
}
