package com.bonalex.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Processing {
    private static Processing HANDLER;
    private static String url;
    private static Map<String, Integer> mapWord;
    private static int timeout = 4000;

    private Processing() {}

    public static synchronized Processing getModel() {
        if (HANDLER == null) {
            HANDLER = new Processing();
        }
        return HANDLER;
    }

    public String readUrl() {
        System.out.println("Enter URL: ");
        Scanner scanner = new Scanner(System.in);
        url = scanner.next();
        scanner.close();
        return url;
    }

    public Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), timeout);
        return page;
    }

    public Map<String, Integer> tableWithText(String text) {
        Scanner scanner = new Scanner(text);
// separators {' ', ',', '.', '! ', '?','"', ';', ':', '[', ']', '(', ')', '\n',
// '\r', '\t', '«', '»', '/', ''', 'digit', '-', '%', '—'}
        scanner.useDelimiter("[\\s,.!?\";:\\[\\]()\\n\\r\\t«»/'\\d-%—]+");
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

    public void showMap(Map<String, Integer> map) {
        map.forEach((word, num) -> System.out.println(word + " - " + num));
    }
}
