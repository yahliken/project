package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class BoardGame extends View {
    private Context context;
    private GameModule gameModule;
    private int canvasWidth, canvasHeight;

    public BoardGame(Context context) {
        super(context);
        this.context = context;
        gameModule= new GameModule(context);
        gameModule.startGame();
    }






}
