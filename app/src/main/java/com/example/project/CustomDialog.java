package com.example.project;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private RadioGroup radioGroup;
    private RadioButton radioPlayerOne,radioPlayerTwo;
    private int player;
    private Button btnSubmit;
    private Context context;
    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.custom_dialog);
        this.context=context;
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        radioPlayerOne = findViewById(R.id.radioPlayerOne);
        radioPlayerTwo = findViewById(R.id.radioPlayerTwo);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {

                if( checkedId == radioPlayerOne.getId())
                {
                    player = 1;
                }
                else if(checkedId == radioPlayerTwo.getId()){
                    player = 2;
                }
            }
        }));

    }

    @Override
    public void onClick(View v) {
        Intent iStartGame = new Intent(context, GameActivity.class);
            iStartGame.putExtra("player" , player);
            context.startActivity(iStartGame);

    }
}
