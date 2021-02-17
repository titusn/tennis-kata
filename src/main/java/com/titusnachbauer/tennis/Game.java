package com.titusnachbauer.tennis;

import java.util.Arrays;
import java.util.Optional;

public class Game {

    public enum PLAYER {
        A,
        B
    }

    private final Player[] players = new Player[]{new Player(), new Player()};

    public Game(String playerA, String playerB) {
        players[PLAYER.A.ordinal()].setName(playerA);
        players[PLAYER.B.ordinal()].setName(playerB);
    }

    public void increaseScore(PLAYER player) {
        players[player.ordinal()].increaseScore();
    }

    public String getStatus() {
        return "Deuce";
    }

    public boolean isWonByPlayer() {
        boolean result = false;
        if (players[PLAYER.A.ordinal()].scoredLastPoint() && players[PLAYER.B.ordinal()].getScore() <= 30) {
            result = true;
        } else if (players[PLAYER.B.ordinal()].scoredLastPoint() && players[PLAYER.A.ordinal()].getScore() <= 30) {
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
}
