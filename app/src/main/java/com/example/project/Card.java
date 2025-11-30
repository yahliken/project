package com.example.project;

import android.graphics.Bitmap;

public class Card {

    private String type;
    private Bitmap bFront;
    private Bitmap bBack;

    public Card(String type, Bitmap bFront, Bitmap bBack) {
        this.type = type;
        this.bFront = bFront;
        this.bBack = bBack;
    }

    public String getType() {
        return type;
    }

    public Bitmap getbFront() {
        return bFront;
    }

    public Bitmap getbBack() {
        return bBack;
    }
}
