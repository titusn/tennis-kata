import com.titusnachbauer.tennis.Game;
import com.titusnachbauer.tennis.Player;
import com.titusnachbauer.tennis.WinnerUnknown;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {
    private Player player = new Player();
    private Game game = new Game("PlayerA", "PlayerB");

    @Test
    public void newPlayerShouldHaveScoreZero() {
        assertEquals(0, player.getScore());
    }

    @Test
    void increaseScoreOnceShouldSetScoreTo15() {
        player.increaseScore();
        assertEquals(15, player.getScore());
    }

    @Test
    void increaseScoreTwiceShouldSetScoreTo30() {
        player.increaseScore();
        player.increaseScore();
        assertEquals(30, player.getScore());
    }

    @Test
    void increaseScoreThriceShouldSetScoreTo40() {
        player.increaseScore();
        player.increaseScore();
        player.increaseScore();
        assertEquals(40, player.getScore());
    }

    @Test
    void scoreShouldNeverBeHigherThan40() {
        player.increaseScore();
        player.increaseScore();
        player.increaseScore();
        player.increaseScore();
        assertEquals(40, player.getScore());
    }

    @Test
    void whenPlayerAScoresFourPointsInARowThenPlayerWinsGame() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        assertTrue(game.isWonByPlayer());
        assertEquals("PlayerA",game.getWinner());
    }

    @Test
    void whenPlayerScoresThreePointsInARowThenGameIsNotWon() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isWonByPlayer());
    }

    @Test
    void whenGameIsUndecidedShouldThrowWinnerUnknown() {
        assertFalse(game.isWonByPlayer());
        assertThrows(WinnerUnknown.class, game::getWinner);
    }

    @Test
    void whenPlayerScoresFourPointsInARowButOnlyOneMoreThanOpponentThenGameIsNotWon() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isWonByPlayer());
    }



}
