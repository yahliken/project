package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;

public class BoardGame extends View {
    private Context context;
    private GameModule gameModule;
    private int canvasWidth, canvasHeight;
    private boolean isFirstTime = true;

    public BoardGame(Context context) {
        super(context);
        this.context = context;
        gameModule= new GameModule(context);
        gameModule.startGame();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        if(isFirstTime){
            canvasWidth = canvas.getWidth();
            canvasHeight = canvas.getHeight();
        }

    }
}
