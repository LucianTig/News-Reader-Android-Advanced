package com.luciantigarean.data.features.news;


import com.luciantigarean.data.NewsRepository;
import com.luciantigarean.data.features.news.Local.ArticleEntity;
import com.luciantigarean.data.features.news.Local.ArticleLocalDataStore;
import com.luciantigarean.data.features.news.model.Article;
import com.luciantigarean.data.features.news.remote.NewsRemoteSource;
import com.luciantigarean.data.features.news.remote.mapper.ArticleEntityToArticlesMapper;
import com.luciantigarean.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.luciantigarean.data.features.news.remote.model.ArticleDto;
import com.luciantigarean.data.features.news.remote.model.ArticleListDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;
    private final ArticleLocalDataStore localDataStore;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, ArticleLocalDataStore localDataStore) {
        this.remoteSource = remoteSource;
        this.localDataStore = localDataStore;
    }

    /*@Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(new NewsDtoToNewsMapper());
    }*/

    @NonNull
    @Override
    public Single<List<Article>> getNewsArticles() {
        // return remoteSource.getNewsArticles().map(new NewsDtoToNewsMapper());
        return remoteSource.getNewsArticles()
                .map(new Function<ArticleListDto, List<ArticleEntity>>() {
                    @Override
                    public List<ArticleEntity> apply(ArticleListDto articleListDto) {
                        List<ArticleEntity> articleEntityList = new ArrayList<>();
                        List<ArticleDto> list1 = articleListDto.articles;
                        for (ArticleDto article : list1) {
                            ArticleEntity articleEntity = new ArticleEntity();
                            articleEntity.setTitle(article.title);
                            articleEntity.setUrlToImage(article.urlToImage);
                            articleEntity.setContent(article.content);
                            articleEntity.setDescription(article.description);
                            articleEntityList.add(articleEntity);
                        }
                        return articleEntityList;
                    }
                })
                .flatMap(localDataStore::saveItems)
                .onErrorResumeNext(localDataStore.getArticleList())
                .map(new ArticleEntityToArticlesMapper());
    }

}
