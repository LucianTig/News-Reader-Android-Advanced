package com.luciantigarean.newsreader.feature.todolist.model;

import androidx.annotation.IntDef;

public class ArticleEventModel {
    @EventType
    public final int eventType;

    public final ArticleItemViewModel item;

    ArticleEventModel(@EventType int eventType, ArticleItemViewModel item) {
        this.eventType = eventType;
        this.item = item;
    }

    ArticleEventModel(@EventType int eventType) {
        this.eventType = eventType;
        this.item = null;
    }

    @IntDef({
            EventType.EDIT_ITEM,
            EventType.ADD_ITEM
    })
    public @interface EventType {
        int EDIT_ITEM = 1;
        int ADD_ITEM = 2;
    }

}
