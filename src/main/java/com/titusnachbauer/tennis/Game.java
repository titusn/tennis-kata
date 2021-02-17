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
        getPlayerA().setName(playerA);
        getPlayerB().setName(playerB);
    }

    private Player getPlayerB() {
        return players[PLAYER.B.ordinal()];
    }

    private Player getPlayerA() {
        return players[PLAYER.A.ordinal()];
    }

    public void increaseScore(PLAYER player) {
        players[player.ordinal()].increaseScore();
    }

    public String getStatus() {
        return "Deuce";
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
        if (getPlayerA().getScore() == 40 && getPlayerB().getScore() == 40) {
            result = true;
        }
        return result;
    }

}
