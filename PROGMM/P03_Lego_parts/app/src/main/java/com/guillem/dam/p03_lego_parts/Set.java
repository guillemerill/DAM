package com.guillem.dam.p03_lego_parts;

/*
Output data with fields:
set_id - Set ID
descr - Set description.
set_img_url - Set image URL.
parts - Array of parts in the set.
 */

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Set {
    public class Part {
        String name;
        String part_img_url;
        int quant;
    }

    private String set_id;
    private String descr;
    private String img_url;
    private List<Part> parts;

    public Set() {
        descr = "";
        img_url = "";
        parts = new ArrayList<>();
    }

    public boolean loadFromFile(Context context) {
        BufferedReader reader = null;
        try {
            File dir = context.getExternalFilesDir(null);
            if (dir == null) return false;
            File f = new File(dir, "sets.csv");
            if (!f.exists()) return false;
            reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length != 2) continue;
                Part c =
                        new Part(parts[0], parts[1], Integer.parseInt(parts[2]));
                parts.add(c);
            }
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
