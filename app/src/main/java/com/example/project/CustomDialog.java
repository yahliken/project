package com.example.project;

import android.app.Dialog;
import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog {

    private RadioGroup radioGroup;
    private RadioButton radioPlayerOne,radioPlayerTwo;
    private Context context;
    private int idChosen;
    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.custom_dialog);
        this.context=context;
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);
        idChosen = radioGroup.getCheckedRadioButtonId();
        if( idChosen == radioPlayerOne.getId()){
           // (MainActivity(context)).whichPlayer(1);
        }
        else{
           // (MainActivity(context)).whichPlayer(2);
        }
    }
}
