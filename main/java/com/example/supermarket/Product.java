package com.example.supermarket;

import android.graphics.Bitmap;

public class Product {
    private Bitmap image;
    private int quantity;
    private double price;
    private String name;

    public Product(Bitmap image) {  // Constructor solo con imagen
        this.image = image;
        this.quantity = 0;
        this.price = 0.0;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }
}
