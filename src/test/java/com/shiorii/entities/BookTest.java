package com.shiorii.entities;

import com.shiorii.constants.BookGenre;
import com.shiorii.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void isKidFriendlyEligible() {
//        Test 1
        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);

        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible,"For Philosophy genre - isKidFriendlyEligible should return false");

//        Test 2
        book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);

        isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible,"For Philosophy genre - isKidFriendlyEligible should return false");
    }
}