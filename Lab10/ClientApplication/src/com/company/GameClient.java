package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * class that creates a client
 * and reads commands from command line
 * to send to the server
 */

public class GameClient {
    private static final int PORT = 8100;
    private static final String serverAddress = "127.0.0.1";

    public GameClient() throws IOException{
        try {
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String command;
            String request;
            String response;

            while (true){
                System.out.print("Enter your command:");
                command = scanner.next();
                if (command.equals("exit")){
                    System.out.println("Program closed!");
                    break;
                }

                request = command;
                out.println(request);

                response = in.readLine();
                System.out.println(response);
            }

        }
        catch (UnknownHostException e){
            System.out.println("No server listening... " + e);
        }
    }
}
