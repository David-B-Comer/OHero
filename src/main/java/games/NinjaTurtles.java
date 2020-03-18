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
    private Hero currentPlayer;
    private int enemyHealth = 100;
    private Enemy footClan = new Enemy(1L, "Foot Clan Soldier", "Foot Clan Soldier");
    private double enemyMoveChoice = Math.ceil(Math.random()*3);
    private String playerName;
    private int playerHealth;
    private boolean alive = false;
    private int playerIntellect;
    private int playerEnergy;

//    private int playerHealth = currentPlayer.getStats().getHealth();
//    private int playerEnergy = currentPlayer.getStats().getEnergy();

    public NinjaTurtles() {
    }



    public void start(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);


        gameDisplay.printMessage("\nHeroes in a half shell. Turtle Power!");
        gameDisplay.printMessage("What did you want to do next.\nEnter 1 to Eat pizza: 2 to Train with Master Splinter: 3 to begin your hunt for Shredder.");

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

    public void checkGameHealth() {
        if (enemyHealth <= 0) {
            gameDisplay.printMessage("You kicked some bad guy butt!");
            alive = false;
        } else if (playerHealth <= 0) {
            gameDisplay.printMessage("Looks like you needed some more training to defeat " + footClan);
            alive = false;
        }
    }

    public void eatPizza(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);


        gameDisplay.printMessage("\nThat pizza hit the spot! Health and energy increased to " + playerHealth + " "+ playerEnergy );
        gameDisplay.printMessage("What did you want to do next.\nEnter 1 to Eat more pizza: 2 to Train with Master Splinter: 3 to begin your hunt for Shredder.");

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection) {
            case 1:
                gameDisplay.printMessage("Wise men say, 'forgiveness is divine, but never pay full price for late pizza'! ");
                eatPizza(characterCollection);
                characterCollection.getCharacterModelStorage().get(0).getStats().increaseHealth(5);
                playerHealth = characterCollection.getCharacterModelStorage().get(0).getStats().getHealth();
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

    public void trainWithSplinter(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);

        characterCollection.getCharacterModelStorage().get(0).getStats().increaseIntellect(5);
        characterCollection.getCharacterModelStorage().get(0).getStats().increaseDexterity(5);
        gameDisplay.printMessage("\nYou have chosen wisely young turtle dexterity and intellect have been improved. Intellect increased to ");
        gameDisplay.printMessage("What did you want to do next.\nEnter 1 to Eat more pizza: 2 to Train with Master Splinter: 3 to begin your hunt for Shredder.");

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection) {
            case 1:
                gameDisplay.printMessage("Wise men say, 'forgiveness is divine, but never pay full price for late pizza'! ");
                eatPizza(characterCollection);
                playerHealth = currentPlayer.getStats().getHealth();
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



    public void fightFootClan(HeroWarehouse characterCollection) {
            currentPlayer = characterCollection.getCharacterModelStorage().get(0);


            gameDisplay.printMessage("\nYou have chosen wisely young turtle dexterity and intellect have been increased. Intellect increased to ");
            gameDisplay.printMessage("What did you want to do next.\nEnter 1 to Eat more pizza: 2 to Train with Master Splinter: 3 to begin your hunt for Shredder.");

            int selection = Integer.parseInt(gameConsole.playerInput());

            switch (selection) {
                case 1:
                    gameDisplay.printMessage("Wise men say, 'forgiveness is divine, but never pay full price for late pizza'! ");
                    eatPizza(characterCollection);
                    playerHealth = currentPlayer.getStats().getHealth();
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
}

