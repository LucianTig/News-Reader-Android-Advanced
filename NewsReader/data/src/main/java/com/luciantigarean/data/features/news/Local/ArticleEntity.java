package com.luciantigarean.data.features.news.Local;

import android.media.Image;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "news")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;
    public String imageUrl;
    public String title;
    public String content;
    public String description;
}
