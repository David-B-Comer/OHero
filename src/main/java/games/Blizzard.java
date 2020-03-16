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
    private static Enemy tree;
    private static Timer timer;
    private static Integer playerHealth;
    private static Boolean alive = false;

    private Blizzard() {
    }

    public static void start(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);
        timer = new Timer();

        gameDisplay.printMessage("\nYou've entered the Teradome.");
        gameDisplay.printMessage("Are you a Beginner, Novice, or Advanced Challenger.\nEnter 1 for Beginner : 2 for Novice: 3 for Advanced.");

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection){
            case 1:
                gameDisplay.printMessage("You've chosen Beginner!");
                break;
            case 2:
                gameDisplay.printMessage("You've chosen Novice!");
                break;
            case 3:
                gameDisplay.printMessage("You've chosen Advanced!");
                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1,2, OR 3");
                break;
        }
    }
            public void checkGameHealth(){
                playerHealth = currentPlayer.getStats().getHealth();
                if (playerHealth <= 0) {
            gameDisplay.printMessage("Your training was tested and you did not survive the BLIZZARD, " + currentPlayer + ".\n" + "This Game is over!");
            alive = false;
        }
    }
}
