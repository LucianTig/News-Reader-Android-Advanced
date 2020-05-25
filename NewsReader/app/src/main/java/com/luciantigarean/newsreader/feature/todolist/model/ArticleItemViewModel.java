package com.luciantigarean.newsreader.feature.todolist.model;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.luciantigarean.data.NewsRepository;
import com.luciantigarean.data.features.news.model.Article;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ArticleItemViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    @Nullable
    public final ObservableField<String> title;
    public final ObservableField<String> content;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> description;

    public ArticleItemViewModel() {
        this.title=new ObservableField<>("");
        this.content=new ObservableField<>("");
        this.imageUrl=new ObservableField<>("");
        this.description=new ObservableField<>("");
    }

    public ArticleItemViewModel(String title, String content) {
        this.title=new ObservableField<>(title);
        this.content=new ObservableField<>(content);
        this.imageUrl=new ObservableField<>("");
        this.description=new ObservableField<>("");
    }


}