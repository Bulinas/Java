package com.company;

import java.awt.*;
import java.io.*;

public class Action {
    private String fileName = "file.ser";

    /**
     * Serialization in file.ser of catalog
     * @param catalog
     */
    public void save(Catalog catalog) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(catalog);
            out.flush();
            file.close();
        } catch (IOException ex) {
            System.out.println("Eroare la salvarea fisierului!");
            ex.printStackTrace();
        }
    }

    /**
     * Desirlization from the same file.ser
     * @param path
     * @return
     */
    public Catalog load(String path) {
        Catalog catalog = null;
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            catalog = (Catalog) in.readObject();
            file.close();
        } catch (IOException ex) {
            System.out.println("Eroare la citirea fisierului!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Nu am gasit catalog!");
        }
        return catalog;
    }

    /**
     * Opens document
     * @param document
     */
    public void view(Document document) {
        try{
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(document.getPath()));
        } catch (IOException ex){
            System.out.println("Eroare la desktop!");
        }
    }
}
