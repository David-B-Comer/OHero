package Games;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AvalancheTest {

    private static int playerHealth = 100;
    private static boolean alive = false;

    @Test
    public void start() {
    }

    @Test
    void checkGameHealth() {
        if(playerHealth <= 0)
            alive = false;
        Assert.assertTrue((alive = true));
    }

    @Test
    void fightTime() {
        alive = true;
    }
}