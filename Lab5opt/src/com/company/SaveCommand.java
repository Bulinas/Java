package com.company;

import java.io.FileWriter;
import java.io.IOException;

/**
 * saves the current catalog to an
 * external file that can be latter
 * used to load the catalog from.
 */

public class SaveCommand implements Command {


    @Override
    public String runCommand(String[] arguments, Catalog catalog) {
        String aux;
        if (verifyArguments(arguments)) {
            aux = "Error at opening file";
            try {
                FileWriter fileWriter = new FileWriter(arguments[1]);
                fileWriter.write(catalog.toString());
                aux = "Catalog saved to file";
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            aux = "No such file";
        }
        return aux;
    }


}
