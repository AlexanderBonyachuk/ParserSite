package com.bonalex.api;

import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.bonalex.api.Processing.getModel;

public class Parser {

    public static void main(String[] args) throws IOException {
        Processing page = getModel();
        Document site = page.getPage(page.readUrl());
        page.showMap(page.tableWithText(site.text()));
    }
}
