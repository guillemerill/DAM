package com.guillem.dam.llancador;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MsgActivity extends AppCompatActivity{

    private Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String asunto = ((EditText)findViewById(R.id.et_asunto)).getText().toString();
                String msg = ((EditText)findViewById(R.id.et_text)).getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_SUBJECT , asunto);
                intent.putExtra(Intent.EXTRA_TEXT, msg);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Tria el client de correu"));

            }
        });
    }
}
