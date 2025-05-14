package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.AIStrategy;
import nz.ac.auckland.se281.model.Colour;
//import nz.ac.auckland.se281.model.DifficultyFactory;
import nz.ac.auckland.se281.model.RandomStrategy;
import nz.ac.auckland.se281.cli.Utils;
//import nz.ac.auckland.se281.model.AIDifficulty;

public class Game {

  public static String AI_NAME = "HAL-9000";
  private int numRounds;
  private int currentRound = 1;
  private Difficulty gameDifficulty;
  private int aiRoundPoints;
  private int playerRoundPoints;
  private Colour powerColour;
  private Player player;
  private Colour chosenPlayerColour;

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    this.numRounds = numRounds;
    this.gameDifficulty = difficulty;
    this.currentRound = 1;

    // task 1 case 1
    if (options.length > 0) {
      String playerName = options[0];
      player = new Player(playerName);
      MessageCli.WELCOME_PLAYER.printMessage(playerName);

    }
  }

  public void play() {

    if (currentRound > numRounds) {
      return;
    }

    AIStrategy strategy = new RandomStrategy();
    MessageCli.START_ROUND.printMessage(String.valueOf(currentRound), String.valueOf(numRounds));

    // if power round
    if (currentRound % 3 == 0 && currentRound != 0)

    {
      boolean validInput = false;

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
        this.chosenPlayerColour = chosen;

        if (chosen == null || guess == null) {
          MessageCli.INVALID_HUMAN_INPUT.printMessage();
          continue;
        }

        // Task 2 case 1
        Colour aiChoose = strategy.chooseColour(); // The AI's chosen colour
        Colour aiGuess = strategy.guessColour(); // The AI's guessed colour

        MessageCli.PRINT_INFO_MOVE.printMessage(AI_NAME, aiChoose, aiGuess);

        validInput = true;
        MessageCli.PRINT_INFO_MOVE.printMessage(player.getName(), chosen, guess);
        this.powerColour = Colour.getRandomColourForPowerColour();
        MessageCli.PRINT_POWER_COLOUR.printMessage(powerColour);

        // point scoring logic task 2 test 4 - test 7

        // resetting points to 0 each round
        playerRoundPoints = 0;
        aiRoundPoints = 0;

        // Player guessing AI's colour
        if (guess.equals(aiChoose)) {
          playerRoundPoints += 1;
          if (guess.equals(powerColour)) {
            playerRoundPoints += 2; // Bonus for guessing power colour (task 8 - 10)
          }
        }

        // AI guessing Player's colour
        if (aiGuess.equals(chosen)) {
          aiRoundPoints += 1;
          if (aiGuess.equals(powerColour)) {
            aiRoundPoints += 2; // Bonus for guessing power colour (task 8 - 10)
          }
        }

        MessageCli.PRINT_OUTCOME_ROUND.printMessage(player.getName(), String.valueOf(playerRoundPoints));
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(AI_NAME, String.valueOf(aiRoundPoints));
      }

      // not power round
    } else if (!(currentRound % 3 == 0)) {
      boolean validInput = false;

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
        this.chosenPlayerColour = chosen;

        if (chosen == null || guess == null) {
          MessageCli.INVALID_HUMAN_INPUT.printMessage();
          continue;
        }

        // Task 2 case 1
        Colour aiChoose = strategy.chooseColour(); // The AI's chosen colour
        Colour aiGuess = strategy.guessColour(); // The AI's guessed colour

        MessageCli.PRINT_INFO_MOVE.printMessage(AI_NAME, aiChoose, aiGuess);

        validInput = true;
        MessageCli.PRINT_INFO_MOVE.printMessage(player.getName(), chosen, guess);

        // point scoring logic task 2 test 4 - test 7

        // resetting points to 0 each round
        playerRoundPoints = 0;
        aiRoundPoints = 0;

        if (aiGuess.equals(chosen) && guess.equals(aiChoose)) {
          playerRoundPoints += 1;
          aiRoundPoints += 1;
        } else if (guess.equals(aiChoose)) {
          playerRoundPoints += 1;
        } else if (aiGuess.equals(chosen)) {
          aiRoundPoints += 1;
        }

        MessageCli.PRINT_OUTCOME_ROUND.printMessage(player.getName(), String.valueOf(playerRoundPoints));
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(AI_NAME, String.valueOf(aiRoundPoints));
      }
    }
    player.setLastChosenColour(this.chosenPlayerColour);
    currentRound++;
  }

  public void showStats() {
  }

  public Difficulty getGameDifficulty() {
    return this.gameDifficulty;
  }

  public int getCurrentRound() {
    return this.currentRound;
  }

  public Player getPlayer() {
    return player;
  }

  public Colour getChosenPlayerColour() {
    return this.chosenPlayerColour;
  }
}
