package com.guillem.dam.p03_lego_parts;

/*
Output data with fields:
set_id - Set ID
descr - Set description.
set_img_url - Set image URL.
parts - Array of parts in the set.
 */

import android.media.Image;

import java.lang.reflect.Array;

public class Set {
    String set_id;
    String descr;
    Image image;
    Array parts;
}
