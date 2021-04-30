package com.example.a51c;

public class TopDestinations {
    private String destinationTitle;
    private int id;
    private int image;

    public TopDestinations(int id, String destinationTitle, int image)
    {
        this.destinationTitle = destinationTitle;
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
        return destinationTitle;
    }
    public int getImage() {
        return image;
    }
}
