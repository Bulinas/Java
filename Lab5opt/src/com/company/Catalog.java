package com.company;

import java.util.ArrayList;

public class Catalog {
    private String name;
    private ArrayList<Document> documents = new ArrayList<Document>();

    public Catalog() {

    }

    public Catalog(String name) {
        this.name = name;
    }

    public Catalog(String name, ArrayList<Document> documents) {
        this.name = name;
        this.documents = documents;
    }

    //    Setters && Getters

    public void setName(String name) {
        this.name = name;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    //toString


    @Override
    public String toString() {
        String aux = "name = " + name + ", documents-in-catalog = " + documents.size() + ", documents =\n";
        for (Document document : documents) {
            aux = aux + document.toString();
        }
        return aux;

    }

    public String reportForm(){
        String aux = "name = " + name + ", documents-in-catalog = " + documents.size() + ", documents = <br>";
        for (Document document : documents) {
            aux = aux + document.toString() + "<br>";
        }
        return aux;
    }
}
