package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button twoPlayers, againstComputer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        twoPlayers = findViewById(R.id.twoPlayers);
        twoPlayers.setOnClickListener(this);
        againstComputer = findViewById(R.id.againstComputer);
        againstComputer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == twoPlayers){
            CustomDialog customDialog = new CustomDialog(this);
            customDialog.show();
        }
        else{

        }

    }
}