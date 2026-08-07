package com.shiorii;

import com.shiorii.constants.BookGenre;
import com.shiorii.constants.Gender;
import com.shiorii.constants.UserType;
import com.shiorii.entities.Bookmark;
import com.shiorii.entities.User;
import com.shiorii.entities.UserBookmark;
import com.shiorii.managers.BookmarkManager;
import com.shiorii.managers.UserManager;

public class DataStore {
    private static final int USER_BOOKMARK_LIMIT = 5;
    private static final int BOOKMARK_COUNT_PER_TYPE = 5;
    private static final int BOOKMARK_TYPES_COUNT = 3;
    private static final int TOTAL_USER_COUNT = 5;

    private static User[] users = new User[TOTAL_USER_COUNT];
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];

    public static void loadData(){
        loadUsers();
        loadWebLinks();
        loadMovies();
        loadBooks();
    }



    private static void loadUsers(){
        users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE, UserType.USER);
        users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "SAM", "J", Gender.MALE, UserType.USER);
        users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Anita", "L", Gender.FEMALE, UserType.EDITOR);
        users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Sara", "W", Gender.FEMALE, UserType.EDITOR);
        users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Max", "C", Gender.MALE, UserType.CHIEF_EDITOR);

    }

    private static void loadWebLinks(){
        bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Security and the class verifier", "https://www.infoworld.com/article/2168637/security-and-the-class-verifier.html", "https://www.infoworld.com");
        bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001, "Nested Classes", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html", "https://docs.oracle.com");
        bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002, "Interface vs Abstract Class", "https://mindprod.com/jgloss/interfacevsabstract.html", "https://mindprod.com");
        bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003, "NIO tutorial by Greg Travis", "https://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "https://cs.brown.edu");
        bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004, "Virtual Hosting and Tomcat", "https://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "https://tomcat.apache.org");
    }

    private static void loadMovies() {
        bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[] {"Orson Welles", "Joseph Cotten"}, new String[] {"Orson Welles"}, "Classics", 8.5);
        bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", "", 1940, new String[] {"Henry Fonda", "Jane Darwell"}, new String[] {"John Ford"}, "Classics", 8.2);
        bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness", "", 2004, new String[] {"Albert Cullum"}, new String[] {"Leslie Sullivan"}, "Documentaries", 7.3);
        bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory", "", 2007, new String[] {"Kaley Cuoco", "Jim Parsons", "Chuck Lorre"}, new String[] {"Bill Prady"}, "TV Shows", 8.7);
        bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru", "", 1952, new String[] {"Takashi Shimura", "Minoru Chiaki"}, new String[] {"Akira Kurosawa"}, "Foreign Movies", 8.4);
    }

    private static void loadBooks() {
        bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", 1993, "Dover Publications", new String[] {"Ralph Waldo Emerson"}, BookGenre.PHILOSOPHY, 4.5);
        bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", 1988, "Touchstone", new String[] {"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
        bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", 2004, "O'Reilly Media", new String[] {"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson"}, BookGenre.TECHNICAL, 4.5);
        bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide", 2007, "Prentice Hall", new String[] {"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);
    }

    public static User[] getUsers() {
        return users;
    }

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }
}
