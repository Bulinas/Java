package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * opens a file that the user gave or
 * and uri that the user gave in case
 * the program couldn't file a local file that the user gave
 */

public class ViewCommand implements Command {

    @Override
    public String runCommand(String[] arguments, Catalog catalog) {
        String aux;
        if (verifyArguments(arguments)){
            aux = "Error at opening path file";
            try {
                File file = new File(arguments[1]);
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
                aux  = "Opened file";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            aux = "Error at opening URL";
            try {
                URI uri = new URI(arguments[1]);
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(uri);
                aux = "Opened file";
            }
            catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return aux;
    }
}
