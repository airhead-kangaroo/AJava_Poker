package com.outbackexmo.mypoker;

import java.util.ArrayList;

/**
 * Created by MyServer_U on 2017/03/03.
 */

public abstract class PokerStrategy {

    protected static PokerStrategy singletonStrategy;

    protected PokerStrategy(){

    }

    public enum strategyCatalog {AIRHEAD, LAZY,WEAK}

    public abstract int selectDiscard(Card card, ArrayList<Card> cards);

    public static PokerStrategy getInstance(strategyCatalog strategyName) {

        if (singletonStrategy == null) {
            switch (strategyName) {
                case AIRHEAD:
                    singletonStrategy = new AirHeadPokerStrategy();
                case WEAK:
                    singletonStrategy = new WeakPokerStrategy();
                case LAZY:
                    singletonStrategy = new LazyPokerStrategy();
            }
        }
        return singletonStrategy;
    }

    public abstract boolean doYouGoOut(int handLevel);
}
