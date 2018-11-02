package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class OtherCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_card);
        CardView drowning = (CardView)findViewById(R.id.drowningId);
        drowning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdrown  = new Intent(OtherCard.this,com.example.mohit_pc.fsai.Drowning.class);
                startActivity(intentdrown);
            }
        });
        CardView breathing = (CardView)findViewById(R.id.breathingId);
        breathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbreath  = new Intent(OtherCard.this,com.example.mohit_pc.fsai.Breathing.class);
                startActivity(intentbreath);
            }
        });
        CardView snakebites = (CardView)findViewById(R.id.snakeBiteId);
        snakebites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsnake  = new Intent(OtherCard.this,com.example.mohit_pc.fsai.SnakeBite.class);
                startActivity(intentsnake);
            }
        });

    }
}
