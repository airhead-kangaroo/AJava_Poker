package com.outbackexmo.mypoker;

import java.util.ArrayList;

/**
 * Created by MyServer_U on 2017/03/03.
 */

public class AirHeadPokerStrategy extends PokerStrategy {

    @Override
    public int selectDiscard(Card card, ArrayList<Card> cards) {
        return 0;
    }

    @Override
    public boolean doYouGoOut(int handLevel) {
        if(handLevel >= 2){
            return true;
        }else {
            return false;
        }
    }
}
