package com.example.project;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Random;

public class GameModule {

    public static ArrayList<Card> deck = new ArrayList<Card>(), trash = new ArrayList<Card>();
    public static ArrayList<NumCard> player1 = new ArrayList<NumCard>(), player2 = new ArrayList<NumCard>();
    private FbModule instance;
    private Context context;

    public GameModule(Context context) {
        this.context = context;
    }
    private void newDeck(){

        deck.clear();
        int back = R.drawable.back;
        int [] cardsImg = {R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.draw2, R.drawable.peek, R.drawable.swap};
        for (int i = 0; i < 10; i++) {

            if(i<9){
                for(int k=0; k<4; k++){
                    NumCard c = new NumCard("num", cardsImg[i], back, i);
                    deck.add(c);
                }
            }
            else {
                for(int k=0; k<9; k++){
                    NumCard c = new NumCard("num", cardsImg[i], back, i);
                    deck.add(c);
                }
            }

        }
        for (int i = 10; i < 13; i++) {

            if(i == 10){
                for(int k=0; k<3; k++){
                    Card c = new Card("draw2", cardsImg[i], back);
                    deck.add(c);
                }
            }
            if(i == 11){
                for(int k=0; k<3; k++){
                    Card c = new Card("peek", cardsImg[i], back);
                    deck.add(c);
                }
            }
            if(i == 12){
                for(int k=0; k<3; k++){
                    Card c = new Card("swap", cardsImg[i], back);
                    deck.add(c);
                }
            }

        }
    }

    public void shuffle(){
        int size = deck.size();
        ArrayList<Card> temp = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            int x = rnd.nextInt(deck.size());
            temp.add(deck.get(x));
            deck.remove(x);
        }
        for (int i = 0; i < size; i++) {
            deck.add(temp.remove(0));
        }
    }

    public void startGame(){
        newDeck();
        shuffle();
        int count = 1;
        int i = 0;
        while (count != 9){
            Card c = deck.get(i);
            if(c.getType().equals("num")){
                if(player1.size() < 4){
                    player1.add((NumCard) deck.remove(i));
                    count++;
                }
                else {
                    player2.add((NumCard) deck.remove(i));
                    count++;
                }

            }
            i++;
        }
        shuffle();
        //בגלל שבדקנו שכולם מספרים נותרנו עם הרבה מיוחדים שדילגנו עליהם לכן נערבב שוב כדי שלא יהיה מצב שכל ההתחלה של הקופה מיוחדים
        instance = FbModule.setInstance(context);
        instance.setDeck(deck, "deck");
        instance.setPlayersDeck(player1, "player1");
        instance.setPlayersDeck(player2, "player2");
        instance.setDeck(trash,"trash");

    }

    public void peekCard(Card card){
        ;
    }



}
