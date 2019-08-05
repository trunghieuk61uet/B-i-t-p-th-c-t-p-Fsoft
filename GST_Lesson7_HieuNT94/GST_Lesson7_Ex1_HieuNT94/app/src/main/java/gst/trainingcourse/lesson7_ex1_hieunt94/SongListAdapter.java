package gst.trainingcourse.lesson7_ex1_hieunt94;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder> {

    private Context mContext;
    private List<Song> mSongList;

    public SongListAdapter(Context context, List<Song> list) {
        this.mContext = context;
        this.mSongList = list;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View objView = LayoutInflater.from(mContext).inflate(R.layout.song_view, parent, false);
        return new SongViewHolder(objView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {
        if(mContext instanceof SongListFragment.OnFragmentInteractionListenter
                && mContext instanceof Activity) {
            holder.mSongView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((SongListFragment.OnFragmentInteractionListenter) mContext).onSongSelected(mSongList.get(position));
                }
            });
        }
        holder.getSongNameText().setText(mSongList.get(position).getName());
        holder.getDurationText().setText(mSongList.get(position).getDuration());
        holder.getSizeInKBText().setText(mSongList.get(position).getSizeInKB() + " KB");
    }

    @Override
    public int getItemCount() {
        return mSongList.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mSongView;
        private TextView mSongNameText;
        private TextView mDurationText;
        private TextView mSizeInKBText;

        public SongViewHolder(View itemView) {
            super(itemView);
            mSongView = itemView.findViewById(R.id.linear_songView);
            mSongNameText = itemView.findViewById(R.id.text_songName);
            mDurationText = itemView.findViewById(R.id.text_duration);
            mSizeInKBText = itemView.findViewById(R.id.text_sizeInKB);
        }

        public TextView getSongNameText() {
            return mSongNameText;
        }

        public TextView getDurationText() {
            return mDurationText;
        }

        public TextView getSizeInKBText() {
            return mSizeInKBText;
        }
    }
}
