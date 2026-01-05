package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Card {

    private String type;
    private int idFront;
    private int idBack;
    private float x, y;
    private boolean isExposed;

    public Card(String type, int idFront, int idBack) {
        this.type = type;
        this.idFront = idFront;
        this.idBack = idBack;
        this.isExposed = false;
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
    public boolean getIsExposed(){return isExposed;}

    public void Draw(Canvas canvas , Bitmap bitmap){
        canvas.drawBitmap(bitmap, x, y, null);
    }
}
