package com.example.newsforyou.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsforyou.Adapter.NewsAdapter;
import com.example.newsforyou.Class.News;
import com.example.newsforyou.DashboardActivity;
import com.example.newsforyou.ProfileActivity;
import com.example.newsforyou.R;
import com.example.newsforyou.Repository.NewsRepository;
import com.example.newsforyou.Repository.NewsRepositoryImpl;
import com.example.newsforyou.Utils.EmptyRecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {

    private View mView;
    private ImageView ivProfile;
    private ArrayList<News> newsList;
    private RecyclerView rv_news;
    private NewsAdapter mAdapter;
    private RecyclerView recyclerView;
    private NewsRepository newsRepository = new NewsRepositoryImpl();
    private static final String LOG_TAG = HomeFragment.class.getName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        newsList = (ArrayList<News>) newsRepository.findAll();
        rv_news = mView.findViewById(R.id.rv_news);

        mAdapter = new NewsAdapter(mView.getContext(),newsList);
        rv_news.setAdapter(mAdapter);

        ivProfile = (ImageView) mView.findViewById(R.id.iv_avatar);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return mView;
    }
}
