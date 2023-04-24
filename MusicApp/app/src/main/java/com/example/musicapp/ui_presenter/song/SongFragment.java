package com.example.musicapp.ui_presenter.song;

import static com.example.musicapp.General.ListSong;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.musicapp.databinding.FragmentSongBinding;
import com.example.musicapp.model.chart.track.ChartTrack;
import com.example.musicapp.presenter_interface.SongInterface;

import java.io.File;

@RequiresApi(api = Build.VERSION_CODES.R)
public class SongFragment extends Fragment implements SongInterface.View {
    private FragmentSongBinding binding;
    private SongAdapter adapter;
    SongPresenterImp presenter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSongBinding.inflate(inflater, container, false);
        String id= requireArguments().getString("id");
        presenter = new SongPresenterImp(this);
        presenter.responseApi(id);
        adapter = new SongAdapter();
        binding.rcvSong.setAdapter(adapter);
        binding.rcvSong.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter.event = position -> {
            ListSong.position = position;
            Navigation.findNavController(requireView())
                    .navigate(SongFragmentDirections.actionSongFragmentToPlayFragment(true));
        };
        adapter.eventDownload = p -> checkPermission(
                ListSong.list.get(p).getHub().getActions().get(1).getUri(),
                ListSong.list.get(p).getTitle(),
                ListSong.list.get(p).getSubtitle()
        );
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
    public void onSuccess(@NonNull ChartTrack tracks) {
        ListSong.list = tracks.getTracks();
        adapter.submitData(ListSong.list, false);
        binding.progressBar.setVisibility(View.GONE);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void downloadFile(String url, String fileName, String singer) {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download file");
        request.setDescription("Downloading");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + File.separator + "MusicApp");
        //check exits folder->create if not exits
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        File fileDownload = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + File.separator + "MusicApp", fileName + "." + singer + ".m4a");
        request.setDestinationUri(Uri.fromFile(fileDownload));
        DownloadManager downloadManager = (DownloadManager) requireActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        if (downloadManager != null)
            downloadManager.enqueue(request);

    }

    // check request permission and request if permission is not license
    @RequiresApi(api = Build.VERSION_CODES.R)
    private void checkPermission(String url, String fileName, String singer) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                downloadFile(url, fileName, singer);
            } else {
                requireActivity().requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
                requireActivity().requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
            }
        }
    }

}