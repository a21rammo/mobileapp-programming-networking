package com.example.networking;

public class Mountain{

    private String name;
    private String location;
    private String type;
    private int size;
    private int cost;


    public Mountain(String mName, String mLocation, String mType) {
        this.name= mName;
        this.location= mLocation;
        this.type = mType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
