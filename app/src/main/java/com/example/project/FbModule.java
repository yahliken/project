package com.example.project;

import android.content.Context;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FbModule {
    private Context context;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mainDeck;

    public FbModule (Context context){

        this.context = context;
        firebaseDatabase = FirebaseDatabase.getInstance("https://project-2d5d1-default-rtdb.firebaseio.com/");
        mainDeck = firebaseDatabase.getReference("mainDeck");
    }

}
