package com.example.project;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Random;

public class GameModule {

    private ArrayList<Card> deck;
    private ArrayList<Card> player1 , player2;
    public void newDeck(){

        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.back);
        bitmap = Bitmap.createScaledBitmap(bitmap, 180, 250, true);

        int [] cardsImg = {R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.draw2, R.drawable.peek, R.drawable.swap};
        for (int i = 0; i < 10; i++) {

            if(i<9){
                for(int k=0; k<4; k++){
                    Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                    NumCard c = new NumCard("num", bitmap1, bitmap, i);
                    deck.add(c);
                }
            }
            else {
                for(int k=0; k<9; k++){
                    Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                    NumCard c = new NumCard("num", bitmap1, bitmap, i);
                    deck.add(c);
                }
            }

        }
        for (int i = 10; i < 13; i++) {

            if(i == 10){
                for(int k=0; k<3; k++){
                    Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                    Card c = new Card("draw2", bitmap1, bitmap);
                    deck.add(c);
                }
            }
            if(i == 11){
                for(int k=0; k<3; k++){
                    Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                    Card c = new Card("peek", bitmap1, bitmap);
                    deck.add(c);
                }
            }
            if(i == 12){
                for(int k=0; k<3; k++){
                    Bitmap bitmap1 = BitmapFactory.decodeResource(Resources.getSystem(), cardsImg[i]);
                    bitmap1 = Bitmap.createScaledBitmap(bitmap1, 180, 250, true);
                    Card c = new Card("swap", bitmap1, bitmap);
                    deck.add(c);
                }
            }

        }
    }

    public void Shuffle(){
        ArrayList<Card> temp = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int x = rnd.nextInt(deck.size());
            temp.add(deck.get(x));
            deck.remove(x);
        }
        for (int i = 0; i < temp.size(); i++) {
            deck.add(temp.remove(i));
        }
    }

    public void startGame(){
        int count = 1;
        int i = 0;
        while (count != 8){
            Card c = deck.get(i);
            if(c.getType().equals("num")){
                if(player1.size() < 4){
                    player1.add(deck.remove(i));
                    count++;
                }
                else {
                    player2.add(deck.remove(i));
                    count++;
                }

            }
            i++;
        }

    }

}
