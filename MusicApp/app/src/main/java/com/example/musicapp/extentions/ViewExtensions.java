package com.example.musicapp.extentions;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.musicapp.R;


public class ViewExtensions {
    //set link online image for ImageView
    @BindingAdapter("url")
    public static void loadImage(ImageView img, String link) {
        Glide.with(img)
                .load(link)
                .placeholder(R.drawable.ic_baseline_music_note_24)
                .into(img);
    }
}