package com.guillem.dam.llancador;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class ImgActivity extends AppCompatActivity implements View.OnClickListener {

    // Creem els elements necessaris
    private ImageView imgView;
    private Button btn_galeria, btn_camara;
    private boolean isResource = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        // Li donem valor als elements
        imgView = (ImageView) findViewById(R.id.imageView1);
        btn_galeria = (Button) findViewById(R.id.btn_galeria);
        btn_camara = (Button) findViewById(R.id.btn_camara);
        btn_galeria.setOnClickListener(this);
        btn_camara.setOnClickListener(this);
    }

    @Override
    public void onPause() {
        emptyImageViewer();
        super.onPause();
    }

    // Si no hi ha imatge escollida per l'usuari li posem una per defecte
    public void emptyImageViewer() {
        if (this.isResource) return;
        Drawable drawable = imgView.getDrawable();
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            if (!bitmap.isRecycled()) bitmap.recycle();
        }
        imgView.setImageResource(android.R.drawable.ic_menu_camera);
        this.isResource = true;
    }

    // Li assignem una funció al onClick de cada Button
    @Override
    public void onClick(View v) {
        if (v.equals(btn_galeria)) selectPhoto();
        else if (v.equals(btn_camara)) takePhoto();
    }

    private final static int SELECT_PHOTO = 1;
    private final static int CAPTURE_PHOTO = 2;

    // Si triem selectPhoto creem l'Intent d'obrir la galeria
    public void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(
                Intent.createChooser(intent, "Select Source"), SELECT_PHOTO);
    }

    private Uri photoUri;

    // Si triem takePhoto obrim la carpeta on s'han de guardar les imatges, fem l'Intent de fer la foto, li enviem l'uri d'on ha de guardar i s'inicia l'activitat
    public void takePhoto() {
        File dir = getExternalFilesDir(null);
        if (dir == null) {
            Toast.makeText(this, "Unable to mount the filesystem",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        File file = new File(dir, "photo.jpg");
        photoUri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", file);
        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(i, CAPTURE_PHOTO);
    }

    // Ens indica si s'ha recollit la imatge correctment o no, i la fica al imageView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        emptyImageViewer();
        if (requestCode == CAPTURE_PHOTO) {
            imgView.setImageURI(photoUri);
            this.isResource = false;
        }
        else {
            Uri img = data.getData();
            if (img != null) {
                imgView.setImageURI(img);
                this.isResource = false;
            }
        }
        imgView.invalidate();
    }
}
