package com.luciantigarean.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.luciantigarean.data.NewsRepository;
import com.luciantigarean.data.features.news.Local.ArticleLocalDataStore;
import com.luciantigarean.data.features.news.NewsRepositoryImpl;
import com.luciantigarean.data.features.news.remote.NewsRemoteSource;
import com.luciantigarean.data.remote.HttpClientFactory;
import com.luciantigarean.data.store.local.ToDoDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {

    private volatile ToDoDatabase database;

    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    /*public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }*/

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    ArticleLocalDataStore provideLocalDataStore() {
        ToDoDatabase database = getInstance();
        return new ArticleLocalDataStore(database.toDoDao());
    }

    ToDoDatabase getInstance() {
        if (database == null) {
            synchronized (ToDoDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            ToDoDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
