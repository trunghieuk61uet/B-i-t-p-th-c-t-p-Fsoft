package gst.trainingcourse.lesson7_ex1_hieunt94;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SongDetailFragment extends Fragment {
    private Song mSong;
    private TextView mNameSongDetail;
    private TextView mDurationSongDetail;
    private TextView mAuthorSongDetail;
    private TextView mSizeKBSongDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_detail, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
    }

    private void initView(View view) {
        mNameSongDetail = view.findViewById(R.id.text_nameSongDetail);
        mAuthorSongDetail = view.findViewById(R.id.text_authorSongDetail);
        Bundle bundle = getArguments();
        if(bundle.containsKey("song")) {
            mSong = (Song) bundle.getSerializable("song");
            mNameSongDetail.setText(mSong.getName());
            mAuthorSongDetail.setText(mSong.getAuthor());
        }

    }

    private void initData() {

    }
}
