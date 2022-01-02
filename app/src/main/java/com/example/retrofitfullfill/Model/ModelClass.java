package com.example.retrofitfullfill.Model;

public class ModelClass {

    private String title;
    private String price;
    private String thumbnail;

    private String status;
    private String instructor_name;
    private String full_price;


    public ModelClass(String title, String price, String thumbnail, String status, String instructor_name, String full_price) {
        this.title = title;
        this.price = price;
        this.thumbnail = thumbnail;
        this.status = status;
        this.instructor_name = instructor_name;
        this.full_price = full_price;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public String getFull_price() {
        return full_price;
    }

    public void setFull_price(String full_price) {
        this.full_price = full_price;
    }
}
