package com.shiorii.dao;

import com.shiorii.DataStore;
import com.shiorii.entities.Bookmark;
import com.shiorii.entities.UserBookmark;

public class BookmarkDao {

    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
