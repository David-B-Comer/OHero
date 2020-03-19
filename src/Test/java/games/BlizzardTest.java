package games;

import org.junit.Assert;
import org.junit.Test;

public class BlizzardTest {

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