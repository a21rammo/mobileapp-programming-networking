package com.example.networking;

import androidx.recyclerview.widget.RecyclerView;

public class Mountain{
    private String name;
    private String location;
    private int height;

    public Mountain(String mName, String mLocation, int mHeight) {
        this.name= mName;
        this.location= mLocation;
        this.height = mHeight;
    }

    public void setName(String mName) {
        name=mName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
