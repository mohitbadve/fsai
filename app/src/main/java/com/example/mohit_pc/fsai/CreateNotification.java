package com.example.mohit_pc.fsai;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNotification extends android.support.v4.app.Fragment {

View rootView;
Button publish;
EditText title,message;


    public CreateNotification() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView  =  inflater.inflate(R.layout.fragment_create_notification, container, false);
        return  rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        publish = (Button)rootView.findViewById(R.id.publishAlert);
        title = (EditText) rootView.findViewById(R.id.alertTitle);
        message = (EditText) rootView.findViewById(R.id.alertMessage);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "alerts/";
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);

                if(TextUtils.isEmpty(message.getText().toString())||TextUtils.isEmpty(title.getText().toString())){
                    Snackbar.make(rootView,"Fill All Details",Snackbar.LENGTH_LONG).show();
                    return;
                }

                AlertBluePrint alert = new AlertBluePrint(message.getText().toString(),title.getText().toString());
                String key = reference.push().getKey();
                reference.child(key).setValue(alert).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Snackbar.make(rootView,"Published Alert",Snackbar.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}
