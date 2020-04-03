package com.company;

/**
 * class Token retains a number
 * that is the value of the token
 * 0 is for the blank
 *
 */

public class Token {
    private int number;

    public Token(int number){
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBlank(){
        return number == 0 ? true : false;
    }

}
