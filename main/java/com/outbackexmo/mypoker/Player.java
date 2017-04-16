package com.outbackexmo.mypoker;

/**
 * Created by MyServer_U on 2017/03/01.
 */

public abstract class Player {

    protected String name;
    protected Hand hand;

    public enum playOrder { FIRST,LAST}
    private playOrder playOrder;


    public Player(String name){
        this.name = name;
        hand = new Hand();
    }

    public void addCard(Card card){
        hand.addCard(card);
    }

    public void removeCard(int cardIndex){
        hand.removeCard(cardIndex);
    } //後ほど修正

    public void checkHand(){
        hand.checkHand();
    }

    public Hand getHand(){
        return hand;
    }

    public void setPlayOrder(playOrder playOrder){
        this.playOrder = playOrder;
    }

    public playOrder getPlayOrder(){
        return playOrder;
    }

    public String getName(){
        return name;
    }

    public void setMyHand(int pokerhand){
        hand.setMyHand(pokerhand);
    }

    public int getMyHand(){
        return hand.myHand;
    }

    public abstract boolean isUserPlayer();
}
