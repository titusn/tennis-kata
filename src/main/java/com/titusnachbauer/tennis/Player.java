package com.titusnachbauer.tennis;

public class Player {

    private final int[] possibleScores = {0, 15, 30, 40};
    private int scoredGamePoints = 0;

    public int getScore() {
        return possibleScores[scoredGamePoints];
    }

    public void increaseScore() {
        scoredGamePoints++;
    }

    public boolean scoredLastPoint() {
        return (scoredGamePoints > 3);
    }
}
