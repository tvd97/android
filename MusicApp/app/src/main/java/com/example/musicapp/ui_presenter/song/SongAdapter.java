package com.example.musicapp.ui_presenter.song;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.databinding.ItemSongBinding;
import com.example.musicapp.event.HandlerEventAdapter;
import com.example.musicapp.model.chart.track.Tracks;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private ArrayList<Tracks> list = new ArrayList<>();
    public HandlerEventAdapter<Integer> event;
    public HandlerEventAdapter<Integer> eventDownload;
    private  boolean isOffline;


    @SuppressLint("NotifyDataSetChanged")
    public void submitData(ArrayList<Tracks> list, boolean isOffline) {
        this.list = list;
        this.isOffline=isOffline;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBinds(list.get(position));
        holder.itemView.setOnClickListener(v -> event.onItemClick(position));
        holder.binding.download.setOnClickListener(v-> eventDownload.onItemClick(position));
        if (isOffline)
        {
            holder.binding.download.setVisibility(View.GONE);
            holder.binding.more.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemSongBinding binding;

        public ViewHolder(@NonNull ItemSongBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBinds(Tracks t) {
            binding.setT(t);
            binding.executePendingBindings();
        }
    }
}
