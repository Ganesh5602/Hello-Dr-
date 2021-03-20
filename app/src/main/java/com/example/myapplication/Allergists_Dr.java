package com.example.myapplication;

public class Allergists_Dr {
    int Image;
    String Name;
    String Specialist;
    String Location;

    public Allergists_Dr(int image, String name, String specialist, String location) {
        this.Image = image;
        this.Name = name;
        this.Specialist = specialist;
        this.Location = location;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        this.Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String specialist) {
        this.Specialist = specialist;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }
}
