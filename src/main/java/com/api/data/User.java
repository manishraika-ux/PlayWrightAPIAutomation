package com.api.data;

public class User {

    private String id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String email;

    public User(){ }

    public User(String title, String price, String description, String category, String email) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.email =email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}