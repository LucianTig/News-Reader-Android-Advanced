package com.luciantigarean.data.features.news.remote;

import com.luciantigarean.data.features.news.remote.model.ArticleListDto;
import com.luciantigarean.data.remote.NewsApi;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {
    //Don't copy this api key, use your own by registering here https://newsapi.org/register
    private static final String API_KEY = "a68682d93f0447aa8bea89fe0c3ba4b3";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<ArticleListDto> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io());
    }
}
