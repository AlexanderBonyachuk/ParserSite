package com.bonalex.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private static String url;
    private static Map<String, Integer> mapWord;

    public static void main(String[] args) throws IOException {

        url = readUrl();

        Document page = getPage();

//        showText(page);

        tableWithText(page.text());

        showMap(mapWord);
    }

    public static String readUrl() {
        String url = "null";
        System.out.println("Enter URL: ");
        Scanner scanner = new Scanner(System.in);
        url = scanner.next();
        scanner.close();
        return url;
    }

    public static Document getPage() throws IOException {
        Document page = Jsoup.parse(new URL(url), 4000);
        return page;
    }

    public static void showText(Document page) {
        System.out.println(page.text());
    }

    public static Map<String, Integer> tableWithText(String text) {
        Scanner scanner = new Scanner(text);
        mapWord = new HashMap<>();
        String word;
        int quantityWord;
        while (scanner.hasNext()) {
            quantityWord = 1;
            word = scanner.next().toUpperCase();
            if (mapWord.containsKey(word)) {
                quantityWord += mapWord.get(word);
            }
            mapWord.put(word, quantityWord);
        }
        return mapWord;
    }

    public static void showMap(Map<String, Integer> map) {
        map.forEach((word, num) -> System.out.println(word + " - " + num));
    }
}
