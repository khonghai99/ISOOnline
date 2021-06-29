package com.bkav.isoonline.models;

import java.util.Date;

public class Trouble {
    private String mNameTrouble;
    private String mLevel;
    private String mDate;

    public Trouble(String mNameTrouble, String mLevel, String mDate) {
        this.mNameTrouble = mNameTrouble;
        this.mLevel = mLevel;
        this.mDate = mDate;
    }

    public String getNameTrouble() {
        return mNameTrouble;
    }

    public void setNameTrouble(String mNameTrouble) {
        this.mNameTrouble = mNameTrouble;
    }

    public String getLevel() {
        return mLevel;
    }

    public void setLevel(String mLevel) {
        this.mLevel = mLevel;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }
}
