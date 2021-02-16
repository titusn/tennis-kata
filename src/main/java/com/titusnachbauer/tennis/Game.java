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

    public boolean isWonByPlayer() {
        return (!findWinner().equals(""));
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
