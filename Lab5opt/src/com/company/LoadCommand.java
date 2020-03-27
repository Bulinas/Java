package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 * loads a catalog from an external file that the user
 * gave. The catalog file has to be prior written by
 * the save command.
 */

public class LoadCommand implements Command {

    private String delim = " = |, ";

    @Override
    public String runCommand(String[] arguments, Catalog catalog) {
        String aux;
        if (verifyArguments(arguments)){
            aux = "Error at loading the catalog";
            try{
                FileInputStream file = new FileInputStream(arguments[1]);
                Scanner scanner = new Scanner(file);
                int index = 0;
                while (scanner.hasNextLine()){
                    if (index == 0){
                        catalog = catalogInitialisation(scanner.nextLine());
                        index++;
                    }
                    else{
                        catalog.addDocument(parseToDocument(scanner.nextLine()));
                    }
                }
                aux = "Catalog read successful";
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        else {
            aux = "No such file";
        }
        return aux;
    }

    private Catalog catalogInitialisation(String line){
        String[] aux = line.split(delim);
        return new Catalog(aux[1]);
    }

    private Document parseToDocument(String line){
        String[] aux = line.split(delim);
        return new Document(Integer.parseInt(aux[1]), aux[3], aux[5]);
    }

}

