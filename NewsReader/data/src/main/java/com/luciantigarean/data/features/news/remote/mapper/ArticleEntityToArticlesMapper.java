package com.luciantigarean.data.features.news.remote.mapper;

import android.util.Log;

import com.luciantigarean.data.features.news.Local.ArticleEntity;
import com.luciantigarean.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

import static android.content.ContentValues.TAG;


public class ArticleEntityToArticlesMapper implements Function<List<ArticleEntity>, List<Article>> {

    @Override
    public List<Article> apply(List<ArticleEntity> articleEntities) throws Exception {

        List<Article> articles=new ArrayList<>();
        for(ArticleEntity articleEntity: articleEntities){
            Article articleItem = new Article(articleEntity.imageUrl,articleEntity.title,articleEntity.content,articleEntity.description);
            articles.add(articleItem);

        }

        return articles;
    }
}
