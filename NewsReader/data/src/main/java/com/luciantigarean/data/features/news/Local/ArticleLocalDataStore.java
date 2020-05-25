package com.luciantigarean.data.features.news.Local;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class ArticleLocalDataStore {

    private ArticleDao dao;

    public ArticleLocalDataStore(ArticleDao dao) {
        this.dao = dao;
    }

    public Single<List<ArticleEntity>> getArticleList() {
        return dao.queryArticles();
    }

    public Single<ArticleEntity> getArticleItem(int id) {
        return dao.queryArticleItem(id);
    }

    public Completable deleteToDoItem(int id) {
        return dao.deleteArticleItem(id);
    }

    public Completable saveItem(ArticleEntity articleEntity) {
        if(articleEntity.id==null){
            return dao.insertArticle(articleEntity);
        }else{
            return null;
        }
    }

    public Single<List<ArticleEntity>> saveItems(List<ArticleEntity> list) {
        return Single.create(new SingleOnSubscribe<List<ArticleEntity>>() {
            @Override
            public void subscribe(SingleEmitter<List<ArticleEntity>> emitter) throws Exception {
                dao.insertAllArticles(list);
                emitter.onSuccess(list);
            }
        });
    }

}
