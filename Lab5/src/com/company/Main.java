package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static String bookPath = "src/Book";
    public static String articlePath = "src/Article";

    public static void main(String[] args) {
        Document d1 = new Document(1, "Book", bookPath);
        Document d2 = new Document(2, "article", articlePath);
        ArrayList<Pair<String, String>> bookTags = initializeTags();
        ArrayList<Document> documents = new ArrayList<Document>(Arrays.asList(d1, d2));
        Catalog catalog = new Catalog("Catalogul meu", documents);
        Action action = new Action();
        action.save(catalog);
        Catalog auxCatalog = action.load("");
        System.out.println(auxCatalog.getName());
        action.view(d1);
    }

    /**
     * Function that initilize book tags
     * @return
     */
    public static ArrayList<Pair<String, String>> initializeTags() {
        ArrayList<Pair<String, String>> tags = new ArrayList<Pair<String, String>>();
        tags.add(new Pair<String, String>("Title", "BoooooK"));
        tags.add(new Pair<String, String>("Author", "Me"));
        tags.add(new Pair<String, String>("Year", "1993"));
        tags.add(new Pair<String, String>("PublishingDate", "12-05-1993"));
        return tags;
    }
}
