package com.shiorii.dao;

import com.shiorii.DataStore;
import com.shiorii.entities.Bookmark;

public class BookmarkDao {

    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }
}
