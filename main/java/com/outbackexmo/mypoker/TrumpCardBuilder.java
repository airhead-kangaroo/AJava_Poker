package com.outbackexmo.mypoker;

/**
 * Created by MyServer_U on 2017/02/25.
 */

public class TrumpCardBuilder {


    public int build(Card card) {
        int img = 0;
        switch (card.getSuit()) {
            case Card.JOKER:
                img = R.drawable.joker;
            case Card.CLUB:
                switch (card.getNumver()) {
                    case 1:
                        img = R.drawable.c01;
                        break;
                    case 2:
                        img = R.drawable.c02;
                        break;
                    case 3:
                        img = R.drawable.c03;
                        break;
                    case 4:
                        img = R.drawable.c04;
                        break;
                    case 5:
                        img = R.drawable.c05;
                        break;
                    case 6:
                        img = R.drawable.c06;
                        break;
                    case 7:
                        img = R.drawable.c07;
                        break;
                    case 8:
                        img = R.drawable.c08;
                        break;
                    case 9:
                        img = R.drawable.c09;
                        break;
                    case 10:
                        img = R.drawable.c10;
                        break;
                    case 11:
                        img = R.drawable.c11;
                        break;
                    case 12:
                        img = R.drawable.c12;
                        break;
                    case 13:
                        img = R.drawable.c13;
                        break;
                }
                break;
            case Card.SPADE:
                switch (card.getNumver()) {
                    case 1:
                        img = R.drawable.s01;
                        break;
                    case 2:
                        img = R.drawable.s02;
                        break;
                    case 3:
                        img = R.drawable.s03;
                        break;
                    case 4:
                        img = R.drawable.s04;
                        break;
                    case 5:
                        img = R.drawable.s05;
                        break;
                    case 6:
                        img = R.drawable.s06;
                        break;
                    case 7:
                        img = R.drawable.s07;
                        break;
                    case 8:
                        img = R.drawable.s08;
                        break;
                    case 9:
                        img = R.drawable.s09;
                        break;
                    case 10:
                        img = R.drawable.s10;
                        break;
                    case 11:
                        img = R.drawable.s11;
                        break;
                    case 12:
                        img = R.drawable.s12;
                        break;
                    case 13:
                        img = R.drawable.s13;
                        break;
                }
                break;
            case Card.HEART:
                switch (card.getNumver()) {
                    case 1:
                        img = R.drawable.h01;
                        break;
                    case 2:
                        img = R.drawable.h02;
                        break;
                    case 3:
                        img = R.drawable.h03;
                        break;
                    case 4:
                        img = R.drawable.h04;
                        break;
                    case 5:
                        img = R.drawable.h05;
                        break;
                    case 6:
                        img = R.drawable.h06;
                        break;
                    case 7:
                        img = R.drawable.h07;
                        break;
                    case 8:
                        img = R.drawable.h08;
                        break;
                    case 9:
                        img = R.drawable.h09;
                        break;
                    case 10:
                        img = R.drawable.h10;
                        break;
                    case 11:
                        img = R.drawable.h11;
                        break;
                    case 12:
                        img = R.drawable.h12;
                        break;
                    case 13:
                        img = R.drawable.h13;
                        break;
                }
                break;
            case Card.DIAMOND:
                switch (card.getNumver()) {
                    case 1:
                        img = R.drawable.d01;
                        break;
                    case 2:
                        img = R.drawable.d02;
                        break;
                    case 3:
                        img = R.drawable.d03;
                        break;
                    case 4:
                        img = R.drawable.d04;
                        break;
                    case 5:
                        img = R.drawable.d05;
                        break;
                    case 6:
                        img = R.drawable.d06;
                        break;
                    case 7:
                        img = R.drawable.d07;
                        break;
                    case 8:
                        img = R.drawable.d08;
                        break;
                    case 9:
                        img = R.drawable.d09;
                        break;
                    case 10:
                        img = R.drawable.d10;
                        break;
                    case 11:
                        img = R.drawable.d11;
                        break;
                    case 12:
                        img = R.drawable.d12;
                        break;
                    case 13:
                        img = R.drawable.d13;
                        break;
                }
                break;
        }
        return img;
    }

    public int backCardBuild(){
        return R.drawable.back;
    }

}
