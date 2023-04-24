package com.example.musicapp.ui_presenter.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.musicapp.databinding.FragmentHomeBinding;
import com.example.musicapp.model.chart.list.ChartList;
import com.example.musicapp.presenter_interface.HomeInterface;

public class HomeFragment extends Fragment implements HomeInterface.View {

    private FragmentHomeBinding binding;
    HomePresenterImp presenter;
    private GenresAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        presenter = new HomePresenterImp(this);
        adapter = new GenresAdapter();
        presenter.responseApi();
        binding.rcvNewSong.setAdapter(adapter);
        binding.rcvNewSong.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter.event = genres -> Navigation.findNavController(requireView())
                .navigate(HomeFragmentDirections.actionNavigationHomeToSongFragment(genres.getListid()));
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onError(@NonNull Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onSuccess(@NonNull ChartList list) {
        adapter.submitData(list.getGlobal().getGenres());
    }
}