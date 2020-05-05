package com.luciantigarean.newsreader.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luciantigarean.newsreader.R;
import com.luciantigarean.newsreader.databinding.ArticleListFragmentBinding;

public class MainFragment extends Fragment {

    private ArticleListViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    /*@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.article_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ArticleItemViewModel.class);
        // TODO: Use the ViewModel
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ArticleListViewModel.class);
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