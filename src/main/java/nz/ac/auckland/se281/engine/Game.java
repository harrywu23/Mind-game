package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.AIStrategy;
import nz.ac.auckland.se281.model.Colour;
import nz.ac.auckland.se281.model.DifficultyPicker;
import nz.ac.auckland.se281.cli.Utils;

public class Game {

  public static String AI_NAME = "HAL-9000";
  private int numRounds;
  private int currentRound = 1;
  private String namePlayer;
  private Difficulty gameDifficulty;
  private int aiRoundPoints;
  private int playerRoundPoints;

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    this.numRounds = numRounds;
    this.gameDifficulty = difficulty;
    this.currentRound = 1;
    if (options.length > 0) {
      this.namePlayer = options[0];
      MessageCli.WELCOME_PLAYER.printMessage(namePlayer);
    }
  }

  public void play() {
    if (currentRound > numRounds) {
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(currentRound), String.valueOf(numRounds));

    if (currentRound % 3 == 0 && currentRound != 0)

    {
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
        AIStrategy strategy = DifficultyPicker.chooseDifficulty(gameDifficulty.toString());
        Colour aiChoose = strategy.setStrategy(); // The AI's chosen colour
        Colour aiGuess = strategy.setStrategy(); // The AI's guessed colour
        MessageCli.PRINT_INFO_MOVE.printMessage(AI_NAME, aiChoose.toString(), aiGuess.toString());

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
        AIStrategy strategy = DifficultyPicker.chooseDifficulty(gameDifficulty.toString());
        Colour aiChoose = strategy.setStrategy(); // The AI's chosen colour
        Colour aiGuess = strategy.setStrategy(); // The AI's guessed colour
        MessageCli.PRINT_INFO_MOVE.printMessage(AI_NAME, aiChoose.toString(), aiGuess.toString());

        validInput = true;
        MessageCli.PRINT_INFO_MOVE.printMessage(namePlayer, chosen.toString(), guess.toString());

        // point scoring logic task 2 test 4 - test 7
        if (aiGuess.toString().equals(chosen.toString()) && guess.toString().equals(aiChoose.toString())) {
          playerRoundPoints = 1;
          aiRoundPoints = 1;
        } else if (guess.toString().equals(aiChoose.toString())) {
          aiRoundPoints = 0;
          playerRoundPoints = 1;
        } else if (aiGuess.toString().equals(chosen.toString())) {
          aiRoundPoints = 1;
          playerRoundPoints = 0;
        }

        MessageCli.PRINT_OUTCOME_ROUND.printMessage(namePlayer, String.valueOf(playerRoundPoints));
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(AI_NAME, String.valueOf(aiRoundPoints));
      }
    }
  }

  public void showStats() {
  }

  public Difficulty getGameDifficulty() {
    return this.gameDifficulty;
  }
}
