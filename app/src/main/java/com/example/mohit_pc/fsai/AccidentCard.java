package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class AccidentCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident_card);

        CardView amputation = (CardView)findViewById(R.id.amputationId);
        amputation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAmp  = new Intent(AccidentCard.this,com.example.mohit_pc.fsai.AmputationText.class);
                startActivity(intentAmp);
            }
        });
        CardView headinjury =(CardView)findViewById(R.id.headInjuryId);
        headinjury.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentHeadInj=new Intent(AccidentCard.this,com.example.mohit_pc.fsai.HeadInjuryText.class);
                startActivity(intentHeadInj);
            }


        });
        CardView fracture = (CardView)findViewById(R.id.fractureId);
        fracture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentfracture  = new Intent(AccidentCard.this,com.example.mohit_pc.fsai.Fracture.class);
                startActivity(intentfracture);
            }
        });


    }
}
