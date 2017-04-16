package com.outbackexmo.mypoker;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    private PokerFacade facade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        facade = new PokerFacade(this);
        facade.preparePoker();
        facade.setEnemyStrategy(PokerStrategy.strategyCatalog.AIRHEAD);
        facade.choosePlayFirst();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                facade.gameStart();
            }
        },3000);
    }

    public void goOut(View view){
        facade.goOutPoker();
    }
}
