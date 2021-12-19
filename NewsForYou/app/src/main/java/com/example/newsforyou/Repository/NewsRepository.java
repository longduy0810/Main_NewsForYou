package com.example.newsforyou.Repository;

import com.example.newsforyou.Class.News;

import java.util.List;

public interface NewsRepository {
    public List<News> findAll();
    public News findById();
    public void save();
}
