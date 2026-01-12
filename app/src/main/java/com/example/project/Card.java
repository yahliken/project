package com.example.project;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Card {

    private String type;
    private int idFront;
    private int idBack;
    private float x, y;
    private int idCard;

    public Card(String type, int idFront, int idBack) {
        this.type = type;
        this.idFront = idFront;
        this.idBack = idBack;
        this.idCard = idBack;
    }

    public Card() {
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

    public void flipCard(Card card){
        if(card.idCard == card.idBack){
            card.idCard = card.idFront;
        }
        else{
            card.idCard = card.idBack;
        }
    }

    public boolean isFlipped(Card card){
        if(card.idCard == card.idFront){
            return true;
        }
        return false;
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
    public void Draw(Canvas canvas , Bitmap bitmap){
        canvas.drawBitmap(bitmap, x, y, null);
    }
}
