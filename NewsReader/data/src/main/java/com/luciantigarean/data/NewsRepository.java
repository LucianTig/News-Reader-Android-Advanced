package com.luciantigarean.data;

import com.luciantigarean.data.features.news.model.Article;
import com.luciantigarean.data.features.news.remote.NewsRemoteSource;
import com.luciantigarean.data.features.news.remote.mapper.NewsDtoToNewsMapper;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public interface NewsRepository {


    @NonNull
    Single<List<Article>> getNewsArticles();


}
