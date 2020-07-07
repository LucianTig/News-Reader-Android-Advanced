package com.luciantigarean.data.store.local;

import com.luciantigarean.data.features.news.Local.ArticleDao;
import com.luciantigarean.data.features.news.Local.ArticleEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Database usually has
 * - entities
 * - converters
 * - dao
 * - migrations
 */
@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class ToDoDatabase extends RoomDatabase {

    public abstract ArticleDao toDoDao();

}