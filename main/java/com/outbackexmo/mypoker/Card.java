package com.outbackexmo.mypoker;

/**
 * Created by MyServer_U on 2017/02/25.
 */

public class Card {
    private int number;
    private int suit;
    public static final int CLUB = 1;
    public static final int SPADE = 2;
    public static final int HEART = 3;
    public static final int DIAMOND = 4;
    public static final int JOKER = 0;

    public Card(int number, int suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNumver(){
        return number;
    }

    public int getSuit(){
        return suit;
    }
}
