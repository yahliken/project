package com.example.project;

import android.graphics.Bitmap;

public class NumCard extends Card{

    private int value;
    public NumCard(String type, Bitmap bFront, Bitmap bBack, int value) {
        super(type, bFront, bBack);
        this.value = value;
    }
}
