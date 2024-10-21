package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Bitmap> bitmapList;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bitmapList = new ArrayList<>();
        productList = new ArrayList<>();

        loadImages();


        if (!bitmapList.isEmpty()) {
            addProduct(0, 2.29, "Naranja");
            addProduct(1, 1.45, "Banana");
            addProduct(2, 4.69, "Kiwi");
            addProduct(3, 1.95, "Higo");
            addProduct(4, 2.15, "Toronja");
            addProduct(5, 1.89, "Pera");
            addProduct(6, 3.78, "Granada");
            addProduct(7, 1.49, "Papaya");
            addProduct(8, 9.96, "Cereza");
            addProduct(9, 1.49, "Guayaba");
            addProduct(10, 1.49, "Manzana verde");
            addProduct(11, 2.75, "Durazno");
            addProduct(12, 1.49, "Maracuyá");
            addProduct(13, 3.97, "Lima");
            addProduct(14, 5.30, "Coco");
        }

        LlamadaAdaptadorPropioListView();
    }

    private void loadImages() {
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fruits);
        int originalWidth = originalBitmap.getWidth();
        int originalHeight = originalBitmap.getHeight();
        int numRows = 3;
        int numCols = 5;
        int cellWidth = originalWidth / numCols;
        int cellHeight = originalHeight / numRows;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {

                int x = col * cellWidth;
                int y = row * cellHeight;

                Bitmap cellBitmap = Bitmap.createBitmap(originalBitmap, x, y, cellWidth, cellHeight);
                bitmapList.add(cellBitmap);
            }
        }
    }

    private void addProduct(int imageIndex, double price, String name) {
        if (imageIndex >= 0 && imageIndex < bitmapList.size()) {
            Product product = new Product(bitmapList.get(imageIndex));
            product.setName(name);
            product.setQuantity(0);
            product.setPrice(price);
            productList.add(product);
        }
    }

    private void LlamadaAdaptadorPropioListView() {
        ProductAdapter adapter_jmh = new ProductAdapter(this, productList);
        ListView listView_jmh = findViewById(R.id.listviewjmh);
        listView_jmh.setAdapter(adapter_jmh);
    }
}
