package com.shiorii.controllers;

import com.shiorii.entities.Bookmark;
import com.shiorii.entities.User;
import com.shiorii.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();

    private BookmarkController() {
    }

    public static BookmarkController getInstance() {
        return instance;
    }

    //    This could be made static?
    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }
}
