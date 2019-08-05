package gst.trainingcourse.lesson6_hieunt94

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recycleViewlistSong.layoutManager = layoutManager

        val layoutManagerAuthor = LinearLayoutManager(this)
        layoutManagerAuthor.orientation = LinearLayoutManager.HORIZONTAL
        recycleViewlistAuthor.layoutManager = layoutManagerAuthor


        val adapter = SongAdapter(this, Song.song)
        recycleViewlistSong.adapter = adapter

        val adapterAuthor = AuthorAdapter(this, Song.song)
        recycleViewlistAuthor.adapter = adapterAuthor
    }
}
