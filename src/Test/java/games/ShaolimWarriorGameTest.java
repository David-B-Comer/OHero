package games;

import models.characters.Hero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import output.Display;

import static org.junit.jupiter.api.Assertions.*;

class ShaolinWarriorGameTest {


    private static int enemyHealth = 100;
    private static int playerHealth = 100;
    private static boolean alive = false;





    @Test
    public void checkGameHealth(int playerHealth) {

        if(enemyHealth <= 0)
            alive = false;
        else if (ShaolinWarriorGameTest.playerHealth <= 0)
            alive = false;

        checkGameHealth(playerHealth);


    }

    @Test
    public void shaolinWarriorGameStart() {
    }

    @Test
    public void fightTime() {
        alive = true;
        //String fight = null;
    }

    @Test
    public void enemyDefeat(){
        // dexterity increase
        //slight health increase
    }

    @Test
    public void playerDecision() {
        //method for multiple choice

    }

    @Test
    public void pickUpItem(){}

    @Test
    public void eatDrink(){
        //eat or drink to restore health
        //set + health per item
    }

    @Test
    public void talk(){
        //speak to dying or non fighting characters
        //increase intellect
    }

    @Test
    public void winGame(){}




}