package com.codegym.thai_foody_casestudy_module03.Model.Entity;

public class Product {
    private long id;
    private long storeId;
    private String name;
    private int price;
    private String imageURL;

    public Product(){
    }

    public Product(long id, long storeId, String name, int price, String imageURL) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }

    public Product(long id, String name, int price, String imageURL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }
    public Product(String name, int price, String imageURL, long storeId) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
        this.storeId = storeId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
