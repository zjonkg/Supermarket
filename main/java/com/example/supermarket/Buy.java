package com.example.supermarket;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.widget.ListView;



public class Buy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Product> productList = getIntent().getParcelableArrayListExtra("Product");


        RecyclerView recyclerView = findViewById(R.id.recyclerView_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (productList != null) {
            ProductSelectedAdapter productAdapter = new ProductSelectedAdapter(this, productList);
            recyclerView.setAdapter(productAdapter);
        }
    }
}