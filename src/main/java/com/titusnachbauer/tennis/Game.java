package com.titusnachbauer.tennis;

public class Game {

    public String getWinner() {
        if (isWonByPlayer()) {
            for (Player player: players) {
                if (player.scoredLastPoint()) {
                    return player.getName();
                }
            }
        }
        throw new WinnerUnknown("Game still undecided.");
    }

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
        return players[PLAYER.A.ordinal()].scoredLastPoint() || players[PLAYER.B.ordinal()].scoredLastPoint();
    }

}
