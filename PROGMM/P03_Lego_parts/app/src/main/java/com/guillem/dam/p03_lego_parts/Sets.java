package com.guillem.dam.p03_lego_parts;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sets {
    // apli tsp
    // string.split(\n) --> files
    // files.split(\t) --> columnes
    public class Set {
        String code;
        String name;
        String desc;
        int parts;
        ImageView image;
    }

    private String time;
    private ArrayList<Set> sets;

    public Sets() {
        time = null;
        sets = new ArrayList<Set>();
    }

    public String getTime() { return time; }
    public ArrayList<Set> getSets() { return this.sets; }

    public Set getSet(String code) {
        for (Set s : sets) {
            if (s.code.equals(code)) return s;
        }
        return null;
    }

    public  int getPosition(String code) { return sets.indexOf(getSet(code)); }

    public boolean loadFromFile(Context context) {
        BufferedReader reader = null;
        try {
            File dir = context.getExternalFilesDir(null);
            if (dir == null) return false;
            File f = new File(dir, "sets.tsp");
            if (!f.exists()) return false;
            reader = new BufferedReader(new FileReader(f));
            time = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rows = line.split("\n");
                for (String col : rows) {
                    Set s = new Set();
                    // TODO
                }

            }
            return true;

        } catch (Exception e) {
            Log.e("guillem", "ERROR: " + e);
            return false;
        } finally {
            if (reader != null) {
                try { reader.close(); }
                catch ( IOException e) {}
            }
        }
    }
}
