package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.RandomStrategy;

public class Game {

  public static String AI_NAME = "HAL-9000";
  private int numRounds;
  private int currentRound = 1;
  private String namePlayer;

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    this.numRounds = numRounds;
    if (options.length > 0) {
      this.namePlayer = options[0];
      MessageCli.WELCOME_PLAYER.printMessage(namePlayer);
    }
  }

  public void play() {
    if (currentRound <= numRounds) {
      MessageCli.START_ROUND.printMessage(String.valueOf(currentRound), String.valueOf(numRounds));
    }

    if (currentRound % 3 == 0 && currentRound != 0) {
      boolean validInput = false;
      currentRound++;

      while (!validInput) {
        MessageCli.ASK_HUMAN_INPUT.printMessage();

        String input = Utils.scanner.nextLine().toUpperCase().trim();
        String[] inputs = input.split(" ");

        if (inputs.length != 2) {
          MessageCli.INVALID_HUMAN_INPUT.printMessage();
          continue;
        }

        Colour chosen = Colour.fromInput(inputs[0]);
        Colour guess = Colour.fromInput(inputs[1]);

        if (chosen == null || guess == null) {
          MessageCli.INVALID_HUMAN_INPUT.printMessage();
          continue;
        }

        validInput = true;
        MessageCli.PRINT_INFO_MOVE.printMessage(namePlayer, chosen.toString(), guess.toString());
        MessageCli.PRINT_POWER_COLOUR.printMessage(Colour.getRandomColourForPowerColour());
      }
    } else if (!(currentRound % 3 == 0)) {
      boolean validInput = false;
      currentRound++;

      while (!validInput) {
        MessageCli.ASK_HUMAN_INPUT.printMessage();

        String input = Utils.scanner.nextLine().toUpperCase().trim();
        String[] inputs = input.split(" ");

        if (inputs.length != 2) {
          MessageCli.INVALID_HUMAN_INPUT.printMessage();
          continue;
        }

        Colour chosen = Colour.fromInput(inputs[0]);
        Colour guess = Colour.fromInput(inputs[1]);

        if (chosen == null || guess == null) {
          MessageCli.INVALID_HUMAN_INPUT.printMessage();
          continue;
        }

        // Task 2 case 1
        RandomStrategy randomColourChoose = new RandomStrategy();
        String aiChoose = randomColourChoose.setStrategy().toString();
        RandomStrategy randomColourGuess = new RandomStrategy();
        String aiGuess = randomColourGuess.setStrategy().toString();
        MessageCli.PRINT_INFO_MOVE.printMessage(AI_NAME, aiChoose, aiGuess);

        validInput = true;
        MessageCli.PRINT_INFO_MOVE.printMessage(namePlayer, chosen.toString(), guess.toString());
      }
    }
  }

  public void showStats() {
  }
}
