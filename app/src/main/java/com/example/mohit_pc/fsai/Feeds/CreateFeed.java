package com.example.mohit_pc.fsai.Feeds;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mohit_pc.fsai.R;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFeed extends Fragment {

    View rootView;
    EditText title,content,written;
    Button button;
    Uri uri = null;

    public CreateFeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_create_feed, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = (EditText)rootView.findViewById(R.id.title);
        content = (EditText)rootView.findViewById(R.id.content);
        written = (EditText)rootView.findViewById(R.id.writtenBy);
        button = (Button)rootView.findViewById(R.id.createButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uri == null){
                    imagePicker();
                }
                else{
                    upload();
                }
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 64){
            if(resultCode == RESULT_OK){
                uri = data.getData();
                button.setText("Upload");

            }else {
                Snackbar.make(rootView,"Error Getting Image",Snackbar.LENGTH_LONG).show();
            }
        }
    }

    void imagePicker(){

        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i,"Select Image"),64);


    }
    void  upload(){
        if(TextUtils.isEmpty(title.getText().toString())
                ||TextUtils.isEmpty(content.getText().toString())
                ||TextUtils.isEmpty(written.getText().toString())){
            Snackbar.make(rootView,"Fields cant be left empty",Snackbar.LENGTH_LONG).show();
            return;
        }
        String path = "feeds/images/";
        File file = new File(uri.getPath());
        if(file == null){
            Snackbar.make(rootView,"ERror getting image",Snackbar.LENGTH_LONG).show();
            return;
        }
        path += file.getName();
        final StorageReference storageReference = FirebaseStorage.getInstance().getReference(path);
        Task<Uri> task = storageReference.putFile(uri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if(!task.isSuccessful()){
                    throw task.getException();
                }else{
                    return storageReference.getDownloadUrl();
                }

            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if(task.isSuccessful()){
                    uploadToDataBase(task.getResult());
                }
            }
        });



    }
    void uploadToDataBase(Uri uri){
        String path = "feeds/";
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(path);
        String key = ref.push().getKey();
        BluePrintFeed feed = new
                BluePrintFeed(content.getText().toString(),written.getText().toString(),uri.toString(),title.getText().toString());
        ref.child(key).setValue(feed).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Snackbar.make(rootView,"Feed Added Successfully",Snackbar.LENGTH_LONG).show();
            }
        });



    }
}
