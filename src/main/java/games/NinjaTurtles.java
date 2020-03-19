package games;

import input.ConsoleManager;
import models.characters.Enemy;
import models.characters.Hero;
import models.utility.HeroWarehouse;
import models.utility.Stats;
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
    private Enemy footClan = new Enemy(1L, "Foot Clan Soldier", "Foot Clan Soldier");
    private int enemyHealth = 100;
    private double enemyMoveChoice = Math.ceil(Math.random()*3);

    private boolean alive = false;
    private boolean inGame = true;



    public NinjaTurtles() {
    }


    public void checkGameHealth() {
        if (enemyHealth <= 0) {
            gameDisplay.printMessage("You kicked some bad guy butt!");
            alive = false;
        } else if (playerHealth <= 0) {
            gameDisplay.printMessage("Looks like you needed some more training to defeat " + footClan);
            alive = false;
            gameOver();
        }
    }

    public void start(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);
        playerName = currentPlayer.getName();
        playerHealth = currentPlayer.getStats().getHealth();



        alive = true;
        while (inGame) {

            gameDisplay.printMessage("\nHeroes in a half shell. Turtle Power!");
            turtlesNextPrompt(characterCollection);
            turtlesChoices(characterCollection);
        }
    }

    public void eatPizza(HeroWarehouse characterCollection) {

        playerHealth = characterCollection.getCharacterModelStorage().get(0).getStats().increaseHealth(5);
        playerEnergy = characterCollection.getCharacterModelStorage().get(0).getStats().increaseEnergy(5);

        gameDisplay.printMessage("\nThat pizza hit the spot! Health and energy increased to " + playerHealth + " "+ playerEnergy );
        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);
    }

    public void trainWithSplinter(HeroWarehouse characterCollection) {

        // increase player dexterity and intellect

        playerDexterity = characterCollection.getCharacterModelStorage().get(0).getStats().increaseDexterity(5);
        playerIntellect = characterCollection.getCharacterModelStorage().get(0).getStats().increaseIntellect(5);


        gameDisplay.printMessage("\nYou have chosen wisely young turtle dexterity and intellect have been improved. Intellect increased to " + playerDexterity + " " + playerIntellect);
        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);
    }



    public void fightFootClan(HeroWarehouse characterCollection) {

        playerStrength = characterCollection.getCharacterModelStorage().get(0).getStats().increaseStrength(5);
        playerEnergy = characterCollection.getCharacterModelStorage().get(0).getStats().decreaseEnergy(5);

        gameDisplay.printMessage("\n Strength increased, energy decreased " + playerStrength + " " + playerEnergy);
        turtlesNextPrompt(characterCollection);
        turtlesChoices(characterCollection);

    }

    public void turtlesNextPrompt(HeroWarehouse characterCollection) {
        gameDisplay.printMessage("What did you want to do next.\nEnter 1 to Eat more pizza: 2 to Train with Master Splinter: 3 to begin your hunt for Shredder.");
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
                fightFootClan(characterCollection);
                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1, 2, OR 3");
                break;
        }
    }
    private void gameOver() {
        gameDisplay.printMessage("Game Over");
        System.exit(0);
        inGame = false;

    }

}