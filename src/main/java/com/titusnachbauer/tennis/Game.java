package com.titusnachbauer.tennis;

public class Game {

    private final Player[] players;

    public Game(Player[] players) {
        if (players.length == 1) {
            throw new NotEnoughPlayers();
        }
        this.players = players;
    }

    public void increaseScorePlayerA() {
        players[0].increaseScore();
    }

    public boolean isWonBy(Player player) {
        return findPlayer(player).scoredLastPoint();
    }

    private Player findPlayer(Player player) {
        for(Player current:players) {
            if (current.equals(player)) {
                return current;
            }
        }
        throw new PlayerNotFound();
    }

    public Player getPlayerA() {
        return players[0];
    }
}
