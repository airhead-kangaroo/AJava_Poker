package com.outbackexmo.mypoker;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by MyServer_U on 2017/03/02.
 */

public class PokerFacade {

    private AppCompatActivity activity;
    private UserPlayer userPlayer;
    private EnemyPlayer enemyPlayer;
    private Dealer dealer;
    private CardViewDirector director;
    private CheckPokerHand checker;
    private PokerStrategy strategy;

    public PokerFacade(AppCompatActivity activity){
        this.activity = activity;
    }

    public void preparePoker(){
        getInstance();
        firstDistributeCard();
        director.constructCardView(userPlayer);
        director.constructCardView(enemyPlayer);
    }

    public void setEnemyStrategy(PokerStrategy.strategyCatalog strategy){
        this.strategy = PokerStrategy.getInstance(strategy);
    }

    private void getInstance(){
        userPlayer = new UserPlayer("user");//名前変える
        enemyPlayer = new EnemyPlayer();
        dealer = new Dealer();
        director = new CardViewDirector(activity);
        checker = new CheckPokerHand();
    }

    private void firstDistributeCard(){
        for(int i=0;i<Hand.MAX_CARD_NUMBER;i++){
            userPlayer.addCard(dealer.handoverCard());
            enemyPlayer.addCard(dealer.handoverCard());
        }
    }

    public void choosePlayFirst(){
        int selector = new Random().nextInt(2);
        String msg = "";
        switch (selector){
            case 0:
                userPlayer.setPlayOrder(Player.playOrder.FIRST);
                enemyPlayer.setPlayOrder(Player.playOrder.LAST);
                msg = userPlayer.getName();
                break;
            case 1:
                userPlayer.setPlayOrder(Player.playOrder.LAST);
                enemyPlayer.setPlayOrder(Player.playOrder.FIRST);
                msg = enemyPlayer.getName();
                break;
        }
        msg += activity.getString(R.string.playFirst);
        director.setCenterText(msg);
    }

    public void gameStart() {
        Card pickedCard = dealer.handoverCard();
        switch (userPlayer.getPlayOrder().ordinal()) {
            case 0:
                userPlayerTurn(pickedCard);
                break;
            case 1:
                enemyPlayerTurn(pickedCard);
                break;
        }

    }

    private void userPlayerTurn(Card card){
        ImageView centerImageView = director.setCenterImageView(userPlayer,card);
        director.setCenterText(userPlayer.getName() + activity.getString(R.string.userTurnMsg));
        userPlayer.changePlayStete();
        setCenterImageViewListener(centerImageView);
        setImageViewListenerOnUserCard(card);
    }

    private void enemyPlayerTurn(Card card) {
        final Card pickedCard = card;
        director.setCenterImageView(enemyPlayer, pickedCard);
        director.setCenterText(enemyPlayer.getName() + activity.getString(R.string.enemyTurnMsg));
        Handler handler = new Handler();
        int delayTime = (new Random().nextInt(4) + 1) * 1000;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                enemyPlayer.selectDiscard(strategy, pickedCard);
                director.removeCenterImageView();
                director.constructCardView(enemyPlayer);
                int enemyPokerHand = checker.check(enemyPlayer.getHand());
                if (enemyPokerHand > enemyPlayer.getMyHand()) {
                    enemyPlayer.setMyHand(enemyPokerHand);
                    if (strategy.doYouGoOut(enemyPlayer.getMyHand())) {
                        goOutPoker();
                    }
                }
                Card pickedCard = dealer.handoverCard();
                userPlayerTurn(pickedCard);
            }

        }, delayTime);
    }

    private void setImageViewListenerOnUserCard(Card card) {
        director.constructCardView(userPlayer); //ImageViewのIDを初期化するためにリビルド
        final Card pickedCard = card;
        View views[] = director.getImageViewInGridLayout(userPlayer);
        for (int i = 0; i < views.length; i++) {
            ImageView imageView = (ImageView) views[i];
            imageView.setId(i);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userPlayer.getPlayState()) {
                        int id = v.getId();
                        userPlayer.removeCard(id);
                        userPlayer.addCard(pickedCard);
                        int usersPokerHand = checker.check(userPlayer.getHand());
                        if (usersPokerHand != Hand.HIGH_CARDS) {
                            userPlayer.setMyHand(usersPokerHand);
                        }
                        director.constructCardView(userPlayer);
                        director.removeCenterImageView();
                        userPlayer.changePlayStete();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Card pickedCard = dealer.handoverCard();
                                enemyPlayerTurn(pickedCard);
                            }
                        }, 2000);
                    }
                }
            });
        }
    }

    private void setCenterImageViewListener(ImageView v){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                director.removeCenterImageView();
                Card pickedCard = dealer.handoverCard();
                enemyPlayerTurn(pickedCard);
            }
        });
    }

    public void goOutPoker(){
        HashMap<String,String> dataForFinishPage = new HashMap<>();
        dataForFinishPage.put(userPlayer.getName(),pokerHandToString(userPlayer.getMyHand()));
        dataForFinishPage.put(enemyPlayer.getName(),pokerHandToString(enemyPlayer.getMyHand()));
        if(userPlayer.getMyHand() < enemyPlayer.getMyHand()){
            dataForFinishPage.put("Winner",enemyPlayer.getName());
        }else if(userPlayer.getMyHand() > enemyPlayer.getMyHand()){
            dataForFinishPage.put("Winner",userPlayer.getName());
        }else {
            dataForFinishPage.put("Winner","引き分け");
        }
        Intent intent = new Intent(activity,FinishActivity.class);
        intent.putExtra("data",dataForFinishPage);
        activity.startActivity(intent);
    }

    private String pokerHandToString(int pokerhand){
        String handStr = "";
        switch (pokerhand){
            case Hand.STRAIGHT_FLUSH:
                handStr = "ストレートフラッシュ";
                break;
            case Hand.FOUR_OF_A_KIND:
                handStr = "フォーカード";
                break;
            case Hand.FULL_HOUSE:
                handStr ="フルハウス";
                break;
            case Hand.FLUSH:
                handStr ="フラッシュ";
                break;
            case Hand.STRAIGHT:
                handStr ="ストレート";
                break;
            case Hand.THREE_OF_A_KIND:
                handStr ="スリーカード";
                break;
            case Hand.TWO_PAIR:
                handStr ="ツーペア";
                break;
            case Hand.ONE_PAIR:
                handStr ="ワンペア";
                break;
            case Hand.HIGH_CARDS:
                handStr ="ブタ";
                break;
        }
        return handStr;
    }

}
