package com.example.project;

import android.graphics.Bitmap;

public class NumCard extends Card{

    private int number;
    public NumCard(String type, int idFront, int idBack, int number) {
        super(type, idFront, idBack);
        this.number = number;
    }
}
