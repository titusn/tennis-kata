import com.titusnachbauer.tennis.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TennisTest {
    @Test
    public void newPlayerShouldHaveScoreZero() {
        Player player = new Player();
        assertEquals(0, player.getScore());
    }

    @Test void increaseScoreOnceShouldSetScoreTo15() {
        Player player = new Player();
        player.increaseScore();
        assertEquals(15, player.getScore());
    }
}
