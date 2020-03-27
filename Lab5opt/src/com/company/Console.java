package com.company;

import java.io.IOException;
import java.util.Scanner;

/**
 * Console operates the shell console so we can right our commands there
 */

public class Console {
    private boolean consoleIsOn;
    private Scanner myScanner = new Scanner(System.in);
    private String[] commands;
    private Catalog catalog = new Catalog("Catalog");
    private String[] help = {
            "Commands:",
            "add + 1 argument(path): add the file into the catalog",
            "save + 1 argument(path): save the catalog to path",
            "load + 1 argument(path): load the catalog from path",
            "view + 1 argument(path): open the path file",
            "list: lists the catalog",
            "report_html: create an HTML report with the content of the catalog",
            "exit: close the console"
    };

    /**
     *
     * start the console with this function
     * Read the input from the user then run the command
     * @throws IOException
     */
    public void startConsole() throws IOException {
        consoleIsOn = true;
        while (consoleIsOn) {
            System.out.println("Enter command:");
            commands = readCommands();
//            printCommands(commands);
            runCommand(commands);
        }
    }

    private String[] readCommands() {
        String lineCommand = myScanner.nextLine();
        return parseString(lineCommand);
    }

    private String[] parseString(String string) {
        String delims = " +";
        String[] tokens = string.split(delims);
        return tokens;
    }

    private void printCommands(String[] commands) {
        for (String aux : commands) {
            System.out.println(aux);
        }
    }

    /**
     * function that runs the command the user gave
     * @param commands
     * @throws IOException
     */

    private void runCommand(String[] commands) throws IOException {
        switch (commands[0]) {
            case "exit":
                System.out.println("Console will close!");
                consoleIsOn = false;
                break;
            case "load":
                Command commandLoad = new LoadCommand();
                System.out.println(commandLoad.runCommand(commands, catalog));
                break;
            case "add":
                Command commandAdd = new AddCommand();
                System.out.println(commandAdd.runCommand(commands, catalog));
                break;
            case "list":
                Command commandList = new ListCommand();
                System.out.println(commandList.runCommand(commands, catalog));
                break;
            case "view":
                Command commandView = new ViewCommand();
                System.out.println(commandView.runCommand(commands, catalog));
                break;
            case "save":
                Command commandSave = new SaveCommand();
                System.out.println(commandSave.runCommand(commands, catalog));
                break;
            case "help":
                printHelp();
                break;
            case "report_html":
                Command commandReportHtml = new ReportHtmlCommand();
                System.out.println(commandReportHtml.runCommand(commands, catalog));
                break;
            default:
                System.out.println("Wrong command!");
        }
    }

    private void printHelp() {
        for (String i : help) {
            System.out.println(i);
        }
    }
}
