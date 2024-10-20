package com.example.supermarket;

import android.graphics.Bitmap;

public class Product {
    private Bitmap image;
    private int quantity;
    private double price;

    public Product(Bitmap image) {  // Constructor solo con imagen
        this.image = image;
        this.quantity = 0;          // Valor predeterminado
        this.price = 0.0;          // Valor predeterminado
    }

    public Bitmap getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
