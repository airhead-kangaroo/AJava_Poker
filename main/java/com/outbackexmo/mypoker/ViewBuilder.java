package com.outbackexmo.mypoker;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by MyServer_U on 2017/03/02.
 */

public abstract class ViewBuilder {

    protected AppCompatActivity activity;

    public ViewBuilder(AppCompatActivity activity){
        this.activity = activity;
    }

    public ImageView createImageView() {
        ImageView imageView = new ImageView(activity);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                (int) activity.getResources().getDimension(R.dimen.card_width),
                (int) activity.getResources().getDimension(R.dimen.card_height)
        ));
        return imageView;
    }
}
