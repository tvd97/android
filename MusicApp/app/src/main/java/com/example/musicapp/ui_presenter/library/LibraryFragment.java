package com.example.musicapp.ui_presenter.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.musicapp.databinding.FragmentLibraryBinding;

public class LibraryFragment extends Fragment {


    private FragmentLibraryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        binding.btnPlaylist.setOnClickListener(v -> {
            Navigation.findNavController(getView())
                    .navigate(LibraryFragmentDirections.actionNavigationLibraryToSongOfflineFragment());
        });
        return binding.getRoot();
    }
}