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
    public void setType(String type) {
        this.type = type;
    }
    public Bitmap getbFront() {
        return bFront;
    }

    public void setbFront(Bitmap bFront) {
        this.bFront = bFront;
    }
    public Bitmap getbBack() {
        return bBack;
    }

    public void setbBack(Bitmap bBack) {
        this.bBack = bBack;
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

    public void drawBack(Canvas canvas){
        canvas.drawBitmap(bBack,x,y,null);
    }

    public void drawFront(Canvas canvas){
        canvas.drawBitmap(bFront,x,y,null);
    }
}
