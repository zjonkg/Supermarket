package com.example.supermarket;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.widget.TextView;


public class Buy extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
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
        double result = 0;
        ArrayList<Product> productList = getIntent().getParcelableArrayListExtra("Product");

        TextView total = findViewById(R.id.total);
        RecyclerView recyclerView = findViewById(R.id.recyclerView_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (productList != null) {
            ProductSelectedAdapter productAdapter = new ProductSelectedAdapter(this, productList);
            recyclerView.setAdapter(productAdapter);
        }


        for(Product product: productList) {
           result +=  product.getQuantity() * product.getPrice();
        }

        total.setText(String.format("%.2f", result) + "€");


    }
}