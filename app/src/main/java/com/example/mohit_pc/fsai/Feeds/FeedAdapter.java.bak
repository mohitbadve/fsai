package com.example.mohit_pc.fsai.Feeds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohit_pc.fsai.R;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    Context c;
    ArrayList<BluePrintFeed> feeds;


    public FeedAdapter(Context c, ArrayList<BluePrintFeed> feeds){
        this.c  = c;
        this.feeds = feeds;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return  new  ViewHolder(LayoutInflater.from(c).inflate(R.layout.adapter,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.unExpandedTitle.setText(feeds.get(i).getTitle());

        try {
            Picasso.get().load(feeds.get(i).getImage()).fit().centerCrop().into(viewHolder.unExpandedImage);
        }catch (Exception e){

        }


    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        FoldingCell fc;
        ImageView expandedImage,unExpandedImage;
        TextView unExpandedTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            unExpandedImage = itemView.findViewById(R.id.unExpandImage);
            unExpandedTitle = itemView.findViewById(R.id.unExpandTitle);




            fc = itemView.findViewById(R.id.folding_cell);
            fc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fc.toggle(false);
                }
            });
        }
    }
}
