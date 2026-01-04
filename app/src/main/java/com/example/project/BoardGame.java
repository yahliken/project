package com.example.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;

public class BoardGame extends View {
    private Context context;
    private GameModule gameModule;
    private int canvasWidth, canvasHeight;
    private boolean isFirstTime = true;
    private int player;

    public BoardGame(Context context, int player) {
        super(context);
        this.context = context;
        gameModule= new GameModule(context);
        this.player = player;
        if(player == 1){
            gameModule.startGame();
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        if(isFirstTime){
            canvasWidth = canvas.getWidth();
            canvasHeight = canvas.getHeight();
        }

        for (int i =0; i<4;i++){
            gameModule.player1.get(i).setX((canvasWidth/4)*i +50);
            gameModule.player1.get(i).setY(canvasHeight-350);
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources() , gameModule.player1.get(i).getidBack());
            bitmap1 = Bitmap.createScaledBitmap(bitmap1, canvasWidth/4 -10, 300, false);
            gameModule.player1.get(i).Draw(canvas, bitmap1);

            gameModule.player2.get(i).setX((canvasWidth/4)*i +50);
            gameModule.player2.get(i).setY(canvasHeight+50);
            Bitmap bitmap2 = BitmapFactory.decodeResource(getResources() , gameModule.player2.get(i).getidBack());
            bitmap2 = Bitmap.createScaledBitmap(bitmap2, canvasWidth/4 -10, 300, false);
            gameModule.player2.get(i).Draw(canvas, bitmap2);

        }

    }
}
