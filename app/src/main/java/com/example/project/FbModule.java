package com.example.project;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FbModule {
    private static FbModule instance;
    private Context context;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference Decks;

    private FbModule (Context context){

        this.context = context;
        firebaseDatabase = FirebaseDatabase.getInstance("https://project-2d5d1-default-rtdb.firebaseio.com/");
        Decks = firebaseDatabase.getReference("Decks");


        if(GameActivity.player==1)
        {
            ClearDecksFromFb();
        }
        //רק עבור מכשיר אחד ננקה את הפיירבייס לפני משחק חדש כי השני רק מאזין
        Decks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // ניקינו את הרשימות ונעדכן אותן מחדש עם השינוי העדכני שנעשה בהן ועודכן בפיירבייס - לוקחים בלולאת פור את כל העצמים שמתחת לצומת של חפיסה מסויימת ומוסיפים אותם מחדש לרשימות שקיימות בגיימודול כך שמה שהרשימות מכילות זה את המצב הנוכחי שהן
                if(snapshot.getValue() != null)
                {
                    GameModule.deck.clear();
                    DataSnapshot deckSnapshot = snapshot.child("deck");
                    for(DataSnapshot userSnapshot : deckSnapshot.getChildren()){
                        Card currentCard = userSnapshot.getValue(Card.class);
                        GameModule.deck.add(currentCard);
                    }
                    //הuserSnapshot מייצג הפנייה לכל איברי הקלפים שמתחת לצומת
                    GameModule.player1.clear();
                    DataSnapshot player1Snapshot = snapshot.child("player1");
                    for(DataSnapshot userSnapshot : player1Snapshot.getChildren()){
                        NumCard currentCard =  userSnapshot.getValue(NumCard.class);
                        GameModule.player1.add(currentCard);
                    }
                    GameModule.player2.clear();
                    DataSnapshot player2Snapshot = snapshot.child("player2");
                    for(DataSnapshot userSnapshot : player2Snapshot.getChildren()){
                        NumCard currentCard =  userSnapshot.getValue(NumCard.class);
                        GameModule.player2.add(currentCard);
                    }
                    GameModule.trash.clear();
                    DataSnapshot trashSnapshot = snapshot.child("trash");
                    for(DataSnapshot userSnapshot : trashSnapshot.getChildren()){
                        Card currentCard = userSnapshot.getValue(Card.class);
                        GameModule.trash.add(currentCard);
                    }
                }
                //רק אם הצומת בפיירבייס לא ריקה כלומר החפיסות כתובות שם - רק אז נוכל למחוק את הרשימות בגיימודול ולעדכן אותן בהתאם לשינוי בפיירבייס
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
    public static FbModule setInstance(Context context){
        if(instance==null){
            instance= new FbModule(context);
        }
        return instance;
    }
    public void setDeck(ArrayList<Card> arrayList, String deckName){
        //יוצר את החפיסה בדטהבייס בפעם הראשונה עבור כל חפיסה בנפרד
        DatabaseReference myRef = firebaseDatabase.getReference("Decks/" + deckName +"/");
        myRef.setValue(arrayList);
    }
    public void setPlayersDeck(ArrayList<NumCard> arrayList, String deckName){
        //יוצר את החפיסה בדטהבייס בפעם הראשונה עבור כל חפיסה בנפרד
        DatabaseReference myRef = firebaseDatabase.getReference("Decks/" + deckName +"/");
        myRef.setValue(arrayList);
    }

    public void ClearDecksFromFb(){
        //יוצר את החפיסה בדטהבייס בפעם הראשונה עבור כל חפיסה בנפרד
        DatabaseReference myRef = firebaseDatabase.getReference("Decks");
        myRef.removeValue();
    }

}


