package com.luciantigarean.newsreader.feature.todolist.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luciantigarean.newsreader.databinding.ArticleListFragmentBinding;
import com.luciantigarean.newsreader.feature.todolist.model.ArticleListViewModel;
import com.luciantigarean.newsreader.feature.todolist.model.ViewModelFactory;

public class MainFragment extends Fragment {

    private ArticleListViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelFactory factory = new ViewModelFactory();
        mViewModel = ViewModelProviders.of(this, factory).get(ArticleListViewModel.class);
        getLifecycle().addObserver(mViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArticleListFragmentBinding binding = ArticleListFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }

}