
package com.example.musicapp.ui_presenter.offline;

import static com.example.musicapp.General.ListSong;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.musicapp.databinding.FragmentSongOfflineBinding;
import com.example.musicapp.model.Hub;
import com.example.musicapp.model.chart.track.Tracks;
import com.example.musicapp.model.songs.tracks.Actions;
import com.example.musicapp.ui_presenter.song.SongAdapter;

import java.io.File;
import java.util.ArrayList;


public class SongOfflineFragment extends Fragment {

    private FragmentSongOfflineBinding binding;
    private File[] files;
    private SongAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSongOfflineBinding.inflate(inflater, container, false);

        adapter = new SongAdapter();
        adapter.submitData(ListSong.list, true);
        binding.rcvSong.setAdapter(adapter);
        checkPermission();
        binding.rcvSong.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter.event = position -> {
            ListSong.position = position;
            Navigation.findNavController(requireView())
                    .navigate(SongOfflineFragmentDirections.actionSongOfflineFragmentToPlayFragment(false));
        };
        return binding.getRoot();
    }

    private void readFileStorage() {
        ListSong.list.clear();
        File file = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + File.separator + "MusicApp"
        );
        //check exits folder->read file children
        if (file.isDirectory()) {
            files = file.listFiles();
        } else
            file.mkdirs();// folder is not exits-> create folder
        if (files != null) {
            //check file children in folder-> read file name and add to list song
            for (File f : files) {
                if (!f.isDirectory()) {
                    String[] fName = f.getName().split("[.\\-]");
                    Tracks t = new Tracks();
                    Hub h = new Hub();
                    Actions a = new Actions();
                    a.setUri(f.getPath());
                    ArrayList<Actions> actions = new ArrayList<>();
                    actions.add(a);
                    h.setActions(actions);
                    t.setTitle(fName[0]);
                    t.setSubtitle(fName[1]);
                    t.setHub(h);
                    ListSong.list.add(t);
                }
            }
        }
        adapter.submitData(ListSong.list, true);
        binding.progressBar.setVisibility(View.GONE);
        binding.textLoading.setVisibility(View.GONE);
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                readFileStorage();
            } else {
                requireActivity().requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
                requireActivity().requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
            }
        }
    }
}