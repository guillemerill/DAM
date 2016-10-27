package com.guillem.provaactivitats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegonaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segona);
        Intent intent = this.getIntent();
        int id = intent.getIntExtra("id", 0);
        String text = intent.getStringExtra("title");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("ID=" + id);
    }
}
