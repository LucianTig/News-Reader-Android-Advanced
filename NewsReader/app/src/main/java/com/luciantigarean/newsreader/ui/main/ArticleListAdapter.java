package com.luciantigarean.newsreader.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luciantigarean.newsreader.databinding.ArticleItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.TaskViewHolder> {

    private List<ArticleItemViewModel> taskModelList;
    private ToDoHandler handler;

    public ArticleListAdapter() {
        this.taskModelList = new ArrayList<>();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ArticleItemBinding binder = ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new TaskViewHolder(binder);
    }


    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.binding.setViewModel(taskModelList.get(position));
        //point all clicks to a single interface for all items
        //holder.binding.setHandler((ArticleHandler) handler);
    }

    @Override
    public int getItemCount() {
        return taskModelList.size();
    }

    public void setItems(List<ArticleItemViewModel> items, ToDoHandler handler) {
        this.handler = handler;
        this.taskModelList = items;
        notifyDataSetChanged();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
        final ArticleItemBinding binding;

        public TaskViewHolder(ArticleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
