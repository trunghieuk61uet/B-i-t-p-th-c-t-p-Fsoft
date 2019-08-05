package gst.trainingcourse.lesson7_ex2_hieunt94.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.R;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Author;

public class AuthorListAdapter extends RecyclerView.Adapter<AuthorListAdapter.AuthorViewHolder> {

    private Context mContext;
    private List<Author> mAuthorList;
    private OnAuthorClickListener listener;

    public AuthorListAdapter(Context context, List<Author> authorList, OnAuthorClickListener listener) {
        this.mContext = context;
        this.mAuthorList = authorList;
        this.listener = listener;
    }

    @Override
    public AuthorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View objView = LayoutInflater.from(mContext).inflate(R.layout.view_author, parent, false);
        return new AuthorViewHolder(objView);
    }

    @Override
    public void onBindViewHolder(AuthorViewHolder holder, final int position) {
        holder.mAuthorNameText.setText(mAuthorList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mAuthorList.size();
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder {

        private Button mAuthorNameText;

        public AuthorViewHolder(View itemView) {
            super(itemView);
            mAuthorNameText = itemView.findViewById(R.id.text_authorName);
            mAuthorNameText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        listener.onAuthorClick(mAuthorList.get(getLayoutPosition()));
                    }
                }
            });
        }

    }

    public interface OnAuthorClickListener {
        void onAuthorClick(Author author);
    }
}
