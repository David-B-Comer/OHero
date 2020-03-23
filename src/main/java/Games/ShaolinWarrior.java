package games;

import input.ConsoleManager;
import models.characters.Enemy;
import models.characters.Hero;
import models.items.Item;
import models.utility.HeroWarehouse;
import output.Display;

public class ShaolinWarrior {
    private int enemyHealth = 0;
    private Enemy badGuy = new Enemy(12345L, "Bolo", "lackey");
    private double enemyMoveChoice = Math.ceil(Math.random() * 3);
    private String playerName;
    private int playerHealth;
    private boolean alive = true;
    private Display gameDisplay = new Display();
    private Item scroll;
    private ConsoleManager gameConsole = new ConsoleManager();
    private Hero currentPlayer;
    private boolean inGame = true;
    private int playerDex;


    public ShaolinWarrior() {

    }

    /**
     * method for deaths in game
     * added gameOver() to player condition to stop game
     */

    public void checkGameHealth() {
        //playerHealth = currentPlayer.getStats().getHealth();
        if (enemyHealth <= 0) {
            gameDisplay.printMessage("Your training was tested and you chi is strong, " + playerName + " you have defeated " + badGuy.getName() + ".\n" + "This battle is over but there are more who must answer for your masters betrayal ");
            alive = false;
            pickUpScroll();
        } else if (playerHealth <= 0) {
            gameDisplay.printMessage(playerName + " ,you have failed your master. " + badGuy.getName() + "'s chi was stronger. Master Huang betrayal will not be avenged by you.");
            alive = false;
            gameOver();

        }

    }

    public void start(HeroWarehouse characterCollection) {
        /**
         * games as on as long as player is alive
         */
            currentPlayer = characterCollection.getCharacterModelStorage().get(0);
            playerName = currentPlayer.getName();
            playerHealth = currentPlayer.getStats().getHealth();
            alive = true;
            inGame = true;
            gameDisplay.printMessage("There has been a travesty at the Shoalin monastery. \n" +
                    "Your master Huang Zongxi has been found slain. \n" +
                    "All signs show that it was the disciples of Wang Shichong. \n" +
                    "You have traveled to Kāimíng to exact your revenge for the the honor of your master \n" +
                    "You enter the enemy's dojo. " + badGuy.getName() + " is knealing in meditation. \n" +
                    "He raises his head. You lock eyes and he rises to fight you.");
           fight();
    }

    public void fight() {
        enemyHealth = 20;
        alive =true;
        while(inGame) {


        gameDisplay.printMessage(badGuy.getName() + " has " + enemyHealth + " health remaining.");
        gameDisplay.printMessage(playerName + " has " + playerHealth + " health remaining.");

        gameDisplay.printMessage("What would you like to do? (a)punch (b)kick (c)knee strike: ");
        String playerFightChoice = gameConsole.playerInput();

        double enemyChoice = Math.ceil(Math.random() * 3);
        checkGameHealth();
        /**
         * switch statement takes the players choices a,b,c and
         * compares to random generated enemy choice should
         * create nine different occurrences of responses
         */

        switch (playerFightChoice) {
            case "a":
                switch ((int) enemyChoice) {
                    case 1:
                        gameDisplay.printMessage(badGuy.getName() + " side steps your punch." + badGuy.getName() + " is faster than you thought");
                        checkGameHealth();
                        break;
                    case 2:
                        gameDisplay.printMessage(playerName + " lands a solid punch to " + badGuy.getName() + "'s ribs.");
                        enemyHealth -= 10;
                        checkGameHealth();
                        break;
                    case 3:
                        gameDisplay.printMessage(badGuy.getName() + " sidesteps and counters with kick into " + playerName + ".");
                        playerHealth -= 10;
                        checkGameHealth();
                        break;
                }
                break;
            //enemyChoice = Math.ceil(Math.random() * 3);
            case "b":
                switch ((int) enemyChoice) {
                    case 1:
                        gameDisplay.printMessage(badGuy.getName() + " dances by kick.");
                        checkGameHealth();
                        break;
                    case 2:
                        gameDisplay.printMessage(playerName + " your kick doubles " + badGuy.getName() + " over.");
                        enemyHealth -= 10;
                        checkGameHealth();
                        break;
                    case 3:
                        gameDisplay.printMessage(badGuy.getName() + " jumps back from your kick. And counters with a punch to " + playerName + "'s ribs.'");
                        playerHealth -= 10;
                        checkGameHealth();
                        break;
                }
                break;
            // enemyChoice = Math.ceil(Math.random() * 3);
            case "c":
                switch ((int) enemyChoice) {
                    case 1:
                        gameDisplay.printMessage(badGuy.getName() + " laughs at your missed knee attack.");
                        checkGameHealth();
                        break;
                    case 2:
                        gameDisplay.printMessage(playerName + " your knee doubles " + badGuy.getName() + " over.");
                        enemyHealth -= 10;
                        checkGameHealth();
                        break;
                    case 3:
                        gameDisplay.printMessage(badGuy.getName() + " evades your knee and lands a glancing blow to your face.");
                        playerHealth -= 10;
                        checkGameHealth();
                        break;
                    default:
                        gameDisplay.printMessage("PLEASE ENTER a, b, OR c");
                        break;
                }
                break;

        }
    }
}
        /**
         * If player survives first fight
         * pick up item method
         */
        public void pickUpScroll() {
        while (inGame) {
            gameDisplay.printMessage("There is a scroll on the ground. Do you want; a) to pick it up or b) go to the next room");

            String playerFightChoice = gameConsole.playerInput();
            if (playerFightChoice.equals("a")) {
                gameDisplay.printMessage("It is a message from Wang Shichong. \n" +
                        "It's a warning to his clan that retribution may be sought for the death of your master Huang. \n" +
                        "They are aware that you might be coming. You must practice stealth!");
            } else if (playerFightChoice.equals("b"))
                gameDisplay.printMessage("You rush into a room full of soldiers. This choice might have been rash!");
                gameOver();
            break;
        }
        }

    /**
     * made to stop game upon player death
     * added to check health method
     */

    private void gameOver() {
        gameDisplay.printMessage("Game Over");
        System.exit(0);
        inGame = false;
    }




}

