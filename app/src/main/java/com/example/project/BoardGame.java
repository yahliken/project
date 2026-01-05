package com.example.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
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

            if(player==1){
                gameModule.player1.get(i).setX((canvasWidth/4)*i +35);
                gameModule.player1.get(i).setY(canvasHeight-450);
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources() , gameModule.player1.get(i).getidBack());
                bitmap1 = Bitmap.createScaledBitmap(bitmap1, canvasWidth/4 -70, 350, false);
                gameModule.player1.get(i).Draw(canvas, bitmap1);

                gameModule.player2.get(i).setX((canvasWidth/4)*i +35);
                gameModule.player2.get(i).setY(200);
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources() , gameModule.player2.get(i).getidBack());
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, canvasWidth/4 -70, 350, false);
                gameModule.player2.get(i).Draw(canvas, bitmap2);
            }
            else{
                gameModule.player2.get(i).setX((canvasWidth/4)*i +35);
                gameModule.player2.get(i).setY(canvasHeight-450);
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources() , gameModule.player2.get(i).getidBack());
                bitmap1 = Bitmap.createScaledBitmap(bitmap1, canvasWidth/4 -70, 350, false);
                gameModule.player2.get(i).Draw(canvas, bitmap1);

                gameModule.player1.get(i).setX((canvasWidth/4)*i +35);
                gameModule.player1.get(i).setY(200);
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources() , gameModule.player1.get(i).getidBack());
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, canvasWidth/4 -70, 350, false);
                gameModule.player1.get(i).Draw(canvas, bitmap2);
            }

            gameModule.deck.get(0).setX((canvasWidth/4)*3);
            gameModule.deck.get(0).setY((canvasHeight/2) -200);
            Bitmap bitmapDeck = BitmapFactory.decodeResource(getResources() , gameModule.deck.get(0).getidBack());
            bitmapDeck = Bitmap.createScaledBitmap(bitmapDeck, canvasWidth/4 -40, 380, false);
            gameModule.deck.get(0).Draw(canvas, bitmapDeck);

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

        /*if (event.getAction() == MotionEvent.ACTION_DOWN) {

            float touchX = event.getX();
            float touchY = event.getY();
            //נקודת הנגיעה

            float deckX = gameModule.deck.get(0).getX();
            float deckY = gameModule.deck.get(0).getY();
            //נקודת תחילת החפיסה
            float W = canvasWidth/4 -40;
            // רוחב חפיסה
            float H = 380;
            // גובה חפיסה

            if (touchX >= deckX && touchX <= deckX + W && touchY >= deckY &&touchY <= deckY + H){
                gameModule.deck.get(0).setX(canvasWidth/2);
            }

        }*/

    }
}

