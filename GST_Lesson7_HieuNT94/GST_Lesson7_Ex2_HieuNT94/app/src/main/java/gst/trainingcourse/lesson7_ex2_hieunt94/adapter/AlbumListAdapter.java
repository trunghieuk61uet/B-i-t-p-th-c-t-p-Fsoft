package gst.trainingcourse.lesson7_ex2_hieunt94.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.R;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Album;

public class AlbumListAdapter extends  RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder>{

    private Context mContext;
    private List<Album> mAlbumList;
    private OnAlbumClickListener listener;

    public AlbumListAdapter(Context context, List<Album> albumList, OnAlbumClickListener listener) {
        this.mContext = context;
        this.mAlbumList = albumList;
        this.listener = listener;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View objView = LayoutInflater.from(mContext).inflate(R.layout.view_album, parent, false);
        return new AlbumViewHolder(objView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, final int position) {
        holder.mAlbumNameBtn.setText(mAlbumList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mAlbumList.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        private Button mAlbumNameBtn;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            mAlbumNameBtn = itemView.findViewById(R.id.button_albumName);
            mAlbumNameBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        listener.onAlbumClick(mAlbumList.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    public interface OnAlbumClickListener {
        void onAlbumClick(Album album);
    }
}
