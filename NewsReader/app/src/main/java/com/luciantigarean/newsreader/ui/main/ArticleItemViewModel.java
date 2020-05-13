package com.luciantigarean.newsreader.ui.main;

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

    private NewsRepository repository;

    @Nullable
    public final ObservableField<String> title;
    public final ObservableField<String> content;
    public final ObservableField<String> imageUrl;

    public ArticleItemViewModel(NewsRepository repository) {
        this.repository = repository;
        this.title=new ObservableField<>("");
        this.content=new ObservableField<>("");
        this.imageUrl=new ObservableField<>("");
    }

    @SuppressLint("CheckResult")
    public void initToDoItem(int itemId) {
        Log.d(TAG, "initToDoItem()");

        if (title.get().isEmpty()) {
            //this.todoItemId = itemId;

            /*repository.getToDoItem(todoItemId)
                    .map(new EntityToDetailsVMMapper(this))
                    .subscribe(
                            toDoEntity -> Log.d(TAG, "initToDoItem: onSuccess : " + toDoEntity.taskName),
                            throwable -> Log.e(TAG, "fetchToDoList error: ", throwable)
                    );*/

            /*repository.getNewsArticles()
                    .map(new ArticlesToVMListMapper())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            this::onNewsArticlesReceived,
                            this::onNewsArticlesError
                    );*/
        }
    }
}