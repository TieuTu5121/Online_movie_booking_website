package com.example.nedcinema.models;

public class Food {
    private int id;
    private String name;
    private String  description;
    private int price;
    private String photo;

    public Food(String name, String description, int price, String photo) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "food{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                '}';
    }
}
