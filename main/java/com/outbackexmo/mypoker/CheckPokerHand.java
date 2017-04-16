package com.outbackexmo.mypoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by MyServer_U on 2017/03/03.
 */

public class CheckPokerHand {
    private boolean fourOfAKind;
    private boolean flush;
    private boolean straight;
    private boolean threeOfAKind;
    private int pair;
    private ArrayList<Card> playerCards;



    public int check(Hand hand){
        playerCards = hand.getCards();
        initChecker();
        prepareCheck();
        if(straight && flush){
            return Hand.STRAIGHT_FLUSH;
        }
        if(fourOfAKind){
            return Hand.FOUR_OF_A_KIND;
        }
        if(pair == 1 && threeOfAKind){
            return Hand.FULL_HOUSE;
        }
        if(flush){
            return Hand.FLUSH;
        }
        if(straight){
            return Hand.STRAIGHT;
        }
        if(threeOfAKind){
            return Hand.THREE_OF_A_KIND;
        }
        if(pair ==2){
            return Hand.TWO_PAIR;
        }
        if(pair == 1){
            return Hand.ONE_PAIR;
        }
        return Hand.HIGH_CARDS;
    }

    private void prepareCheck(){
        pair = checkPair();
        threeOfAKind = checkThreeOfKind();
        straight = checkStraight();
        flush = checkFlush();
        fourOfAKind = checkFourOfKind();
    }

    private void initChecker(){
        fourOfAKind = false;
        flush = false;
        straight = false;
        threeOfAKind = false;
        pair = 0;
        sortCards();
    }

    private void sortCards(){
        Collections.sort(playerCards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.getNumver() - c2.getNumver();
            }
        });
    }

    private int checkPair(){
        final int OUT_OF_BOUNDS = 10;
        int pairCount = 0;
        int pairAlreadyDitected = OUT_OF_BOUNDS;
        for(int i=0;i<playerCards.size();i++){
            for(int j=i+1;j<playerCards.size();j++){
                if(playerCards.get(i).getNumver() == playerCards.get(j).getNumver() &&
                        playerCards.get(i).getNumver() != pairAlreadyDitected){
                    pairCount++;
                    pairAlreadyDitected = playerCards.get(i).getNumver();
                    if(pairCount == 2){
                        return pairCount;
                    }
                }
            }
        }
        return pairCount;
    }

    private boolean checkThreeOfKind(){
        for(int i=0;i<playerCards.size();i++){
            int count = 0;
            for(int j=0;j<playerCards.size();j++){
                if(playerCards.get(i).getNumver() == playerCards.get(j).getNumver() && i != j){
                    count++;
                    if(count == 2){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkStraight(){
        int baseNumber = playerCards.get(0).getNumver();
        int checkCount = 0;
        for(int i=0;i<playerCards.size();i++){
            if(baseNumber + i == playerCards.get(i).getNumver()){
                checkCount++;
                if(checkCount == 5){
                    return true;
                }
            }
        }
        if(baseNumber == 1){
            baseNumber = 10;
            checkCount = 0;
            for(int i=1;i<playerCards.size() - 1; i++){
                if(baseNumber + i - 1 == playerCards.get(i).getNumver()){
                    checkCount++;
                    if(checkCount == 4){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkFlush(){
        int baseSuit = playerCards.get(0).getSuit();
        for(int i=0;i<playerCards.size();i++){
            if(baseSuit != playerCards.get(i).getSuit()){
                return false;
            }
        }
        return true;
    }

    private boolean checkFourOfKind(){
        for(int i=0;i<playerCards.size();i++){
            int count = 0;
            for(int j=0;j<playerCards.size();j++){
                if(playerCards.get(i).getNumver() == playerCards.get(j).getNumver() && i != j){
                    count++;
                    if(count == 3){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
