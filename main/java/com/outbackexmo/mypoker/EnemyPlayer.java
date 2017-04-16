package com.outbackexmo.mypoker;



/**
 * Created by MyServer_U on 2017/03/02.
 */

public class EnemyPlayer extends Player {

    private static final String NAME = "enemy";

    public EnemyPlayer(){
        super(NAME);
    }

    @Override
    public boolean isUserPlayer() {
        return false;
    }

    public void selectDiscard(PokerStrategy strategy,Card card){
        int index = strategy.selectDiscard(card,hand.getCards());
        if(index < 6){
            hand.removeCard(index);
            hand.addCard(card);
        }
    }
}
