package games;

import input.ConsoleManager;
import models.characters.Enemy;
import models.characters.Hero;
import models.utility.HeroWarehouse;
import output.Display;


public class NinjaTurtles {

    private static Display gameDisplay = new Display();
    private static ConsoleManager gameConsole = new ConsoleManager();
    private static Hero currentPlayer;
    private static  int enemyHealth = 100;
    private static Enemy footClan = new Enemy(1L, "Foot Clan Soldier", "Foot Clan Soldier");
    private static double enemyMoveChoice = Math.ceil(Math.random()*3);
    private static String playerName;
    private static int playerHealth;
    private static boolean alive = false;
//    private static int playerHealth = currentPlayer.getStats().getHealth();
//    private static int playerEnergy = currentPlayer.getStats().getEnergy();

    private NinjaTurtles() {
    }


    public static void start(HeroWarehouse characterCollection) {
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

    public static void checkGameHealth() {
        if (enemyHealth <= 0) {
            gameDisplay.printMessage("You kicked some bad guy butt!");
            alive = false;
        } else if (playerHealth <= 0) {
            gameDisplay.printMessage("Looks like you needed some more training to defeat " + footClan);
            alive = false;
        }
    }

    public static void eatPizza(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);


        gameDisplay.printMessage("\nThat pizza hit the spot! Health and energy increased to " + playerHealth + " " );
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

    public static void trainWithSplinter(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);


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

    public static void fightFootClan(HeroWarehouse characterCollection) {
            currentPlayer = characterCollection.getCharacterModelStorage().get(0);


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
}

