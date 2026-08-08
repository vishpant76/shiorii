package com.shiorii;

import com.shiorii.entities.Bookmark;
import com.shiorii.entities.User;
import com.shiorii.managers.BookmarkManager;
import com.shiorii.managers.UserManager;

public class Launch {

    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData() {
        System.out.println("1. Loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println("Printing data...");
        printUserData();
        printBookmarkData();
    }

    private static void printBookmarkData() {
        for(var bookmarkType: bookmarks){
            for(var bookmark: bookmarkType){
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for(var user: users){
            System.out.println(user);
        }
    }

    private static void startBookmarking() {
        System.out.println("\n2. Bookmarking...");
        for(var user: users){
            View.bookmark(user, bookmarks);
        }
    }

    public static void main(String[] args) {
        loadData();
        startBookmarking();
    }

}
