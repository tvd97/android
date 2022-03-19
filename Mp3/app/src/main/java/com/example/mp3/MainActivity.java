package com.example.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView name, timeplay,timetotal;
    ImageView img;
    ImageButton play, next,previous;
    SeekBar realtimeplay;
    ArrayList<Song> songs;
    int position=0;
    MediaPlayer media;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
//        MappingSong();
//        creatMedia();
//        timeTotal();
//        setPlay();
        animation= AnimationUtils.loadAnimation(this,R.anim.disk_run);
        img.setAnimation(animation);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                if (media.isPlaying()) {
//                    //dang chay->pause;doi hinh
//                    media.pause();
//                    play.setImageResource(R.drawable.play);
//                    setPlay();
//
//                } else {
//                    //dang ngung->phat-> doi hinh
//                    media.start();
//                    play.setImageResource(R.drawable.pause);
//                    setPlay();
//                }
                String url="http://data.ising.bz/data/karaokes/all/1083856.mp3";
                MediaPlayer mediaPlayer= new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                }
               catch (IOException e)
               {
                   Log.e("err",e.getMessage());
               }



            }

        });
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                position++;
//                if(position>(songs.size()-1))
//                {
//                    position=0;
//                    if(media.isPlaying())
//                    {
//                        media.stop();
//                    }
//                    creatMedia();
//                    media.start();
//                    setPlay();
//                }
//            }
//        });
//        previous.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                position--;
//                if(position<0)
//                {
//                    position= songs.size()-1;
//                    if(media.isPlaying())
//                    {
//                        media.stop();
//                    }
//                    creatMedia();
//                    media.start();
//                    setPlay();
//                }
//            }
//        });
        realtimeplay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //nhay doan
                media.seekTo(realtimeplay.getProgress());
            }
        });
    }
    public  void Mapping()
    {
        name=(TextView) findViewById(R.id.txtname);
        timeplay= (TextView) findViewById(R.id.timeplay);
        timetotal=(TextView)findViewById(R.id.timesum);
        realtimeplay=(SeekBar) findViewById(R.id.seeplay);
        previous=(ImageButton)findViewById(R.id.previousbtn);
        play=(ImageButton) findViewById(R.id.playbtn);
        next=(ImageButton) findViewById(R.id.nextbtn);
        img=(ImageView) findViewById(R.id.image);
    }
//    private void MappingSong()
//    {
//        songs= new ArrayList<>();
//        songs.add(new Song("Về Đâu Mái Tóc Người Thương",R.raw.ve_dau_mai_toc_nguoi_thuong));
//        songs.add(new Song("Lo hen cau the",R.raw.ve_dau_mai_toc_nguoi_thuong));
//    }
//    private void creatMedia()
//    {
//        media= MediaPlayer.create(MainActivity.this,songs.get(position).getUrl());
//        name.setText(songs.get(position).getName());
//    }
//    private void  timeTotal()
//    {
//        SimpleDateFormat formattime= new SimpleDateFormat("mm:ss");
//
//        timetotal.setText(formattime.format(media.getDuration()));
//        // gan mask seebar= media.getDuration()
//        realtimeplay.setMax(media.getDuration());
//    }
//    private void setPlay()
//    {
//        Handler handler= new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                SimpleDateFormat timepl= new SimpleDateFormat("mm:ss");
//                //chay seebar theo time
//                timeplay.setText(timepl.format(media.getCurrentPosition()));
//                //
//                realtimeplay.setProgress(media.getCurrentPosition());
//                // kiem tra thoi gian ket thuc
//                media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//
//                        position--;
//                        if(position<0)
//                        {
//                            position= songs.size()-1;
//                            if(media.isPlaying())
//                            {
//                                media.stop();
//                            }
//                            creatMedia();
//                            media.start();
//                            timeTotal();
//                            setPlay();
//                        }
//                    }
//                });
//                handler.postDelayed(this,500);
//            }
//        },100);
//    }
}