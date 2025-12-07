package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Card {

    private String type;
    private Bitmap bFront;
    private Bitmap bBack;
    private float x, y;

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

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bBack,x,y,null);
    }
}
