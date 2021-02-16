package com.titusnachbauer.tennis;

public class Game {

    private final Player player;

    public Game(Player player) {
        this.player = player;
    }

    public static boolean isWonBy(Player player) {
        return player.scoredLastPoint();
    }
}
