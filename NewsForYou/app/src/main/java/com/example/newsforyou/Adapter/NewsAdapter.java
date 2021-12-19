package com.example.newsforyou.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsforyou.Class.News;
import com.example.newsforyou.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context mContext;
    private List<News> mNewsList;
    private SharedPreferences sharedPrefs;

    public NewsAdapter(Context context, List<News> newsList) {
        mContext = context;
        mNewsList = newsList;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);

        final News currentNews = mNewsList.get(position);

        holder.tvTitle.setText(currentNews.getTitle());
        holder.tvDate.setText(currentNews.getDate().toString());
        holder.tvView.setText(currentNews.getViewCount());
        holder.tvLike.setText(currentNews.getLikeCount());
        holder.tvComment.setText(currentNews.getCommentCount());

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvatar;
        private TextView tvTitle;
        private TextView tvDate;
        private TextView tvView;
        private TextView tvLike;
        private TextView tvComment;
        private ImageView ivView;
        private ImageView ivLike;
        private ImageView ivComment;

        ViewHolder(View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById(R.id.iv_avatar_news_item);
            tvTitle = itemView.findViewById(R.id.tv_title_news_item);
            tvDate = itemView.findViewById(R.id.tv_date_news_item);
            tvView = itemView.findViewById(R.id.tv_view_news_item);
            tvLike = itemView.findViewById(R.id.tv_like_news_item);
            tvComment = itemView.findViewById(R.id.tv_comment_news_item);
            ivView = itemView.findViewById(R.id.iv_view_news_item);
            ivLike = itemView.findViewById(R.id.iv_like_news_item);
            ivComment = itemView.findViewById(R.id.iv_comment_news_item);
        }
    }
}
