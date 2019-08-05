package gst.trainingcourse.lesson7_ex2_hieunt94;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import gst.trainingcourse.lesson7_ex2_hieunt94.adapter.AlbumListAdapter;
import gst.trainingcourse.lesson7_ex2_hieunt94.adapter.AuthorListAdapter;
import gst.trainingcourse.lesson7_ex2_hieunt94.fragment.AlbumListFragment;
import gst.trainingcourse.lesson7_ex2_hieunt94.fragment.AuthorListFragment;
import gst.trainingcourse.lesson7_ex2_hieunt94.fragment.SongListFragment;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Album;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Author;

public class MainActivity
        extends FragmentActivity
        implements AuthorListAdapter.OnAuthorClickListener, AlbumListAdapter.OnAlbumClickListener {


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_main);
        ImageView imgAuthor = findViewById(R.id.icon_author);
        ImageView imgAlbum = findViewById(R.id.icon_album);

        imgAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout = findViewById(R.id.drawer_main);
                drawerLayout.openDrawer(GravityCompat.START);
                drawerLayout.closeDrawer(GravityCompat.END);
            }
        });

        imgAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout = findViewById(R.id.drawer_main);
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

        AuthorListFragment authorListFragment = new AuthorListFragment();
        authorListFragment.setAuthorClickListener(this);

        AlbumListFragment albumListFragment = new AlbumListFragment();
        albumListFragment.setOnAlbumClickListener(this);

        SongListFragment songListFragment = new SongListFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.navi_left, authorListFragment)
                .replace(R.id.navi_right, albumListFragment)
                .replace(R.id.linear_contentContainer, songListFragment)
                .commit();
    }

    @Override
    public void onAuthorClick(Author author) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("author", author);

        AlbumListFragment albumListFragment = new AlbumListFragment();
        albumListFragment.setOnAlbumClickListener(this);
        albumListFragment.setArguments(bundle);

        SongListFragment songListFragment = new SongListFragment();
        songListFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.navi_right, albumListFragment)
                .replace(R.id.linear_contentContainer, songListFragment)
                .commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        drawerLayout.openDrawer(GravityCompat.END);
    }

    public void onAlbumClick(Album album) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("album", album);

        SongListFragment songListFragment = new SongListFragment();

        songListFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.linear_contentContainer, songListFragment)
                .commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        drawerLayout.closeDrawer(GravityCompat.END);
    }

}
