package com.company;

import java.io.File;
import java.io.IOException;

/**
 * Interface for the commands
 * Also has the default function that verifies
 * that the arguments are passed ok from the user
 */

public interface Command {
    String runCommand(String[] arguments, Catalog catalog) throws IOException;
    default boolean verifyArguments(String[] arguments){
        boolean returnValue = false;
        if (arguments.length > 1) {
            try {
                File file = new File(arguments[1]);
                if (file.exists()) {
                    returnValue = true;
                }
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                System.out.println("Buba!");
            }
        }
        return returnValue;
    }
}
