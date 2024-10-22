package com.example.supermarket;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.ByteArrayOutputStream;

public class Product implements Parcelable {
    private byte[] imageBytes; // Cambiamos Bitmap por byte[]
    private String name;
    private int quantity;
    private double price;

    public Product(Bitmap image) {
        this.imageBytes = bitmapToByteArray(image);
    }


    protected Product(Parcel in) {
        imageBytes = in.createByteArray();
        name = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(imageBytes); // Guardar la imagen como byte[]
        dest.writeString(name);
        dest.writeInt(quantity);
        dest.writeDouble(price);
    }

    // Métodos getter y setter
    public Bitmap getImage() {
        return byteArrayToBitmap(imageBytes);
    }

    public void setImage(Bitmap image) {
        this.imageBytes = bitmapToByteArray(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    private byte[] bitmapToByteArray(Bitmap bitmap) {
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        scaledBitmap.compress(Bitmap.CompressFormat.PNG, 80, stream);
        return stream.toByteArray();
    }

    private Bitmap byteArrayToBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }
}
