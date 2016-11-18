package com.guillem.dam.llancador;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
public class TelfActivity  extends AppCompatActivity {

    private EditText num;
    private Button btn_trucar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telf);

        // Li donem valor als elements
        num = (EditText) findViewById(R.id.num);
        btn_trucar = (Button) findViewById(R.id.btn_trucar);

        // Li definim el onClick, li passem el telèfon introduït i fem l'Intent del Telèfon
        btn_trucar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = ((EditText)findViewById(R.id.num)).getText().toString();
                Uri uri = Uri.parse("tel:"+numero);
                Intent intent = new Intent(Intent.ACTION_DIAL , uri);
                startActivity(intent);
            }
        });
    }
}
