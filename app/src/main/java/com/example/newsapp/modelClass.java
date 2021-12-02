package com.example.newsapp;

public class modelClass {

    private String name;
    public  boolean isSelected;

    public void setSelected(boolean selection){ this.isSelected = selection; }

    public boolean isSelected(){ return isSelected; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public modelClass(String name) {
        this.name = name;
    }
}