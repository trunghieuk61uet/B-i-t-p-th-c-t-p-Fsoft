package gst.trainingcourse.lesson7_ex1_hieunt94;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SongListFragment extends Fragment {

    private List<Song> mSongList;

    private OnFragmentInteractionListenter listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_list, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListenter && context instanceof Activity) {
            listener = (OnFragmentInteractionListenter) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void initView(View view) {
        RecyclerView songListRecycler = view.findViewById(R.id.recycler_songList);
        SongListAdapter songListAdapter = new SongListAdapter(getActivity(), mSongList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        songListRecycler.setAdapter(songListAdapter);
        songListRecycler.setLayoutManager(layoutManager);


    }

    private void initData() {
        mSongList = new ArrayList<>();
        mSongList.add(new Song("Havana", "Camila Cabello", "5:00", 12000));
        mSongList.add(new Song("Senorita", "Camila Cabello", "4:00", 7000));
        mSongList.add(new Song("Mean", "Taylor Swift", "6:00", 12000));
        mSongList.add(new Song("Gorgeous", "Taylor Swift", "3:00", 12000));
        mSongList.add(new Song("Blank Space", "Taylor Swift", "5:00", 12000));
        mSongList.add(new Song("Red", "Taylor Swift", "5:00", 12000));
        mSongList.add(new Song("Back To December", "Taylor Swift", "5:00", 120));
        mSongList.add(new Song("The Story Of Us", "Taylor Swift", "5:00", 12000));
        mSongList.add(new Song("Perfect", "Ed Sheeran", "5:00", 12000));
        mSongList.add(new Song("Young Dumb & Broke", "Khalid", "5:00", 1100));
        mSongList.add(new Song("Baby", "Justin Bieber", "5:00", 12000));
        mSongList.add(new Song("when the party's over", "Billie Eilish", "5:00", 12000));
        mSongList.add(new Song("Someone You Loved", "Lewis Capaldi", "5:00", 12000));
        mSongList.add(new Song("Hold Me While You Wait", "Lewis Capaldi", "5:00", 12000));
    }

    public interface OnFragmentInteractionListenter {
        public void onSongSelected(Song song);
    }

}
