import com.titusnachbauer.tennis.Game;
import com.titusnachbauer.tennis.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {
    Player player = new Player();

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
    void whenPlayerScoresFourPointsInARowThenPlayerWinsGame() {
        Game game = new Game("PlayerA", "PlayerB");
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        assertTrue(game.isWonByPlayer());
        assertEquals("PlayerA",game.getWinner());
    }

    @Test
    void whenPlayerScoresThreePointsInARowThenGameIsNotWon() {
        Game game = new Game("PlayerA", "PlayerB");
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isWonByPlayer());
    }

}
