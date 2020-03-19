package Games;

import org.junit.jupiter.api.Test;

class ShaolimWarriorTest {


    private static int enemyHealth = 100;
    private static int playerHealth = 100;
    private static boolean alive = false;





    @Test
    void checkGameHealth(int playerHealth) {

        if(enemyHealth <= 0)
            alive = false;
        else if (ShaolimWarriorTest.playerHealth <= 0)
            alive = false;

        checkGameHealth(playerHealth);


    }

    @Test
    void shaolinWarriorGameStart() {
    }

    @Test
    void fightTime() {
        alive = true;
        //String fight = null;
    }

    @Test
    void playerDecision() {

    }
}