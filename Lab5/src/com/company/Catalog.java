package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Catalog implements Serializable {
    private String name;
    private ArrayList<Document> documents;

    public Catalog(){

    }

    public Catalog(String name, ArrayList<Document> documents){
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

    public String getName() {
        return name;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }
}
