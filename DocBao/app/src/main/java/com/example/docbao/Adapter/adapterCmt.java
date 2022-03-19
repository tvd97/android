package com.example.docbao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.docbao.ClassModel.CommentChapter;
import com.example.docbao.R;

import java.util.List;

public class adapterCmt extends RecyclerView.Adapter<adapterCmt.ViewHolder> {
    Context context;
    List<CommentChapter> commentChapters;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.cststory_layout,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommentChapter cmt= commentChapters.get(position);
        ((ViewHolder) holder).txtCmt.setText(cmt.getContentComment());


    }

    @Override
    public int getItemCount() {
        return commentChapters.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView txtCmt;
        CardView cardCmt;

        public ViewHolder(@NonNull View itemView, TextView txtCmt, CardView cardCmt) {
            super(itemView);
            this.txtCmt = txtCmt;
            this.cardCmt = cardCmt;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCmt=(TextView) itemView.findViewById(R.id.txtCmt);
            cardCmt=(CardView) itemView.findViewById(R.id.cardCmt);
        }
    }
}
