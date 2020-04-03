package com.company;

import java.util.Comparator;

public class TokenComparator implements Comparator<Token> {
    @Override
    public int compare(Token token, Token t1) {
        return token.getNumber() - t1.getNumber();
    }
}
