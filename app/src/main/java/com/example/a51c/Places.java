package com.example.a51c;

public class Places {

    private String placeTitle;
    private int placeDescription;
    private int id;
    private int image;

    public Places(int id, String placeTitle, int placeDescription, int image)
    {
        this.placeTitle = placeTitle;
        this.placeDescription = placeDescription;
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return placeTitle;
    }
    public int getDescription(){
        return placeDescription;
    }

    public int getImage() {
        return image;
    }
}
