package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class FireCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_card);
        CardView burns = (CardView)findViewById(R.id.burnId);
        burns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentburns  = new Intent(FireCard.this,com.example.mohit_pc.fsai.Burns.class);
                startActivity(intentburns);
            }
        });
        CardView extinguisher = (CardView)findViewById(R.id.extingusherId);
        extinguisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentExtingusher  = new Intent(FireCard.this,com.example.mohit_pc.fsai.ExtingusherText.class);
                startActivity(intentExtingusher);
            }
        });
        CardView clothes = (CardView)findViewById(R.id.clothesId);
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentClothes  = new Intent(FireCard.this,com.example.mohit_pc.fsai.ClothesText.class);
                startActivity(intentClothes);
            }
        });
    }
}
