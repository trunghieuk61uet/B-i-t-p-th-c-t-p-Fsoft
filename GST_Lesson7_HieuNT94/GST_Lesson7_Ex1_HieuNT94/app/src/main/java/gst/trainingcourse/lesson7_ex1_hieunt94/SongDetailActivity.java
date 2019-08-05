package gst.trainingcourse.lesson7_ex1_hieunt94;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SongDetailActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Bundle bundle = getIntent().getExtras();

        SongDetailFragment songDetailFragment = new SongDetailFragment();
        songDetailFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_songDetailHandset, songDetailFragment);
        fragmentTransaction.commit();
    }
}
