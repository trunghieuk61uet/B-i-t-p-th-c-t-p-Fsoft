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
import gst.trainingcourse.lesson7_ex2_hieunt94.adapter.AuthorListAdapter;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Author;
import gst.trainingcourse.lesson7_ex2_hieunt94.data.AuthorData;

public class AuthorListFragment extends Fragment {
    private List<Author> mAuthorList;
    private AuthorListAdapter.OnAuthorClickListener authorClickListener;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_author_list, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
    }

    private void initData() {
        mAuthorList = AuthorData.getInstance().getAllAuthorList();
    }

    private void initView(View view) {
        RecyclerView authorListRecycler = view.findViewById(R.id.recycler_authorList);
        AuthorListAdapter authorListAdapter = new AuthorListAdapter(getActivity(), mAuthorList, authorClickListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        authorListRecycler.setLayoutManager(layoutManager);
        authorListRecycler.setAdapter(authorListAdapter);
    }

    public void setAuthorClickListener(AuthorListAdapter.OnAuthorClickListener listener) {
        this.authorClickListener = listener;
    }
}
