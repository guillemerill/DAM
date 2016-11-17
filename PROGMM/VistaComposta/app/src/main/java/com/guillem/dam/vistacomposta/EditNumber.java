package com.guillem.dam.vistacomposta;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditNumber extends LinearLayout {
    private int value, min, max;
    private TextView textView;
    private SeekBar seekBar;

    public EditNumber(Context context) {
        this(context, null, 0);
    }
    public EditNumber(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public EditNumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.edit_number_layout, this);
    }

}
