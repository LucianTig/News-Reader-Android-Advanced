package com.luciantigarean.data.features.news.Local;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM news")
    Single<List<ArticleEntity>> queryArticles();

    @Query("SELECT * FROM news where id= :id")
    Single<ArticleEntity> queryArticleItem(int id);

    @Query("DELETE FROM news where id=:id")
    Completable deleteArticleItem(int id);

    @Query("DELETE FROM news")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllArticles(List<ArticleEntity> news);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity news);

    /*@Query("UPDATE todos SET taskName = :taskName, priority = :priority where id=:id")
    Completable updateProfile(String taskName, int priority, int id);*/

}