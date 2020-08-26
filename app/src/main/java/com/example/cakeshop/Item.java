package com.example.cakeshop;

public class Item {
    private String name;
    private String description;
    private String image;
    private int price;

    public Item(String name, String description, String link, int price) {
        this.name = name;
        this.description = description;
        this.image = link;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.image = link;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

