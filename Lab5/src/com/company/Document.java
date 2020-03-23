package com.company;

import javafx.util.Pair;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Document implements Serializable {
    private int id;
    private String name;
    private HashMap<String, String> map = new HashMap<String, String>();
    private String path;

    public Document(int id, String name, String path){
        this.id = id;
        this.name = name;
        this.path = path;
    }

//    Setters && Getters
    public HashMap<String, String> getMap() {
        return map;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void addTags(ArrayList<Pair<String, String>> tags){
        for (int i = 0; i < tags.size(); i++) {
            map.put(tags.get(i).getKey(), tags.get(i).getValue());
        }
    }
}
