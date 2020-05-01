package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * class that manages the interaction with a client
 */

public class ClientThread extends Thread {
    private Socket socket = null;
    private GameServer gameServer = null;

    public ClientThread(Socket socket, GameServer gameServer) {
        this.socket = socket;
        this.gameServer = gameServer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());


                if (request.equals("stop")) {
                    String answer = "Server stopped!";
                    out.println(answer);
                    out.flush();
                    this.gameServer.setServerOn(false);
                    break;
                }

                String answer = "Server received the request: " + request + "!";
                out.println(answer);
                out.flush();

                if (request.equals("exit")) {
                    break;
                }

            }
        } catch (IOException ex) {
            System.out.println("Communication error... " + ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
