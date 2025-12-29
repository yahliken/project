package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Card {

    private String type;
    private int idFront;
    private int idBack;
    private Bitmap bFront;
    private Bitmap bBack;
    private float x, y;

    public Card(String type, int idFront, int idBack) {
        this.type = type;
        this.idFront = idFront;
        this.idBack = idBack;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getidFront() {
        return idFront;
    }

    public void setidFront(int idFront) {
        this.idFront = idFront;
    }
    public int getidBack() {
        return idBack;
    }

    public void setidBack(int idBack) {
        this.idBack = idBack;
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
