package com.outbackexmo.mypoker;

import java.util.ArrayList;

/**
 * Created by MyServer_U on 2017/03/03.
 */

public class LazyPokerStrategy extends PokerStrategy {
    @Override
    public int selectDiscard(Card card, ArrayList<Card> cards) {
        return 6;
    }

    @Override
    public boolean doYouGoOut(int handLevel) {
        if(handLevel >= 1){
            return true;
        }else {
            return false;
        }
    }
}
