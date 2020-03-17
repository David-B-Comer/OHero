package games;

import input.ConsoleManager;
import models.characters.Enemy;
import models.characters.Hero;
import models.utility.HeroWarehouse;
import output.Display;

import java.util.Timer;

public class Blizzard {

    private static Display gameDisplay = new Display();
    private static ConsoleManager gameConsole = new ConsoleManager();
    private static Hero currentPlayer;
    private static Enemy tree = new Enemy(100L, "BigGreen", "Tree");
    private static Timer timer;
    private static Integer playerHealth;
    private static Boolean alive = false;
    private double enemyMoveChoice = Math.ceil(Math.random() * 3);

    private Blizzard() {
    }

    public static void start(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);
        timer = new Timer();

        gameDisplay.printMessage("\nYou've entered the Teradome.");
        gameDisplay.printMessage("Are you a Novice, Advanced, or Expert Challenger.\nEnter 1 for Novice : 2 for Advanced: 3 for Expert.");

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection) {
            case 1:
                gameDisplay.printMessage("You've chosen Novice!");
                bunnyHill(characterCollection);
                break;
            case 2:
                gameDisplay.printMessage("You've chosen Advanced!");
                blackDiamond(characterCollection);
                break;
            case 3:
                gameDisplay.printMessage("You've chosen Expert!");

                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1,2, OR 3");
                break;
        }
    }
    public static void checkGameHealth() {
        playerHealth = currentPlayer.getStats().getHealth();
        if (playerHealth <= 0) {
            gameDisplay.printMessage("Your Skiing skills were tested and you did not survive the BLIZZARD, " + currentPlayer + ".\n" + "This Game is over!");
            alive = false;
        }
    }
    public static void bunnyHill(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);

        gameDisplay.printMessage("\nThis must be your first time, watch out for the kiddies on the Bunny Hill " + currentPlayer.getName() + "! " + "\nTry to dodge the cones and make your way down to the finish line! " );

        int selection = Integer.parseInt(gameConsole.playerInput());
        gameDisplay.printMessage("Are you a Novice, Advanced, or Expert Challenger.\nEnter 1 for Novice : 2 for Advanced: 3 for Expert.");

        switch (selection) {
            case 1:
                gameDisplay.printMessage(" finish line! ");
                bunnyHill(characterCollection);
                playerHealth = currentPlayer.getStats().getHealth();
                break;
            case 2:
                gameDisplay.printMessage(" and peace!");
                blackDiamond(characterCollection);
                break;
            case 3:
                gameDisplay.printMessage("some bad guy butt!");
                greatScott(characterCollection);
                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1, 2, OR 3");
                break;

        }
    }
    private static void blackDiamond(HeroWarehouse characterCollection) {

        currentPlayer = characterCollection.getCharacterModelStorage().get(0);

        gameDisplay.printMessage("\nThis must be your first time, watch out for the kiddies on the Bunny Hill " + currentPlayer.getName() + "! ");

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection) {
            case 1:
                gameDisplay.printMessage("Try to dodge the cones and make your way down to the finish line! ");
                bunnyHill(characterCollection);
                playerHealth = currentPlayer.getStats().getHealth();
                break;
            case 2:
                gameDisplay.printMessage("My Master Yoshi's first rule was:  Possess the right thinking.  Only then can one receive the gifts of strength, knowledge, and peace!");
                blackDiamond(characterCollection);
                break;
            case 3:
                gameDisplay.printMessage("Cowabunga Dudes! Lets kick some bad guy butt!");
                greatScott(characterCollection);
                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1, 2, OR 3");
                break;
        }
    }

    private static void greatScott(HeroWarehouse characterCollection) {

        currentPlayer = characterCollection.getCharacterModelStorage().get(0);

        gameDisplay.printMessage("\nThis must be your first time, watch out for the kiddies on the Bunny Hill " + currentPlayer.getName() + "! ");

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection) {
            case 1:
                gameDisplay.printMessage("Try to dodge the cones and make your way down to the finish line! ");
                bunnyHill(characterCollection);
                playerHealth = currentPlayer.getStats().getHealth();
                break;
            case 2:
                gameDisplay.printMessage("My Master Yoshi's first rule was:  Possess the right thinking.  Only then can one receive the gifts of strength, knowledge, and peace!");
                blackDiamond(characterCollection);
                break;
            case 3:
                gameDisplay.printMessage("Cowabunga Dudes! Lets kick some bad guy butt!");
                greatScott(characterCollection);
                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1, 2, OR 3");
                break;
        }

    }
}
