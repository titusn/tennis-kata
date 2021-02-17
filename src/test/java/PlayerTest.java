import com.titusnachbauer.tennis.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player = new Player();

    public PlayerTest() {
    }

    @Test
    public void newPlayerShouldHaveScoreZero() {
        Assertions.assertEquals(0, player.getScore());
    }

    @Test
    void increaseScoreOnceShouldSetScoreTo15() {
        player.increaseScore();
        Assertions.assertEquals(15, player.getScore());
    }

    @Test
    void increaseScoreTwiceShouldSetScoreTo30() {
        player.increaseScore();
        player.increaseScore();
        Assertions.assertEquals(30, player.getScore());
    }

    @Test
    void increaseScoreThriceShouldSetScoreTo40() {
        player.increaseScore();
        player.increaseScore();
        player.increaseScore();
        Assertions.assertEquals(40, player.getScore());
    }

    @Test
    void scoreShouldNeverBeHigherThan40() {
        player.increaseScore();
        player.increaseScore();
        player.increaseScore();
        player.increaseScore();
        Assertions.assertEquals(40, player.getScore());
    }
}