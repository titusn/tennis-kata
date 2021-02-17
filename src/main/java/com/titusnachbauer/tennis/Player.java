package com.titusnachbauer.tennis;

public class Player {

    private final int[] possibleScores = {0, 15, 30, 40};
    boolean scoredLastPoint = false;
    private int scoredGamePoints = 0;
    private String name;
    private boolean hasAdvantage;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasAdvantage() {
        return hasAdvantage;
    }

    public void setAdvantage() {
        hasAdvantage = true;
    }

    public void resetAdvantage() {
        hasAdvantage = false;
    }
}
