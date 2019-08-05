package gst.trainingcourse.lesson6_hieunt94

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_song.view.*

class SongAdapter(private val context: Context, private val song: List<dataSong> ) : RecyclerView.Adapter<SongAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_song, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return song.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val songList = song[position]
        val sizeSong = song[position]
        holder.setData(songList, position)
        holder.setData(sizeSong, position)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var currentSong: dataSong? = null
        var currentPosition : Int = 0
        var currentSize : dataSong? = null

        init {
            itemView.setOnClickListener{
                Toast.makeText(context, "Song of ${currentSong!!.nameAuthor}", Toast.LENGTH_SHORT).show()
            }
        }

        fun setData(song_list: dataSong? , pos :Int){
            itemView.tvSong.text = song_list!!.nameSong
            itemView.text_sizeInKB.text = song_list.sizeSong.toString() + "KB"

            this.currentSong =  song_list
            this.currentSize = song_list
            this.currentPosition = pos
        }

    }
}