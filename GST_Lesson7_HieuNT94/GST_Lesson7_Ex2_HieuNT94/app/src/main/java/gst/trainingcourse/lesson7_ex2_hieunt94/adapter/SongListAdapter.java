package gst.trainingcourse.lesson7_ex2_hieunt94.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.R;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Song;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder> {
    private Context mContext;
    private List<Song> mSongList;

    public SongListAdapter(Context context, List<Song> songList) {
        this.mContext = context;
        this.mSongList = songList;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View objView = LayoutInflater.from(mContext).inflate(R.layout.view_song, parent, false);
        return new SongViewHolder(objView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {
        holder.mSongNameTxt.setText(mSongList.get(position).getName());
        holder.mSongDurationTxt.setText(mSongList.get(position).getDuration());
        holder.mSongSizeInKBTxt.setText(mSongList.get(position).getSizeKB());
    }

    @Override
    public int getItemCount() {
        return mSongList.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mSongContainerLinear;
        private TextView mSongNameTxt;
        private TextView mSongDurationTxt;
        private TextView mSongSizeInKBTxt;

        public SongViewHolder(View itemView) {
            super(itemView);
            mSongContainerLinear = itemView.findViewById(R.id.linear_container_songItem);
            mSongNameTxt = itemView.findViewById(R.id.text_songName);
            mSongDurationTxt = itemView.findViewById(R.id.text_songDuration);
            mSongSizeInKBTxt = itemView.findViewById(R.id.text_songSizeInKB);
        }
    }

}
