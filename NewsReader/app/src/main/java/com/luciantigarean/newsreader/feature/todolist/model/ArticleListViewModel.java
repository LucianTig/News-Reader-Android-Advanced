package com.luciantigarean.newsreader.feature.todolist.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.luciantigarean.data.NewsRepository;
import com.luciantigarean.newsreader.feature.todolist.listener.ArticleHandler;
import com.luciantigarean.newsreader.feature.todolist.model.mapper.ArticlesToVMListMapper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class ArticleListViewModel extends ViewModel implements LifecycleObserver, ArticleHandler {

    private static final String TAG = ArticleListViewModel.class.getName();
    private NewsRepository repository;
    private Disposable disposable;
    @NonNull
    public ObservableList<ArticleItemViewModel> newsList;
    public PublishSubject<ArticleEventModel> events;

    public ArticleListViewModel(NewsRepository repository) {
        this.repository = repository;
        this.newsList = new ObservableArrayList<>();
        this.events = PublishSubject.create();
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void fetchToDoList() {
        Log.d(TAG, "fetchToDoList()");

        disposable = repository.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        Log.e(TAG, "ArticleListViewModel-refresh");
        disposable = repository.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );

        Log.e(TAG, "ONREFRESH");
    }

    private void onNewsArticlesReceived(List<ArticleItemViewModel> toDoItems) {
        Log.d(TAG, "onToDoListReceived " + toDoItems.size() + " items");
        this.newsList.clear();
        this.newsList.addAll(toDoItems);
    }

    private void onNewsArticlesError(Throwable throwable) {
        Log.e(TAG, "onNewsArticlesError");
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }

    @Override
    public void onDeleteItemSelected(ArticleItemViewModel item) {

    }
}
