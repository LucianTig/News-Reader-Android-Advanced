package com.luciantigarean.newsreader.feature.todolist.listener;

import com.luciantigarean.newsreader.feature.todolist.model.ArticleItemViewModel;

public interface ArticleHandler {

    void onItemSelected(ArticleItemViewModel item);

    void onDeleteItemSelected(ArticleItemViewModel item);
}
