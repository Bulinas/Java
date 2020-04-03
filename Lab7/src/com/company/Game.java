package com.company;

/**
 * class Game initialises everything
 * and starts the game
 *
 */

public class Game {

    public Game(String player1Name, String player2Name, int n, int m){
        Board board = new Board(n, m);
        Runnable player1 = new Player(player1Name, board);
        Runnable player2 = new Player(player2Name, board);
        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        thread1.start();
        thread2.start();
    }
}
