package com.outbackexmo.mypoker;

/**
 * Created by MyServer_U on 2017/03/01.
 */

public class Dealer {

    private DealerHand hand;

    public Dealer(){
        initCard();
    }

    private void initCard(){
        hand = new DealerHand();
        hand.initCard();
        hand.shuffleCard();
    }

    public Card handoverCard(){
        return hand.distributeCard();
    }
}
