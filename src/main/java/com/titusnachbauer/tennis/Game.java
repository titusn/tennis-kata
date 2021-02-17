package com.titusnachbauer.tennis;

import java.util.Arrays;
import java.util.Optional;

public class Game {

    public boolean hasAdvantage(PLAYER playerID) {
        return getPlayer(playerID).hasAdvantage();
    }

    public enum PLAYER {
        A,
        B
    }

    private final Player[] players = new Player[]{new Player(), new Player()};

    public Game(String playerA, String playerB) {
        getPlayerA().setName(playerA);
        getPlayerB().setName(playerB);
    }

    private Player getPlayerB() {
        return getPlayer(PLAYER.B);
    }

    private Player getPlayerA() {
        return getPlayer(PLAYER.A);
    }

    public void increaseScore(PLAYER playerID) {
        if (isDeuce()) {
            getPlayer(playerID).setAdvantage();
        } else if (getOpponent(playerID).hasAdvantage()) {
            getOpponent(playerID).resetAdvantage();
        } else {
            getPlayer(playerID).increaseScore();
        }
    }

    private Player getOpponent(PLAYER playerID) {
        if (playerID == PLAYER.A) {
            return getPlayerB();
        } else {
            return getPlayerA();
        }
    }

    private Player getPlayer(PLAYER playerID) {
        return players[playerID.ordinal()];
    }

    public boolean isWonByPlayer(PLAYER playerID) {
        return  (getPlayer(playerID).scoredLastPoint() && getOpponent(playerID).getScore() <= 30);
    }

    public String getWinner() {
        try {
            return findWinner();
        } catch (WinnerUnknown winnerUnknown) {
            throw winnerUnknown;
        }
    }

    private String findWinner() {
        Optional<Player> winner = Arrays.stream(players).filter(Player::scoredLastPoint).findFirst();
        if (winner.isPresent()) {
            return winner.get().getName();
        } else {
            throw new WinnerUnknown("Game still undecided.");
        }
    }

    public boolean isDeuce() {
        return  (getPlayerA().getScore() == 40 && getPlayerB().getScore() == 40 && !hasAdvantage(PLAYER.A) && !hasAdvantage(PLAYER.B));
    }

}
