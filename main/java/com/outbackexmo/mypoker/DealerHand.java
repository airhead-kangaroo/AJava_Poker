package com.outbackexmo.mypoker;


import java.util.Collections;

/**
 * Created by MyServer_U on 2017/03/01.
 */

public class DealerHand extends Hand {

    public DealerHand(){
        super();
    }

    public void initCard(){
        for(int i=1;i<=4;i++){
            for(int j=1;j<=13;j++){
                Card card = new Card(j,i);
                cards.add(card);
            }
        }
        //cards.add(new Card(0,0)); //ジョーカー。後ほど追加する。クリア判定難！
    }

    public void shuffleCard(){
        Collections.shuffle(cards);
    }

    public Card distributeCard(){
        return cards.remove(0);
    }
}
