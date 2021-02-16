package com.titusnachbauer.tennis;

public class Game {

    private final Player[] players = new Player[]{new Player(), new Player()};

    public void increaseScorePlayerA() {
        players[0].increaseScore();
    }

    public boolean isWonByPlayerA() {
        return players[0].scoredLastPoint();
    }

}
