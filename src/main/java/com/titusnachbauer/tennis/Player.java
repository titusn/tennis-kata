package com.titusnachbauer.tennis;

public class Player {

    private final int[] possibleScores = {0, 15, 30, 40};
    boolean scoredLastPoint = false;
    private int scoredGamePoints = 0;

    public int getScore() {
        return possibleScores[scoredGamePoints];
    }

    public void increaseScore() {
        if (scoredGamePoints < possibleScores.length - 1) {
            scoredGamePoints++;
        } else {
            scoredLastPoint = true;
        }
    }

    public boolean scoredLastPoint() {
        return scoredLastPoint;
    }
}
