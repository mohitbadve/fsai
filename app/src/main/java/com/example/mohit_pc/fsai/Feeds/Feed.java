package com.example.mohit_pc.fsai.Feeds;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mohit_pc.fsai.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Feed extends Fragment {
View rootView;
RecyclerView recyclerView;
ArrayList<BluePrintFeed> feed = new ArrayList<>();
    public Feed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getData();
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_feed, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewSetter();

    }

    void viewSetter(){
        recyclerView = (RecyclerView)rootView.findViewById(R.id.feedRecycler);
    }

    void getData(){
        String path = "feeds/";
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot childs : dataSnapshot.getChildren()){
                    feed.add(childs.getValue(BluePrintFeed.class));
                }
                setRecycler();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }



    void setRecycler(){
        FeedAdapter adapter = new FeedAdapter(getContext(),feed);
//        Toast.makeText(getContext(), "Size "+Integer.toString(feed.size()), Toast.LENGTH_SHORT).show();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);





    }

}
