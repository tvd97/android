package com.example.docbao.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docbao.ClassModel.Story;
import com.example.docbao.R;
import com.example.docbao.activity.ChapterActivity;
import com.example.docbao.activity.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class adapterStr extends RecyclerView.Adapter<adapterStr.ViewHolder> {
    Context context;
    ArrayList<Story> stories;

    public adapterStr(Context context, ArrayList<Story> stories) {
        this.context = context;
        this.stories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.cststory_layout,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story item= stories.get(position);
        ((ViewHolder)holder).txtStr.setText(item.getNameStory());


    }

    @Override
    public int getItemCount()
    {
        return stories.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView txtStr;
        CardView cardStr;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtStr=(TextView) itemView.findViewById(R.id.txtStr);
            cardStr=(CardView) itemView.findViewById(R.id.cardStr);
        }
    }
}
