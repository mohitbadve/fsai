package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FirstFragment extends Fragment {
    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout,container,false);
        return myView;
    }

   @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*Button b = view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "So True", Toast.LENGTH_SHORT).show();
            }
        });*/
        CardView acc = view.findViewById(R.id.accCard);
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
               Intent intentAcc = new Intent(getActivity(),com.example.mohit_pc.fsai.AccidentCard.class);
                startActivity(intentAcc);

            }

        });
       CardView home = view.findViewById(R.id.homeCard);
       home.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
               Intent intentHome = new Intent(getActivity(),com.example.mohit_pc.fsai.HomeCard.class);
               startActivity(intentHome);
           }

       });
       CardView fire = view.findViewById(R.id.fireCard);
       fire.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
               Intent intentFire = new Intent(getActivity(),com.example.mohit_pc.fsai.FireCard.class);
               startActivity(intentFire);
           }

       });
       CardView other = view.findViewById(R.id.otherCard);
       other.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
               Intent intentOther = new Intent(getActivity(),com.example.mohit_pc.fsai.OtherCard.class);
               startActivity(intentOther);
           }

       });
    }
}
