package com.example.project;

import android.graphics.Bitmap;

public class NumCard extends Card{

    private int value;
    public NumCard(String type, int idFront, int idBack, int value) {
        super(type, idFront, idBack);
        this.value = value;
    }
}
