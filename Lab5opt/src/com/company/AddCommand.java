package com.company;

/**
 * Class that adds a Document to the Catalog
 */

public class AddCommand implements Command {
   private static int id = 0;

    @Override
    public String runCommand(String[] arguments, Catalog catalog) {
        String aux;
        if (verifyArguments(arguments)) {
            String nameDocument = "Document" + id;
            catalog.addDocument(new Document(id, nameDocument, arguments[1]));
            id++;
            aux = "File added to catalog";
        } else {
            aux = "No such file";
        }
        return aux;
    }
}
