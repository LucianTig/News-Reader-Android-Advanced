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


    public ArticleListViewModel(){
        ArticleItemViewModel item1=new ArticleItemViewModel();
        ArticleItemViewModel item2=new ArticleItemViewModel();
        ArticleItemViewModel item3=new ArticleItemViewModel();
        ArticleItemViewModel item4=new ArticleItemViewModel();

        newsList.add(item1);
        newsList.add(item2);
        newsList.add(item3);
        newsList.add(item4);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh(){
        Log.e(TAG, "ONREFRESH");
        ArticleItemViewModel item1=new ArticleItemViewModel();
        ArticleItemViewModel item2=new ArticleItemViewModel();
        ArticleItemViewModel item3=new ArticleItemViewModel();
        ArticleItemViewModel item4=new ArticleItemViewModel();

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
