package com.tatweer.moh.takamulpoc.Models;

/**
 * Created by moh on 11/17/2016.
 */

public class Category {
    String name;
    int image;
    int productsCount;

    public Category(String name, int image, int productsCount)
    {
        this.name = name;
        this.image = image;
        this.productsCount = productsCount;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
