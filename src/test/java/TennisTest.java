import com.titusnachbauer.tennis.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TennisTest {
    Player player = new Player();

    @Test
    public void newPlayerShouldHaveScoreZero() {
        assertEquals(0, player.getScore());
    }

    @Test void increaseScoreOnceShouldSetScoreTo15() {
        player.increaseScore();
        assertEquals(15, player.getScore());
    }

    @Test void increaseScoreTwiceShouldSetScoreTo30() {
        player.increaseScore();
        player.increaseScore();
        assertEquals(30, player.getScore());
    }

}
