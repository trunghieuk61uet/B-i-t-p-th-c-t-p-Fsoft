package gst.trainingcourse.lesson7_ex2_hieunt94.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.R;
import gst.trainingcourse.lesson7_ex2_hieunt94.adapter.SongListAdapter;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Album;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Author;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Song;
import gst.trainingcourse.lesson7_ex2_hieunt94.data.SongData;

public class SongListFragment extends Fragment {
    private List<Song> mSongList;
    private Author mAuthor;
    private Album mAlbum;
    private TextView mSongListHeaderTxt;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_song_list, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
    }

    private void initData() {
        Bundle bundle = getArguments();
        if(bundle != null) {
            if(bundle.containsKey("author")) {
                mAuthor = (Author) bundle.getSerializable("author");
                mSongList = SongData.getInstance().findSongByAuthorId(mAuthor.getId());
            } else if(bundle.containsKey("album")) {
                mAlbum = (Album) bundle.getSerializable("album");
                mSongList = SongData.getInstance().findSongByAlbumId(mAlbum.getId());
            }
        } else {
            mSongList = SongData.getInstance().getAllSongList();
        }


    }

    private void initView(View view) {
        RecyclerView songListRecycler = view.findViewById(R.id.recycler_songList);
        SongListAdapter songListAdapter = new SongListAdapter(getActivity(), mSongList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        songListRecycler.setLayoutManager(layoutManager);
        songListRecycler.setAdapter(songListAdapter);
    }

}
