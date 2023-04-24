package com.example.musicapp.broadcast;

import static com.example.musicapp.General.Actions.ACTION_NEXT;
import static com.example.musicapp.General.Actions.ACTION_PAUSE;
import static com.example.musicapp.General.Actions.ACTION_PLAY;
import static com.example.musicapp.General.Actions.ACTION_PREVIOUS;
import static com.example.musicapp.service.MusicService.isRegisterBroadcast;
import static com.example.musicapp.service.MusicService.onNext;
import static com.example.musicapp.service.MusicService.onPlay;
import static com.example.musicapp.service.MusicService.onPrevious;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.musicapp.service.MusicService;

public class NotificationReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (isRegisterBroadcast)
            context.sendBroadcast(new Intent("MUSIC_APP").putExtra("action", intent.getAction()));
        else {
            actionNotification(intent.getAction(),context);
        }
    }

    private void actionNotification(@NonNull String action,Context context) {
        switch (action) {
            case ACTION_NEXT: {
                onNext(context);
                break;
            }
            case ACTION_PREVIOUS: {
                onPrevious(context);
                break;
            }
            case ACTION_PLAY: {
                onPlay(context);
                break;

            }
            case ACTION_PAUSE: {
                MusicService.onPause(context);
                break;
            }
        }
    }

}