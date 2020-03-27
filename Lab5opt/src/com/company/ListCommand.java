package com.company;

/**
 * prints the current catalog to
 * the shell
 */

public class ListCommand implements Command{

    @Override
    public String runCommand(String[] arguments, Catalog catalog) {
        return catalog.toString();
    }

    
}
