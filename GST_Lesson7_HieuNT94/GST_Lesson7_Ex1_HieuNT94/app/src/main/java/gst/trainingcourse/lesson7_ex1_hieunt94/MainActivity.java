package gst.trainingcourse.lesson7_ex1_hieunt94;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements SongListFragment.OnFragmentInteractionListenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SongListFragment songListFragment = new SongListFragment();
        fragmentTransaction.add(R.id.container_songList, songListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onSongSelected(Song song) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("song", song);
        if(findViewById(R.id.container_songDetail) != null) {
            SongDetailFragment songDetailFragment = new SongDetailFragment();
            songDetailFragment.setArguments(bundle);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_songDetail, songDetailFragment);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(this, SongDetailActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
