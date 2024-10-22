package com.example.supermarket;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductSelectedAdapter extends RecyclerView.Adapter<ProductSelectedAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products;

    public ProductSelectedAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_product_selected, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    // ViewHolder para manejar cada item
    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productQuantity;
        TextView productPrice;
        TextView productName;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productQuantity = itemView.findViewById(R.id.productQuantity);
            productPrice = itemView.findViewById(R.id.productPrice);
            productName = itemView.findViewById(R.id.productName);
        }

        public void bind(Product product) {
            productImage.setImageBitmap(product.getImage());
            productQuantity.setText("Cantidad: " + product.getQuantity());
            productPrice.setText("Precio: $" + String.format("%.2f", product.getPrice()));
            productName.setText(product.getName());
        }
    }
}
