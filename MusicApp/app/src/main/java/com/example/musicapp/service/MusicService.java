package com.example.musicapp.service;


import static android.app.PendingIntent.FLAG_IMMUTABLE;
import static com.example.musicapp.General.ListSong;
import static com.example.musicapp.General.ListSong.list;
import static com.example.musicapp.General.ListSong.position;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.musicapp.General;
import com.example.musicapp.R;
import com.example.musicapp.broadcast.NotificationReceiver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MusicService extends Service {


    public static MediaPlayer mediaPlayer;
    private static MediaSessionCompat mediaSessionCompat;
    public static PendingIntent actionNext;
    public static PendingIntent actionPrevious;
    public static PendingIntent actionPlay;
    public static PendingIntent actionPause;
    private static NotificationManager manager;
    public static final Map<Integer, Integer> isPlayed = new HashMap<>();
    public static boolean shuffle;
    public static int repeat;
    public static boolean isRegisterBroadcast = true;

    @Override
    public IBinder onBind(Intent intent) {
        /* TODO: Return the communication channel to the service. */
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate() {
        super.onCreate();
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();

        actionNext = PendingIntent.getBroadcast(
                this, 0,
                new Intent(this, NotificationReceiver.class).setAction(General.Actions.ACTION_NEXT), FLAG_IMMUTABLE);
        actionPrevious = PendingIntent.getBroadcast(
                this, 0,
                new Intent(this, NotificationReceiver.class).setAction(General.Actions.ACTION_PREVIOUS), FLAG_IMMUTABLE);
        actionPlay = PendingIntent.getBroadcast(
                this, 0,
                new Intent(this, NotificationReceiver.class).setAction(General.Actions.ACTION_PLAY),
                FLAG_IMMUTABLE);
        actionPause = PendingIntent.getBroadcast(
                this, 0,
                new Intent(this, NotificationReceiver.class).setAction(General.Actions.ACTION_PAUSE),
                FLAG_IMMUTABLE);
        manager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        prepareMedia();

        mediaSessionCompat = new MediaSessionCompat(this, General.Actions.MEDIA_TAG);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChanel();
        createNotification(this);
        startForeground(200, createNotification(this).build());
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer = null;
    }

    //add data for media player
    public static void prepareMedia() {
        String url;
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();

        try {
            url = list.get(position).getHub().getActions().size() == 2 ?
                    list.get(position).getHub().getActions().get(1).getUri() :
                    list.get(position).getHub().getActions().get(0).getUri();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static NotificationCompat.Builder createNotification(Context context) {
        NotificationCompat.Builder notification;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new NotificationCompat.Builder(context, General.Actions.CHANNEL_ID);
        } else notification = new NotificationCompat.Builder(context);
        notification.setSmallIcon(R.drawable.ic_baseline_music_note_24)
                .setContentText(ListSong.list.get(position).getTitle())
                .addAction(
                        R.drawable.ic_baseline_skip_previous_24, "", actionPrevious)
                .addAction(
                        R.drawable.ic_baseline_pause_24, "", actionPause)
                .addAction(R.drawable.ic_baseline_skip_next_24, "", actionNext)
                .setAutoCancel(false)
                .setOnlyAlertOnce(true)
                .setShowWhen(false)
                .setOngoing(mediaPlayer.isPlaying())
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(0, 1, 2)
                        .setMediaSession(mediaSessionCompat.getSessionToken()));

        return notification;
    }

    private void createChanel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(General.Actions.CHANNEL_ID,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_LOW);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null)
                notificationManager.createNotificationChannel(channel);
        }
    }

    public static void onNext(Context context) {
        if (shuffle)
            onShuffle();
        else {
            position++;
            if (position == ListSong.list.size()) {
                position = 0;
            }
        }
        if (mediaPlayer.isPlaying()) {
            prepareMedia();
            mediaPlayer.start();
        }
        changeNotification(context);
    }

    public static void onPrevious(Context context) {
        if (shuffle)
            onShuffle();
        else {
            if (position == 0)
                position = ListSong.list.size() - 1;
            else position--;
        }
        if (mediaPlayer.isPlaying()) {
            prepareMedia();
            mediaPlayer.start();
        }
        changeNotification(context);
    }

    public static void onPlay(Context context) {
        mediaPlayer.start();
        manager.notify(200, createNotification(context).clearActions()
                .addAction(
                        R.drawable.ic_baseline_skip_previous_24, "", actionPrevious)
                .addAction(
                        R.drawable.ic_baseline_pause_24, "", actionPause)
                .addAction(R.drawable.ic_baseline_skip_next_24, "", actionNext)
                .build());

    }

    public static void onPause(Context context) {
        mediaPlayer.pause();
        manager.notify(200, createNotification(context).clearActions()
                .addAction(
                        R.drawable.ic_baseline_skip_previous_24, "", actionPrevious)
                .addAction(
                        R.drawable.ic_baseline_play_arrow_24, "", actionPlay)
                .addAction(R.drawable.ic_baseline_skip_next_24, "", actionNext)
                .build());
    }

    public static void changeNotification(Context context) {
        manager.notify(200, createNotification(context)
                .setContentText(General.ListSong.list.get(position).getTitle())
                .build());
    }

    public static void onShuffle() {
        int mPosition = (int) ((Math.random()) * ListSong.list.size() + 0);
        int size = isPlayed.size();
        isPlayed.put(mPosition, mPosition);
        if (isPlayed.size() == size) {
            if (repeat != 0) {
                isPlayed.clear();
                onShuffle();
            }
        } else position = mPosition;

    }

}