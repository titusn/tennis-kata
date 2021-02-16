import com.titusnachbauer.tennis.Game;
import com.titusnachbauer.tennis.NotEnoughPlayers;
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
    void whenPlayerHasScore40AndScoresPointThenPlayerWinsGame() {
        Player[] players = new Player[]{new Player(), new Player()};
        Game game = new Game(players);
        players[0].increaseScore();
        players[0].increaseScore();
        players[0].increaseScore();
        players[0].increaseScore();
        assertTrue(game.isWonBy(players[0]));
    }

    @Test
    void creatingGameWithOnePlayerShouldThrowNotEnoughPlayers() {
        Player[] players = new Player[]{new Player()};
        assertThrows(NotEnoughPlayers.class, () -> {
            Game game = new Game(players);
        });
    }

}
