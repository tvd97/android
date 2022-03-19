package com.example.docbao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docbao.ClassModel.ChapterStory;
import com.example.docbao.R;

import java.util.List;

public class adapterChap extends  RecyclerView.Adapter<adapterChap.ViewHolder> {
    Context context;
    List<ChapterStory> chstories;

    public adapterChap(Context context, List<ChapterStory> stories) {
        this.context = context;
        this.chstories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.cstitemchapter_layout,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ChapterStory chap= chstories.get(position);
        ((ViewHolder)holder).txtChapter.setText(chap.getChapterStory());
    }

    @Override
    public int getItemCount() {

        return chstories.size();

    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView txtChapter;
        CardView cardChap;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtChapter=(TextView) itemView.findViewById(R.id.txtChapter);
            cardChap=(CardView) itemView.findViewById(R.id.cvChapter);

        }
    }
}
