package com.example.myapplication;

public class Ambulance_driver {
    int DImage;
    String DName;
    String Company;
    String DLocation;
    public Ambulance_driver(int dimage, String dname, String company, String dlocation) {
        this.DImage = dimage;
        this.DName = dname;
        this.Company = company;
        this.DLocation = dlocation;
    }

    public int getDImage() {
        return DImage;
    }

    public void setDImage(int DImage) {
        this.DImage = DImage;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getDLocation() {
        return DLocation;
    }

    public void setDLocation(String DLocation) {
        this.DLocation = DLocation;
    }
}
