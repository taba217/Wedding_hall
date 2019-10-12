package com.example.wedding_hall.harith;

public class Halls {

    private int ImageResource;
    private String name;
    private String price;
    private String loocation;

    public Halls(int imageResource, String name, String price, String loocation) {
        ImageResource = imageResource;
        this.name = name;
        this.price = price;
        this.loocation = loocation;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getLoocation() {
        return loocation;
    }
}
