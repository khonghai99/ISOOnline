package com.bkav.isoonline.models;

public class User {
    private String Name;
    private int ID;

    public User(String name, int ID) {
        Name = name;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}