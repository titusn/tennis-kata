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

    private Player getPlayer(PLAYER player) {
        return players[player.ordinal()];
    }

    public boolean isWonByPlayer() {
        boolean result = false;
        if (getPlayerA().scoredLastPoint() && getPlayerB().getScore() <= 30) {
            result = true;
        } else if (getPlayerB().scoredLastPoint() && getPlayerA().getScore() <= 30) {
            result = true;
        }
        return result;
    }

    public String getWinner() {
        if (isWonByPlayer()) {
            return findWinner();
        } else {
            throw new WinnerUnknown("Game still undecided.");
        }
    }

    private String findWinner() {
        Optional<Player> winner = Arrays.stream(players).filter(Player::scoredLastPoint).findFirst();
        if (winner.isPresent()) {
            return winner.get().getName();
        } else {
            return "";
        }
    }

    public boolean isDeuce() {
        boolean result = false;
        if (getPlayerA().getScore() == 40 && getPlayerB().getScore() == 40 && !hasAdvantage(PLAYER.A) && !hasAdvantage(PLAYER.B)) {
            result = true;
        }
        return result;
    }

}
