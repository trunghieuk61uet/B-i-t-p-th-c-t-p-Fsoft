package gst.trainingcourse.lesson7_ex2_hieunt94.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.R;
import gst.trainingcourse.lesson7_ex2_hieunt94.adapter.AlbumListAdapter;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Album;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Author;
import gst.trainingcourse.lesson7_ex2_hieunt94.data.AlbumData;

public class AlbumListFragment extends Fragment {

    private List<Album> mAlbumList;
    private Author mAuthor;
    private AlbumListAdapter.OnAlbumClickListener onAlbumClickListener;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_album_list, null);
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
        if(bundle != null && bundle.containsKey("author")) {
            mAuthor = (Author) bundle.getSerializable("author");
            mAlbumList = AlbumData.getInstance().findAlbumByAuthorId(mAuthor.getId());
        } else {
            mAlbumList = AlbumData.getInstance().getAllAlbumList();
        }
    }

    private void initView(View view) {
        RecyclerView albumListRecycler = view.findViewById(R.id.recycler_albumList);
        AlbumListAdapter albumListAdapter = new AlbumListAdapter(getActivity(), mAlbumList, onAlbumClickListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        albumListRecycler.setLayoutManager(layoutManager);
        albumListRecycler.setAdapter(albumListAdapter);
    }

    public void setOnAlbumClickListener(AlbumListAdapter.OnAlbumClickListener onAlbumClickListener) {
        this.onAlbumClickListener = onAlbumClickListener;
    }
}
