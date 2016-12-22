package com.guillem.dam.provallista;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prova5Activity extends AppCompatActivity {

    // POJO del producte (Plain Old Java Object)
    public class Product {
        private long id;
        private String name;
        private float price;
        private boolean inStock;
        private int image;

        public Product(int id, String name, float price, boolean inStock, int image) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.inStock = inStock;
            this.image = image;
        }

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public float getPrice() {
            return price;
        }
        public void setPrice(float price) {
            this.price = price;
        }
        public boolean isInStock() {
            return inStock;
        }
        public void setInStock(boolean inStock) {
            this.inStock = inStock;
        }
        public int getImage() {
            return image;
        }
        public void setImage(int image) {
            this.image = image;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova5);

        ListView llista5 = (ListView) findViewById(R.id.llista5);

        List<Product> dades =   new ArrayList<>();
        dades.add(new Product(1, "Arbre de Nadal", 17.0f, true, R.drawable.arbre));
        dades.add(new Product(2,"Campanetes", 1.7f, false, R.drawable.campanetes));
        dades.add(new Product(3,"Barret de Pare Noel", 3.7f, true, R.drawable.barret));
        dades.add(new Product(4,"Regal sorpresa'", 25.0f, true, R.drawable.sorpresa));
        dades.add(new Product(5,"Figura Pare Noel", 13.99f, false, R.drawable.klaus));
        dades.add(new Product(6,"Bola de vidre", 5.99f, true, R.drawable.vidre));
        dades.add(new Product(7,"Corona de flors", 2.75f, false, R.drawable.corona));
        dades.add(new Product(8,"Bola de decoració d'arbre", 1.99f, true, R.drawable.bola));
        dades.add(new Product(9, "Arbre de Nadal", 17.0f, true, R.drawable.arbre));
        dades.add(new Product(10,"Campanetes", 1.7f, false, R.drawable.campanetes));
        dades.add(new Product(11,"Barret de Pare Noel", 3.7f, true, R.drawable.barret));
        dades.add(new Product(12,"Regal sorpresa'", 25.0f, true, R.drawable.sorpresa));
        dades.add(new Product(13,"Figura Pare Noel", 13.99f, false, R.drawable.klaus));
        dades.add(new Product(14,"Bola de vidre", 5.99f, true, R.drawable.vidre));
        dades.add(new Product(15,"Corona de flors", 2.75f, false, R.drawable.corona));
        dades.add(new Product(16,"Bola de decoració d'arbre", 1.99f, true, R.drawable.bola));

        CatalogAdapter adapter = new CatalogAdapter(this, dades);
        llista5.setAdapter(adapter);
    }

    public class CatalogAdapter extends BaseAdapter {

        private Context context;
        private List<Product> catalog;

        public CatalogAdapter(Context context, List<Product> catalog) {
            this.context = context;
            this.catalog = catalog;
        }
        @Override public int getCount() {
            return catalog.size();
        }
        @Override public Object getItem(int position) {
            return catalog.get(position);
        }
        @Override public long getItemId(int position) {
            return (int) (catalog.get(position).getId());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.llista5_item, parent, false);
            TextView tvNom = (TextView) myView.findViewById(R.id.nom);
            Product product = catalog.get(position);
            String nom = (String) product.getName();
            tvNom.setText(nom);

            TextView tvPreu = (TextView) myView.findViewById(R.id.preu);
            tvPreu.setText(String.valueOf(catalog.get(position).getPrice()) + " €");

            ImageView tvImatge = (ImageView) myView.findViewById(R.id.imatge);
            tvImatge.setImageResource(catalog.get(position).getImage());

            TextView tvStock = (TextView) myView.findViewById(R.id.stock);
            if (product.isInStock()) {
                tvStock.setText("EN STOCK");
                tvStock.setTextColor(Color.GREEN);
            }
            else {
                tvStock.setText("NO DISPONIBLE");
                tvStock.setTextColor(Color.RED);
            }

            return myView;
        }
    }
}
