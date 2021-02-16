package com.titusnachbauer.tennis;

public class Player {

    private int score;

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        if (score == 0) {
            score = 15;
        } else {
            score = 30;
        }
    }
}
