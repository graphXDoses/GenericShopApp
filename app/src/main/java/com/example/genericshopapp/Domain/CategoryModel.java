package com.example.genericshopapp.Domain;

public class CategoryModel {
    private String title;
    private int id;
    private String pickUrl;

    public CategoryModel(){

    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getPickUrl() {
        return pickUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPickUrl(String pickUrl) {
        this.pickUrl = pickUrl;
    }
}
