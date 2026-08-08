package com.shiorii.entities;

import com.shiorii.managers.BookmarkManager;

import static org.junit.jupiter.api.Assertions.*;

class WebLinkTest {

    @org.junit.jupiter.api.Test
    void isKidFriendlyEligible() {
        //        Test 1 - porn in url
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Security and the class verifier", "https://www.infoworld.com/article/2168637/security-and-the-class-porn-verifier.html", "https://www.infoworld.com");
        boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For porn in url - isKidFriendlyEligible() must return false");

//        Test 2 - porn in title
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Security porn and the class verifier", "https://www.infoworld.com/article/2168637/security-and-the-class-verifier.html", "https://www.infoworld.com");
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For porn in title - isKidFriendlyEligible() must return false");

//        Test 3 - adult in host
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Security and the class verifier", "https://www.infoworld.com/article/2168637/security-and-the-class-verifier.html", "https://www.infoworldadult.com");
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For adult in host - isKidFriendlyEligible() must return false");

//        Test 4 - adult in url, but not in host part - true
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Security and the class verifier", "https://www.infoworld.com/article/2168637/security-and-the-class-adult-verifier.html", "https://www.infoworld.com");
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "For adult in url, but not host part - isKidFriendlyEligible() must return true");

//        Test 5 - adult in title only - true
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Security and the adult class verifier", "https://www.infoworld.com/article/2168637/security-and-the-class-verifier.html", "https://www.infoworld.com");
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "For adult in title only - isKidFriendlyEligible() must return true");
    }
}