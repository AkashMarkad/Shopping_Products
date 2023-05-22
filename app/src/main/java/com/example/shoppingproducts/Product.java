package com.example.shoppingproducts;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int imageRes;
    private int quantityLeft;
    private boolean isSelected;

    public Product(int imageRes, int quantityLeft) {
        this.imageRes = imageRes;
        this.quantityLeft = quantityLeft;
        this.isSelected = false;
    }

    public int getImageRes() {
        return imageRes;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    // Parcelable implementation
    protected Product(Parcel in) {
        imageRes = in.readInt();
        quantityLeft = in.readInt();
        isSelected = in.readByte() != 0;
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
        dest.writeInt(imageRes);
        dest.writeInt(quantityLeft);
        dest.writeByte((byte) (isSelected ? 1 : 0));
    }
}
