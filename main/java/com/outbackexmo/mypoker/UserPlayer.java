package com.outbackexmo.mypoker;


/**
 * Created by MyServer_U on 2017/03/02.
 */

public class UserPlayer extends Player {

    private boolean canIClickCard;

    public UserPlayer(String name){
        super(name);
        canIClickCard = false;
    }

    public boolean isUserPlayer(){
        return true;
    }

    public void changePlayStete(){
        if(canIClickCard){
            canIClickCard = false;
        }else {
            canIClickCard = true;
        }
    }

    public boolean getPlayState(){
        return canIClickCard;
    }
}
