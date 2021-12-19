package com.example.newsforyou.Repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.newsforyou.Class.News;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class NewsRepositoryImpl implements NewsRepository{
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("News");
    public static final String TAG = NewsRepositoryImpl.class.getSimpleName();
    private ArrayList<News> allNews = null;

    @Override
    public List<News> findAll() {
        databaseReference.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        allNews = new ArrayList<>();
                        for(DataSnapshot item : snapshot.getChildren()){
                          String author = item.child("author").getValue(String.class);
                          String content = item.child("content").getValue(String.class);
                          int commentCount = item.child("commentCount").getValue(Integer.class);
                          int id = item.child("id").getValue(Integer.class);
                          int likecount = item.child("likeCount").getValue(Integer.class);
                          int reportCount =item.child("reportCount").getValue(Integer.class);
                          int viewCount = item.child("viewCount").getValue(Integer.class);
                          String date  =item.child("date").getValue(String.class);
                          String title = item.child("title").getValue(String.class);
                          News news = new News(id,title,content,author,date);
                          allNews.add(news);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                }
        );
        return allNews;
    }

    @Override
    public News findById() {
        return null;
    }

    @Override
    public void save() {

    }
}
