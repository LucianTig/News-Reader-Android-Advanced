package com.luciantigarean.newsreader.feature.todolist.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.luciantigarean.data.NewsRepository;
import com.luciantigarean.newsreader.ToDoApplication;

public class ViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticleListViewModel.class)) {
            NewsRepository repo = ToDoApplication.getRepoProvider().provideNewsRepository();
            return (T) new ArticleListViewModel(repo);
        }

        /*if (modelClass.isAssignableFrom(ToDoDetailsViewModel.class)) {
            NewsRepository repo = ToDoApplication.getRepoProvider().provideNewsRepository();
            return (T) new ToDoDetailsViewModel(repo);
        }*/

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
