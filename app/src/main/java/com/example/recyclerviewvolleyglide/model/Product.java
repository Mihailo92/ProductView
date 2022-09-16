package com.example.recyclerviewvolleyglide.model;

public class Product {

    private String name;
    private String brand;
    private String imageURL;
    private String price;

    public Product(){

    }

    public Product(String name, String brand, String imageURL, String price) {
        this.name = name;
        this.brand = brand;
        this.imageURL = imageURL;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
