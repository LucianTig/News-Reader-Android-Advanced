package com.luciantigarean.newsreader.ui.main;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"items", "todoHandler"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> tasks, ToDoHandler handler) {
        ArticleListAdapter taskAdapter = (ArticleListAdapter) recyclerView.getAdapter();

        if (taskAdapter == null) {
            taskAdapter = new ArticleListAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(taskAdapter);
        }

        taskAdapter.setItems(tasks, handler);
    }

}
