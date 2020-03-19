
package games;

import input.ConsoleManager;
import models.characters.Enemy;
import models.characters.Hero;
import models.utility.HeroWarehouse;
import output.Display;
import java.util.Timer;

public class Avalanche {

    private Display gameDisplay = new Display();
    private ConsoleManager gameConsole = new ConsoleManager();
    private Hero currentPlayer;
    // private Enemy tree = new Enemy(100L, "BigGreen", "Tree");
    private Timer timer;
    private Integer playerHealth;
    private Boolean alive = false;
    private double kiddieChoice = Math.ceil(Math.random() * 3);

    public Avalanche() {
    }

    public void start(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);
        timer = new Timer();

        gameDisplay.printMessage("\nWelcome to Live or Die Ski Resort.");
        gameDisplay.printMessage("Are you a Novice, Advanced, or Expert Challenger?\nEnter 1 for Novice : 2 for Advanced: 3 for Expert.");

        int selection = Integer.parseInt(gameConsole.playerInput());

        switch (selection) {
            case 1:
                gameDisplay.printMessage("You've chosen Novice!");
                bunnyHill(characterCollection);
                break;
            case 2:
                gameDisplay.printMessage("You've chosen Advanced!");
                //blackDiamond(characterCollection);
                break;
            case 3:
                gameDisplay.printMessage("You've chosen Expert!");

                break;
            default:
                gameDisplay.printMessage("PLEASE ENTER 1,2, OR 3");
                break;
        }
    }

    public void checkGameHealth() {
        playerHealth = currentPlayer.getStats().getHealth();
        if (playerHealth <= 0) {
            gameDisplay.printMessage("Your Survival skills were tested and you did not survive the AVALANCHE!, " + currentPlayer + ".\n" + "This Game is over!");
            alive = false;
        }
    }

    public void bunnyHill(HeroWarehouse characterCollection) {
        currentPlayer = characterCollection.getCharacterModelStorage().get(0);

        gameDisplay.printMessage("\nThis must be your first time, watch out for the kiddies on the Bunny Hill " + currentPlayer.getName() + "! " + "\nTry to dodge the kiddies and make your way down to the finish line! ");
        gameDisplay.printMessage("R to Dodge Right: " + "L to Dodge Left:" + " B to Jump:" + "   Don't Hurt'em! " + currentPlayer.getName());
        // int selection = Integer.parseInt(gameConsole.playerInput());
        // gameDisplay.printMessage("Are you a Novice, Advanced, or Expert Challenger.\nEnter 1 for Novice : 2 for Advanced: 3 for Expert.");


        //int NoviceSelection = Integer.parseInt(gameConsole.playerInput());

        String noviceSelection = gameConsole.playerInput();
        double kiddieChoice = Math.ceil(Math.random() * 3);
        checkGameHealth();

        switch (noviceSelection.toUpperCase()) {
            case "R":
                switch ((int) kiddieChoice) {
                    case 1:
                        gameDisplay.printMessage(" HEY, WATCH IT! " + currentPlayer.getName());
                        bunnyHill(characterCollection);
                        playerHealth = currentPlayer.getStats().getHealth();
                        checkGameHealth();
                        break;
                    case 2:
                        gameDisplay.printMessage(" LOOK WHERE YOU'RE GOING!");
                        // blackDiamond(characterCollection);
                        playerHealth = currentPlayer.getStats().getHealth();
                        checkGameHealth();
                        break;
                    case 3:
                        gameDisplay.printMessage("OUCH! MOMMY!");
                        // greatScott(characterCollection);
                        playerHealth = currentPlayer.getStats().getHealth();
                        checkGameHealth();
                        break;
                    default:
                        gameDisplay.printMessage("PLEASE ENTER R, L, OR B");
                        break;

                }

                // switch (NoviceSelection) {
            case "L":
                switch ((int) kiddieChoice) {
                    case 1:
                        gameDisplay.printMessage("SMASH! ");
                        bunnyHill(characterCollection);
                        playerHealth = currentPlayer.getStats().getHealth();
                        checkGameHealth();
                        break;
                    case 2:
                        gameDisplay.printMessage("CRUNCH!");
                        //blackDiamond(characterCollection);
                        playerHealth = currentPlayer.getStats().getHealth();
                        checkGameHealth();
                        break;
                    case 3:
                        gameDisplay.printMessage("Boink!");
                        // greatScott(characterCollection);
                        playerHealth = currentPlayer.getStats().getHealth();
                        checkGameHealth();
                        break;
                    default:
                        gameDisplay.printMessage("PLEASE ENTER R, L, OR B");
                        break;
                }
        }
        //
//            switch (NoviceSelection) {
//                    case "B":
//                case 1:
//                    gameDisplay.printMessage("Try to dodge the cones and make your way down to the finish line! ");
//                    bunnyHill(characterCollection);
//                    playerHealth = currentPlayer.getStats().getHealth();
//                    break;
//                case 2:
//                    gameDisplay.printMessage("My Master Yoshi's first rule was:  Possess the right thinking.  Only then can one receive the gifts of strength, knowledge, and peace!");
//                    blackDiamond(characterCollection);
//                    break;
//                case 3:
//                    gameDisplay.printMessage("Cowabunga Dudes! Lets kick some bad guy butt!");
//                    greatScott(characterCollection);
//                    break;
//                default:
//                    gameDisplay.printMessage("PLEASE ENTER 1, 2, OR 3");
//                    break;
//            }
//
//        }
//    }

    }
}




//    private static void blackDiamond (HeroWarehouse characterCollection){
//
//        currentPlayer = characterCollection.getCharacterModelStorage().get(0);
//
//        gameDisplay.printMessage("\nThis must be your first time, watch out for the kiddies on the Bunny Hill " + currentPlayer.getName() + "! ");
//
//        int selection = Integer.parseInt(gameConsole.playerInput());

//        }
//        }
//
//        private static void greatScott (HeroWarehouse characterCollection){
//
//            currentPlayer = characterCollection.getCharacterModelStorage().get(0);
//
//            gameDisplay.printMessage("\nThis must be your first time, watch out for the kiddies on the Bunny Hill " + currentPlayer.getName() + "! ");
//
//            int selection = Integer.parseInt(gameConsole.playerInput());