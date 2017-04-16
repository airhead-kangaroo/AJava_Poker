package com.outbackexmo.mypoker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by MyServer_U on 2017/03/03.
 */

public class WeakPokerStrategy extends PokerStrategy {


    @Override
    public int selectDiscard(Card card, ArrayList<Card> cards) {
        return new Random().nextInt(7);
    }

    @Override
    public boolean doYouGoOut(int handLevel) {
        if(handLevel >= 2 ){
            return true;
        }else{
            return false;
        }
    }
}
