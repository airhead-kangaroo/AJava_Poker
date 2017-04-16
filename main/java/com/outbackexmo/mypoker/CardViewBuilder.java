package com.outbackexmo.mypoker;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;


/**
 * Created by MyServer_U on 2017/03/01.
 */

public class CardViewBuilder extends ViewBuilder{

    public CardViewBuilder(AppCompatActivity activity) {
        super(activity);
    }

    public void createCardView(boolean isUserPlayer, int resorceId,ImageView imageView){
        GridLayout gridLayout = getGridLayout(isUserPlayer);
       // if(isUserPlayer){
            imageView.setImageResource(resorceId);
        //}else{
        //    imageView.setImageResource(R.drawable.back);
        //}
        gridLayout.addView(imageView);
    }

    public void clearCardView(boolean isUserPlayer){
        GridLayout gridLayout = getGridLayout(isUserPlayer);
        gridLayout.removeAllViews();
    }

    private GridLayout getGridLayout(boolean isUserPlayer) {
        if(isUserPlayer) {
            return (GridLayout) activity.findViewById(R.id.UserGridLayout);
        }else {
            return (GridLayout) activity.findViewById(R.id.enemyGridLayout);
        }
    }

    public View[] getImageViewInGridLayout(boolean isUserPlayer){
        GridLayout gridLayout;
        View[] view = new View[Hand.MAX_CARD_NUMBER];
        if(isUserPlayer){
            gridLayout = (GridLayout)activity.findViewById(R.id.UserGridLayout);
        }else {
            gridLayout = (GridLayout)activity.findViewById(R.id.enemyGridLayout);
        }
        for(int i=0;i<Hand.MAX_CARD_NUMBER;i++){
            view[i] = gridLayout.getChildAt(i);
        }
        return view;
    }
}
