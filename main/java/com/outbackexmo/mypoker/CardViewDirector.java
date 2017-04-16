package com.outbackexmo.mypoker;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MyServer_U on 2017/03/01.
 */

public class CardViewDirector {

    private AppCompatActivity activity;
    private TrumpCardBuilder cardBuilder;
    private CenterAreaViewBuilder centerBuilder;
    private CardViewBuilder viewBuilder;

    public CardViewDirector(AppCompatActivity activity){
        this.activity = activity;
        cardBuilder = new TrumpCardBuilder();
        centerBuilder = new CenterAreaViewBuilder(activity);
        viewBuilder = new CardViewBuilder(activity);

    }

    public void constructCardView(Player player){
        viewBuilder.clearCardView(player.isUserPlayer());
        for (int i=0;i<Hand.MAX_CARD_NUMBER;i++){
            ImageView imageView = viewBuilder.createImageView();
            Hand hand = player.getHand();
            Card card = hand.getCard(i);
            int resourceId = cardBuilder.build(card);
            viewBuilder.createCardView(player.isUserPlayer(),resourceId,imageView);
        }
    }

    public ImageView setCenterImageView(Player player, Card card){

        int resourceId = cardBuilder.build(card);
        return centerBuilder.showCard(player.isUserPlayer(),resourceId);
    }

    public void setCenterText(String msg){
        centerBuilder.setCenterText(msg);
    }

    public void removeCenterImageView(){
        centerBuilder.removeImageView();
    }

    public View[] getImageViewInGridLayout(Player player){
        return viewBuilder.getImageViewInGridLayout(player.isUserPlayer());
    }

}
