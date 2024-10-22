package com.example.supermarket;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_product, parent, false);
        }

        ImageView productImage = view.findViewById(R.id.productImage);
        TextView productQuantity = view.findViewById(R.id.productQuantity);
        TextView productPrice = view.findViewById(R.id.productPrice);
        TextView productName = view.findViewById(R.id.productName);

        Button buttonAdd = view.findViewById(R.id.buttonAdd);
        Button buttonRemove = view.findViewById(R.id.buttonRemove);


        Product product = products.get(position);


        productImage.setImageBitmap(product.getImage()); //
        productQuantity.setText("Cantidad: " + product.getQuantity());
        productPrice.setText("Precio: $" + String.format("%.2f", product.getPrice()));
        productName.setText(product.getName());


        buttonAdd.setOnClickListener(v -> {
            product.setQuantity(product.getQuantity() + 1);
            productQuantity.setText("Cantidad: " + product.getQuantity());
        });

        buttonRemove.setOnClickListener(v -> {
            if (product.getQuantity() > 0) {
                product.setQuantity(product.getQuantity() - 1);
                productQuantity.setText("Cantidad: " + product.getQuantity());
            }
        });

        return view;
    }
}
