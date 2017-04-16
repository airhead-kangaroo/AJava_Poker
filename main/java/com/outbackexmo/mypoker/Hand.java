package com.outbackexmo.mypoker;

import java.util.ArrayList;

/**
 * Created by MyServer_U on 2017/03/01.
 */

public class Hand {

    public static final int STRAIGHT_FLUSH = 8;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int FULL_HOUSE = 6;
    public static final int FLUSH = 5;
    public static final int STRAIGHT = 4;
    public static final int THREE_OF_A_KIND = 3;
    public static final int TWO_PAIR = 2;
    public static final int ONE_PAIR = 1;
    public static final int HIGH_CARDS = 0;

    protected ArrayList<Card> cards;
    protected int myHand;
    public static final int MAX_CARD_NUMBER = 5;

    public Hand(){
        cards = new ArrayList<>();
        myHand = HIGH_CARDS;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(int index){
       return cards.remove(index);
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public Card getCard(int cardNumber){
        return cards.get(cardNumber);
    }

    public void setMyHand(int pokerHand){
        myHand = pokerHand;
    }

    public int getMyHand(){
        return FLUSH;
    }

    public int checkHand(){
        return 0; // 他クラスを実装し、あがりかどうかのチェックをする
    }
}
