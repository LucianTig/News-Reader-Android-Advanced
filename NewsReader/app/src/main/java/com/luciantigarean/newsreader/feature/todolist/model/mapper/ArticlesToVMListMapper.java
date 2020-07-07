package com.luciantigarean.newsreader.feature.todolist.model.mapper;

import android.util.Log;

import com.luciantigarean.data.features.news.model.Article;
import com.luciantigarean.newsreader.feature.todolist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

import static android.content.ContentValues.TAG;

public class ArticlesToVMListMapper implements Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) throws Exception {

        Log.e(TAG, "ArticlesToVMListMapper ");
        List<ArticleItemViewModel> articleItemViewModels = new ArrayList<>();
        for (Article article : articles) {
            Log.e(TAG, "ArticlesToVMListMapper " + article.title);
            ArticleItemViewModel viewModelItem = new ArticleItemViewModel();
            viewModelItem.content.set(article.content);
            viewModelItem.imageUrl.set(article.imageUrl);
            viewModelItem.title.set(article.title);
            viewModelItem.description.set(article.description);

            articleItemViewModels.add(viewModelItem);

        }

        return articleItemViewModels;
    }
}
