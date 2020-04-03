package com.company;

import java.util.*;

public class Board {
    private List<Token> tokens = Collections.synchronizedList(new ArrayList<Token>());
    private boolean available = false;

    public Board(int n, int m){
        ArrayList<Integer> numbersForTokens = generateNumbersForTokens(m);
        Random random = new Random();
        for (int i = 1; i <= n; i++) {
            int position = random.nextInt(numbersForTokens.size());
            Token tokenAux = new Token(numbersForTokens.get(position));
            numbersForTokens.remove(position);
            tokens.add(tokenAux);
        }
    }

    private ArrayList<Integer> generateNumbersForTokens(int m){
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for (int i = 0; i <= m; i++) {
            aux.add(i);
        }
        return aux;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public int getNumberOfRemainingTokens() {
        return tokens.size();
    }

    public synchronized Token getToken(int i) throws InterruptedException {
        wait();
        Token returnToken = tokens.get(i);
        tokens.remove(i);
        notifyAll();
        return returnToken;
    }

    public void printTokens(){
        System.out.println("Avaible tokens: ");
        for (Token token: tokens) {
            System.out.print(token.getNumber());
        }
    }
}
