package com.example.project;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class GameModule {

    private ArrayList<Card> deck;

    public void newDeck(){

        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.back);
        bitmap = Bitmap.createScaledBitmap(bitmap, 180, 250, true);

        int [] cardsImg = {R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.draw2, R.drawable.peek, R.drawable.swap};
        for (int i = 0; i < 10; i++) {

            if(i<9){
                for(int k=0; k<4; k++){
                    Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                    Card c = new Card("num", bitmap1, bitmap);
                    deck.add(c);
                }
            }
            else {
                for(int k=0; k<9; k++){
                    Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                    Card c = new Card("num", bitmap1, bitmap);
                    deck.add(c);
                }
            }

        }
        for (int i = 10; i < 13; i++) {

            for(int k=0; k<3; k++){
                Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                Card c = new Card("num", bitmap1, bitmap);
                deck.add(c);
            }
        }
    }
}
