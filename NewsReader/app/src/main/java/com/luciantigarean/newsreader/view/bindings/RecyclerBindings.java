package com.luciantigarean.newsreader.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luciantigarean.newsreader.feature.todolist.listener.ArticleHandler;
import com.luciantigarean.newsreader.feature.todolist.model.ArticleItemViewModel;
import com.luciantigarean.newsreader.feature.todolist.adapter.ArticleListAdapter;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"items", "todoHandler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> tasks, ArticleHandler handler) {
        ArticleListAdapter taskAdapter = (ArticleListAdapter) recyclerView.getAdapter();

        if (taskAdapter == null) {
            taskAdapter = new ArticleListAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(taskAdapter);
        }

        taskAdapter.setItems(tasks, handler);
    }

}
