package com.example.musicapp.ui_presenter.play;

import static com.example.musicapp.General.Actions.ACTION_NEXT;
import static com.example.musicapp.General.Actions.ACTION_PAUSE;
import static com.example.musicapp.General.Actions.ACTION_PLAY;
import static com.example.musicapp.General.Actions.ACTION_PREVIOUS;
import static com.example.musicapp.General.ListSong;
import static com.example.musicapp.General.ListSong.position;
import static com.example.musicapp.service.MusicService.mediaPlayer;
import static com.example.musicapp.service.MusicService.onNext;
import static com.example.musicapp.service.MusicService.onPlay;
import static com.example.musicapp.service.MusicService.onPrevious;
import static com.example.musicapp.service.MusicService.onShuffle;
import static com.example.musicapp.service.MusicService.prepareMedia;
import static com.example.musicapp.service.MusicService.repeat;
import static com.example.musicapp.service.MusicService.shuffle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.musicapp.General;
import com.example.musicapp.R;
import com.example.musicapp.databinding.FragmentPlayBinding;
import com.example.musicapp.model.chart.track.Tracks;
import com.example.musicapp.service.MusicService;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PlayFragment extends Fragment {
    private FragmentPlayBinding binding;
    ArrayList<Tracks> list = General.ListSong.list;
    boolean isPause = false;
    Handler handler = new Handler();
    private AudioManager audioManager;
    private Intent intent;
    private SharedPreferences sharedPreferences;
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, @NonNull Intent intent) {
            String action = intent.getExtras().getString("action");
            actionNotification(action);
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        audioManager = (AudioManager) requireContext().getSystemService(Context.AUDIO_SERVICE);
        onBinding(list.get(position));
        setAnimation();
        onStartService();
        requireContext().registerReceiver(receiver, new IntentFilter("MUSIC_APP"));
        onEventListener();
        setVolume();
        onUpdateProgressTime();
        getPreferences();
        onSetSongTime();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        requireContext().unregisterReceiver(receiver);
        MusicService.isRegisterBroadcast = false;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            handler.removeCallbacks(update);
            requireContext().stopService(intent);
        }

    }

    private void onBinding(Tracks s) {
        binding.setS(s);
        binding.executePendingBindings();
    }

    private void setAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_disk);
        binding.cardImg.startAnimation(animation);
    }

    private final Runnable update = new Runnable() {
        @Override
        public void run() {
            onUpdateProgressTime();
            binding.txtRealTime.setText(getTime(mediaPlayer.getCurrentPosition()));
        }
    };
    private final Runnable setTimeSong = () -> onSetSongTime();

    private void onSetSongTime() {
        handler.postDelayed(setTimeSong, 500);
        //check null media player
        if (mediaPlayer != null) {
            int duration = mediaPlayer.getDuration();
            binding.txtSongTime.setText(getTime(mediaPlayer.getDuration()));//set text view song time
            binding.progressTime.setMax(mediaPlayer.getDuration()/1000);//set max progress time
            // set event when media player complete the song
            mediaPlayer.setOnCompletionListener(complete -> {
                if (repeat != 0) {
                    if (repeat == 1) {
                        mediaPlayer.start();
                    } else {
                        if (shuffle)
                            onShuffle();
                        else {
                            if (position == ListSong.list.size() - 1)
                                position = 0;
                            else position++;
                        }
                        prepareMedia();
                        mediaPlayer.start();
                    }
                } else {
                    if (shuffle)
                        onShuffle();
                    else {
                        if (position == ListSong.list.size() - 1)
                            mediaPlayer.release();
                        else {
                            position++;
                            prepareMedia();
                            mediaPlayer.start();
                        }
                    }
                }
                binding.progressTime.setProgress(0);
            });
            // cancel callback when textview song time and event complete media was set
            if (mediaPlayer.getDuration() == duration)
                handler.removeCallbacks(setTimeSong);
        }

    }

    private void onUpdateProgressTime() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying())
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    binding.progressTime.setProgress(mediaPlayer.getCurrentPosition() / 1000, true);
                    handler.postDelayed(update, 500);
                }

        } else handler.postDelayed(update, 500);


    }

    @NonNull
    @Contract(pure = true)
    // convert milliseconds to hh:mm:ss
    private String getTime(long milliseconds) {
        String time = "";
        int hours = 0;
        int min = 0;
        int seconds = (int) milliseconds / 1000;
        if (seconds > 60) {
            min = seconds / 60;
            seconds = seconds % 60;
        }
        if (min > 59) {
            hours = min / 60;
            min = min % 60;

        }
        if (hours != 0) {
            if (hours < 10)
                time += "0" + hours + ":";
            else time += hours + ":";
        }

        if (min == 0)
            time += "00:";
        else {
            if (min < 10)
                time += "0" + min + ":";
            else time += min;
        }
        if (seconds == 0)
            time += "00";
        else {
            if (seconds < 10)
                time += "0" + seconds;
            else time += seconds;
        }


        return time;
    }

    private void onStartService() {
        intent = new Intent(requireContext(), MusicService.class);
        requireContext().startService(intent);
    }

    // handle action from notification
    private void actionNotification(@NonNull String action) {
        switch (action) {
            case ACTION_NEXT: {
                onNext(requireContext());
                onBinding(list.get(position));
                onUpdateProgressTime();
                break;
            }
            case ACTION_PREVIOUS: {
                onPrevious(requireContext());
                onBinding(list.get(position));
                onUpdateProgressTime();
                break;
            }
            case ACTION_PLAY: {
                onPlay(requireContext());
                onUpdateProgressTime();
                break;

            }
            case ACTION_PAUSE: {
                MusicService.onPause(requireContext());
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    //handle event button in context
    private void onEventListener() {
        binding.btnPlay.setOnClickListener(v -> {
            if (mediaPlayer != null)
                if (mediaPlayer.isPlaying()) {
                    isPause = true;
                    handler.removeCallbacks(update);
                    MusicService.onPause(requireContext());
                    binding.btnPlay.setImageResource(R.drawable.ic_baseline_play_arrow_48);
                } else {

                    if (isPause) {
                        onPlay(requireContext());
                        onUpdateProgressTime();
                        binding.btnPlay.setImageResource(R.drawable.ic_baseline_pause_24);
                    } else {
                        binding.progressTime.setMax(mediaPlayer.getDuration() / 1000);
                        binding.btnPlay.setImageResource(R.drawable.ic_baseline_pause_24);
                        onUpdateProgressTime();

                    }

                }
            else {
                requireContext().startService(intent);
                binding.btnPlay.setImageResource(R.drawable.ic_baseline_pause_24);
            }
        });
        binding.btnNext.setOnClickListener(v -> {
            onNext(requireContext());
            onBinding(list.get(position));
            onSetSongTime();
        });
        binding.btnPrevious.setOnClickListener(v -> {
            onPrevious(requireContext());
            onBinding(list.get(position));
            onSetSongTime();
        });
        binding.shuffle.setOnClickListener(v -> {
            shuffle = !shuffle;
            sharedPreferences.edit().putBoolean("shuffle", shuffle).apply();
            setShuffle(shuffle);
        });
        binding.repeat.setOnClickListener(v -> {
            if (repeat == 1)
                repeat = -1;
            else repeat++;
            sharedPreferences.edit().putInt("repeat", repeat).apply();
            setRepeat(repeat);
        });
    }

    // handle event change volume bar
    private void setVolume() {
        binding.volumeBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        binding.volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, seekBar.getProgress(), 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    // get data from share preferences
    private void getPreferences() {
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        shuffle = sharedPreferences.getBoolean("shuffle", false);
        repeat = sharedPreferences.getInt("repeat", 0);
        setShuffle(shuffle);
        setRepeat(repeat);


    }

    //handle event shuffle , random position
    private void setShuffle(boolean shuffle) {
        if (shuffle)
            binding.shuffle.setImageResource(R.drawable.ic_baseline_on_shuffle_24);
        else binding.shuffle.setImageResource(R.drawable.ic_baseline_shuffle_24);
    }

    //handle event repeat music
    private void setRepeat(int repeat) {
        if (repeat == 1)
            binding.repeat.setImageResource(R.drawable.ic_baseline_repeat_one_24);
        if (repeat == -1)
            binding.repeat.setImageResource(R.drawable.ic_baseline_on_repeat_24);
        if (repeat == 0)
            binding.repeat.setImageResource(R.drawable.ic_baseline_repeat_24);
    }

}