package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * creates an html file that has the current catalog
 * and opens it (with the default program that the user
 * has for opening html files).
 */

public class ReportHtmlCommand implements Command {

    private String catalogPath = "./catalog.html";

    @Override
    public String runCommand(String[] arguments, Catalog catalog) {
        String aux;
        aux = "Failed to save catalog as a html report";
        try {
            File file = new File(catalogPath);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(catalogPath);
            fileWriter.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body\n> +" +
                    "<p>\n");
            fileWriter.write(catalog.reportForm());
            fileWriter.write("</p>\n" +
                    "</body>\n" +
                    "</html>");
            fileWriter.close();
            Desktop desktop = Desktop.getDesktop();
//            URI uri = new URI(catalogPath);
            desktop.open(file);
            aux = "Html report Succesful";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return aux;
    }
}
