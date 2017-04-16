package com.outbackexmo.mypoker;

import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MyServer_U on 2017/03/02.
 */

public class CenterAreaViewBuilder extends ViewBuilder{

    private LinearLayout linearLayoutAbove;
    private LinearLayout linearLayoutBelow;
    private ImageView imageView;
    private TextView textView;

    public CenterAreaViewBuilder(AppCompatActivity activity){
        super(activity);
        linearLayoutAbove = (LinearLayout)activity.findViewById(R.id.centerAreaAbove);
        linearLayoutBelow = (LinearLayout)activity.findViewById(R.id.centerAreaBelow);
        textView = new TextView(activity);


    }

    public ImageView showCard(boolean isUserPlayer,int resourceId){
        imageView = createImageView();
        //if(isUserPlayer){
            imageView.setImageResource(resourceId);
        //}else{
         //   imageView.setImageResource(R.drawable.back);
        //}
        linearLayoutBelow.addView(imageView);
        return imageView;
    }

    public void removeImageView(){
        if(imageView != null){
            linearLayoutBelow.removeView(imageView);
            imageView = null;
        }
    }

    public void setCenterText(String msg){
        linearLayoutAbove.removeAllViews();
//        textView.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        textView.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setText(msg);
        linearLayoutAbove.addView(textView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
