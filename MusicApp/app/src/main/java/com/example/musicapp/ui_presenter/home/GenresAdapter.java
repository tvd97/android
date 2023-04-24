package com.example.musicapp.ui_presenter.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.databinding.ItemGenresBinding;
import com.example.musicapp.event.HandlerEventAdapter;
import com.example.musicapp.model.chart.list.Genres;

import java.util.ArrayList;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {
    private ArrayList<Genres> list= new ArrayList<>();
    public HandlerEventAdapter <Genres> event;

    @SuppressLint("NotifyDataSetChanged")
    public void submitData(ArrayList<Genres> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemGenresBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(v->event.onItemClick(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemGenresBinding binding;

        public ViewHolder(@NonNull ItemGenresBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Genres g) {
            binding.setG(g);
            binding.executePendingBindings();
        }
    }
}
