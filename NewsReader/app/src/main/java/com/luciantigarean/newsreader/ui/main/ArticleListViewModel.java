package com.luciantigarean.newsreader.ui.main;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class ArticleListViewModel extends ViewModel implements LifecycleObserver, ToDoHandler {

    private static final String TAG = ArticleListViewModel.class.getName();

    @NonNull
    public ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList();





    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh(){

        Log.e(TAG, "ONREFRESH");
        ArticleItemViewModel item1=new ArticleItemViewModel(null);
        ArticleItemViewModel item2=new ArticleItemViewModel(null);
        ArticleItemViewModel item3=new ArticleItemViewModel(null);
        ArticleItemViewModel item4=new ArticleItemViewModel(null);

        newsList.add(item1);
        newsList.add(item2);
        newsList.add(item3);
        newsList.add(item4);
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {

    }

    @Override
    public void onDeleteItemSelected(ArticleItemViewModel item) {

    }
}
