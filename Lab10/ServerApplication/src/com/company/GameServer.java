package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


/**
 * Class GameServer accepts clients
 * and creates a new thread for a new client
 */

public class GameServer {
    public static final int PORT = 8100;
    private boolean serverOn = true;

    private ServerSocket serverSocket = null;

    public GameServer() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            while (serverOn) {
                System.out.println("Waiting for client");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).start();
            }
        } catch (IOException ex) {
            System.out.println("Oooops..." + ex);
        } finally {
            serverSocket.close();
        }
    }

    public void setServerOn(boolean serverOn) {
        this.serverOn = serverOn;
    }

}
