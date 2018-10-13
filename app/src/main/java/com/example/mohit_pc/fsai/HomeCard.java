package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_card);
        CardView heartattack = (CardView)findViewById(R.id.heartAttackId);
        heartattack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentheart  = new Intent(HomeCard.this,com.example.mohit_pc.fsai.Heartattack.class);
                startActivity(intentheart);
            }
        });
        CardView chestpain = (CardView)findViewById(R.id.chestPainId);
        chestpain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentchest  = new Intent(HomeCard.this,com.example.mohit_pc.fsai.ChestPain.class);
                startActivity(intentchest);
            }
        });
    }

}
