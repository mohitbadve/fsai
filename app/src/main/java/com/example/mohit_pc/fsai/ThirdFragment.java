package com.example.mohit_pc.fsai;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import static android.content.ContentValues.TAG;


public class ThirdFragment extends Fragment {
    View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout,container,false);
        return myView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton imageButton = view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCall = "tel: 101";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(testCall));
                if(dialIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(dialIntent);
                }
                else {
                    Log.e(TAG,"Can't resolve for DialIntent");
                }
            }
        });
        ImageButton imageButton2 = (ImageButton)view.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCall = "tel: 108";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(testCall));
                if(dialIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(dialIntent);
                }
                else {
                    Log.e(TAG,"Can't resolve for DialIntent");
                }
            }
        });
        ImageButton imageButton3 = (ImageButton)view.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCall = "tel: 02222694725";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(testCall));
                if(dialIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(dialIntent);
                }
                else {
                    Log.e(TAG,"Can't resolve for DialIntent");
                }
            }
        });
        ImageButton imageButton4 = (ImageButton)view.findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCall = "tel: 22633333";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(testCall));
                if(dialIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(dialIntent);
                }
                else {
                    Log.e(TAG,"Can't resolve for DialIntent");
                }
            }
        });
        ImageButton imageButton5 = (ImageButton)view.findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCall = "tel: 23076111";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(testCall));
                if(dialIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(dialIntent);
                }
                else {
                    Log.e(TAG,"Can't resolve for DialIntent");
                }
            }
        });
        ImageButton imageButton6 = (ImageButton)view.findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCall = "tel: 9833331111";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(testCall));
                if(dialIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(dialIntent);
                }
                else {
                    Log.e(TAG,"Can't resolve for DialIntent");
                }
            }
        });
        ImageButton imageButton7 = (ImageButton)view.findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCall = "tel: 100";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse(testCall));
                if(dialIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(dialIntent);
                }
                else {
                    Log.e(TAG,"Can't resolve for DialIntent");
                }
            }
        });




    }
}
