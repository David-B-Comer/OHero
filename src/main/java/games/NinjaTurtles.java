package games;

import input.ConsoleManager;
import models.characters.Enemy;
import models.characters.Hero;
import models.utility.HeroWarehouse;
import output.Display;


public class NinjaTurtles {

    private Display gameDisplay = new Display();
    private ConsoleManager gameConsole = new ConsoleManager();
    // player
    private Hero currentPlayer;
    private String playerName;
    // player stats
    private int playerDexterity;
    private int playerEnergy;
    private int playerStrength;
    private int playerIntellect;
    private int playerHealth;
    // enemy
    private String enemyName;
    private Enemy footClan = new Enemy(1L, "Foot Clan Soldier", "Soldier");
    private Enemy bebop = new Enemy(2L, "Bebop", "Boss");
    private Enemy rockSteady = new Enemy(3L, "Rock Steady", "Boss");
    private Enemy shredder = new Enemy(4L, "Shredder", "Master");
    private int enemyHealth = 100;

    private boolean alive = false;
    private boolean inGame = true;


    public NinjaTurtles() {
    }


    public void checkGameHealth() {
        if (enemyHealth <= 0) {
            gameDisplay.printMessage("You kicked some bad guy butt!");
            alive = false;
            winGame();
        } else if (playerHealth <= 0) {
            gameDisplay.printMessage("Looks like you needed some more training to defeat " + enemyName);
            alive = false;
            gameOver();
        }
    }


    private void winGame() {
        gameDisplay.printMessage("You Won!");
        System.exit(0);
        inGame = false;
    }

    private void gameOver() {
        gameDisplay.printMessage("Game Over");
        System.exit(0);
        inGame = false;

    }

    public void playGame(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);
        playerName = currentPlayer.getName();
        playerHealth = currentPlayer.getStats().getHealth();
        alive = true;

        gameDisplay.printMessage("\nHeroes in a half shell. Turtle Power!");
        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);

    }

    public void eatPizza(HeroWarehouse characterCollection) {

        playerHealth = currentPlayer.getStats().increaseHealth(5);
        playerEnergy = currentPlayer.getStats().increaseEnergy(5);

        gameDisplay.printMessage("Pizza with no anchovies. If you put anchovies on it you're in big trouble.");
        gameDisplay.printMessage("\nThat pizza hit the spot! Health and energy increased to " + playerHealth + " "+ playerEnergy );
        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);
    }

    public void trainWithSplinter(HeroWarehouse characterCollection) {

        // increase player dexterity and intellect
        playerDexterity = currentPlayer.getStats().increaseDexterity(5);
        playerIntellect = currentPlayer.getStats().increaseIntellect(5);


        gameDisplay.printMessage("\nYou have chosen wisely young turtle dexterity and intellect have been improved. Intellect increased to " + playerDexterity + " " + playerIntellect);
        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);
    }



    public void fightFootClan(HeroWarehouse characterCollection) {
// if win
        playerStrength = currentPlayer.getStats().increaseStrength(5);
        playerEnergy = currentPlayer.getStats().increaseEnergy(5);
// if lose
        playerStrength = currentPlayer.getStats().increaseStrength(5);
        playerEnergy = currentPlayer.getStats().increaseEnergy(5);


        gameDisplay.printMessage("\n Looks like we are in for a fight. Strength has been increased, energy decreased " + playerStrength + " " + playerEnergy);

        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);
        checkGameHealth();

    }

    public void fightBoss(HeroWarehouse characterCollection) {

        playerStrength = currentPlayer.getStats().increaseStrength(5);
        playerEnergy = currentPlayer.getStats().decreaseEnergy(5);

        gameDisplay.printMessage("\n Looks like we are in for a fight. Strength has been increased, energy decreased " + playerStrength + " " + playerEnergy);
        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);
        checkGameHealth();


    }

    public void fightShredder(HeroWarehouse characterCollection) {

        alive = true;
        while (inGame) {

            gameDisplay.printMessage(shredder.getName() + " has " + enemyHealth + " health remaining.");
            gameDisplay.printMessage(playerName + " has " + playerHealth + " health remaining.");

            gameDisplay.printMessage("What would you like to do? (1)punch (2)kick (3)special attack: ");
            String playerFightChoice = gameConsole.playerInput();



            switch (playerFightChoice) {
                case "1":
                    fightPunchOptions();
                    checkGameHealth();
                    break;
                case "2":
                    fightKickOptions();
                    checkGameHealth();
                    break;
                case "3":
                    fightSpecialAttackOptions();
                    checkGameHealth();
                    break;
                default:
                    gameDisplay.printMessage("PLEASE ENTER 1, 2, OR 3");
                    break;

            }
        }
    }

    public void fightPunchOptions() {
        int enemyChoice = (int)(Math.random() * 3);

        switch ((int) enemyChoice) {
            case 1:
                gameDisplay.printMessage(shredder.getName() + " side steps your punch." + shredder.getName() + " is faster than you thought");
                break;
            case 2:
                gameDisplay.printMessage(playerName + " lands a solid punch to " + shredder.getName() + "'s ribs.");
                enemyHealth -= 10;
                break;
            case 3:
                gameDisplay.printMessage(shredder.getName() + " sidesteps and counters with kick into " + playerName + ".");
                playerHealth -= 10;
                break;
        }
    }

    public void fightKickOptions() {
        int enemyChoice = (int)(Math.random() * 3);
        switch ((int) enemyChoice) {
            case 1:
                gameDisplay.printMessage(shredder.getName() + " dances by kick.");
                break;
            case 2:
                gameDisplay.printMessage(playerName + " your kick doubles " + shredder.getName() + " over.");
                enemyHealth -= 10;
                break;
            case 3:
                gameDisplay.printMessage(shredder.getName() + " jumps back from your kick. And counters with a punch to " + playerName + "'s ribs.'");
                playerHealth -= 10;
                break;

        }

    }

    public void fightSpecialAttackOptions() {
        int enemyChoice = (int)(Math.random() * 3);
        switch ((int) enemyChoice) {
            case 1:
                gameDisplay.printMessage(shredder.getName() + " laughs at your missed knee attack.");
                break;
            case 2:
                gameDisplay.printMessage(playerName + " your knee doubles " + shredder.getName() + " over.");
                enemyHealth -= 10;
                break;
            case 3:
                gameDisplay.printMessage(shredder.getName() + " evades your knee and lands a glancing blow to your face.");
                playerHealth -= 10;
                break;

        }
    }




    public void turtlesNextPrompt(HeroWarehouse characterCollection) {
        gameDisplay.printMessage("What did you want to do next?\nEnter 1 to Eat pizza: 2 to Train with Master Splinter: 3 to begin your hunt for Shredder.");
    }

    public void turtlesChoices(HeroWarehouse characterCollection) {

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection) {
            case 1:
                gameDisplay.printMessage("Wise men say, 'forgiveness is divine, but never pay full price for late pizza'! ");
                eatPizza(characterCollection);
                break;
            case 2:
                gameDisplay.printMessage("My Master Yoshi's first rule was:  Possess the right thinking.  Only then can one receive the gifts of strength, knowledge, and peace!");
                trainWithSplinter(characterCollection);
                break;
            case 3:
                gameDisplay.printMessage("Cowabunga Dudes! Lets kick some bad guy butt!");
                fightShredder(characterCollection);
                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1, 2, OR 3");
                break;
        }
    }
}