package com.company;

import java.util.*;

/**
 * class Player manages the action of players
 *
 */

public class Player implements Runnable {
    private List<Token> tokens = new ArrayList<>();
    private String name;
    private Board board;
    private boolean playerWon = false;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * function to chech if the game is on
     * @return
     */

    private boolean gameIsOn() {
        if (board.getNumberOfRemainingTokens() <= 0) {
            return false;
        }
        if (playerHasProgression()) {
            return false;
        }
        return true;
    }

    /**
     * function that checks if the current player
     * has tokens that represent a arithmetic progression
     * @return
     */

    private boolean playerHasProgression() {
        Collections.sort(tokens, new TokenComparator());
        if (tokens.size() < 3) {
            return false;
        }
        int diference = tokens.get(1).getNumber() - tokens.get(0).getNumber();
        for (int i = 1; i < tokens.size(); i++) {
            if (tokens.get(i).getNumber() != tokens.get(i - 1).getNumber() + diference) {
                return false;
            }
        }
        playerWon = true;
        return true;
    }

    private String tokensString() {
        String aux = "";
        for (Token token : tokens) {
            aux += token.getNumber();
            aux += ", ";
        }
        return aux;
    }

    /**
     * override function run for the multithreading
     * and manages the players tokens
     */

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            String input;
            while (gameIsOn()) {
                board.printTokens();
                System.out.println("Player " + name + " current tokens: " + tokensString() + ". Please choose another token: ");
                input = scanner.nextLine();
                tokens.add(board.getToken(Integer.parseInt(input)));
            }
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        if (playerWon) {
            System.out.println(name + " won!");
        }
        else {
            System.out.println(name + " lost!");
        }
    }
}

