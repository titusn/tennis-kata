import com.titusnachbauer.tennis.Game;
import com.titusnachbauer.tennis.WinnerUnknown;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {
    private Game game = new Game("PlayerA", "PlayerB");

    @Test
    void givenPlayerAScoresFourPointsInARowThenPlayerWinsGame() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        assertTrue(game.isWonByPlayer(Game.PLAYER.A));
        assertEquals("PlayerA",game.getWinner());
    }

    @Test
    void givenPlayerBScoresFourPointsInARowThenPlayerWinsGame() {
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.B);
        assertTrue(game.isWonByPlayer(Game.PLAYER.B));
        assertEquals("PlayerB",game.getWinner());
    }

    @Test
    void givenPlayerScoresThreePointsInARowThenGameIsNotWon() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isWonByPlayer(Game.PLAYER.A));
    }

    @Test
    void givenGameIsUndecidedShouldThrowWinnerUnknown() {
        assertFalse(game.isWonByPlayer(Game.PLAYER.A));
        assertThrows(WinnerUnknown.class, game::getWinner);
    }

    @Test
    void givenPlayerScoresFourPointsInARowWhenScoredOnlyOneMoreThanOpponentThenGameIsNotWon() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isWonByPlayer(Game.PLAYER.A));
    }

    @Test
    void givenBothPlayersHave40GameIsADeuce() {
        assertFalse(game.isDeuce());
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isDeuce());
        game.increaseScore(Game.PLAYER.B);
        assertFalse(game.isDeuce());
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isDeuce());
        game.increaseScore(Game.PLAYER.B);
        assertFalse(game.isDeuce());
        game.increaseScore(Game.PLAYER.A);
        assertFalse(game.isDeuce());
        game.increaseScore(Game.PLAYER.B);
        assertTrue(game.isDeuce());
    }

    @Test
    void givenGameIsDeuceWhenPlayerAScoresPlayerAHasAdvantage() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        assertTrue(game.isDeuce());

        game.increaseScore(Game.PLAYER.A);
        assertTrue(game.hasAdvantage(Game.PLAYER.A));
    }

    @Test
    void givenGameIsDeuceThenNoPlayerHasAdvantage() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        assertTrue(game.isDeuce());
        assertFalse(game.hasAdvantage(Game.PLAYER.A));
        assertFalse(game.hasAdvantage(Game.PLAYER.B));
    }

    @Test
    void givenPlayerAHasAdvantageWhenPlayerBScoresThenGameIsDeuce() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        assertTrue(game.isDeuce());
    }

    @Test
    void givenPlayerAHadAdvantageWhenPlayerBScoredThenNoPlayerHasAdvantage() {
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        game.increaseScore(Game.PLAYER.A);
        game.increaseScore(Game.PLAYER.B);
        assertFalse(game.hasAdvantage(Game.PLAYER.A));
        assertFalse(game.hasAdvantage(Game.PLAYER.B));
    }
}
