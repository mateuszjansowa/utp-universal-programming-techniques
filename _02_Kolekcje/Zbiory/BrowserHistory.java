package _02_Kolekcje.Zbiory;

import java.util.*;

public class BrowserHistory {
    private final Set<String> visitedPages = new LinkedHashSet<>();

    public void visit(String page) {
        visitedPages.add(page);
    }

    public void showHistory() {
        System.out.println("Historia przeglądania:");
        visitedPages.forEach(System.out::println);
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        history.visit("google.com");
        history.visit("wikipedia.org");
        history.visit("google.com"); // Już odwiedzona
        history.showHistory();
    }
}