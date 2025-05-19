package nz.ac.auckland.se281.engine;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.Colour;
import nz.ac.auckland.se281.model.DifficultyFactory;
import nz.ac.auckland.se281.model.DifficultyLevel;

public class Game {

  public static String AI_NAME = "HAL-9000";
  private int numRounds;
  private int currentRound = 1;
  private Difficulty difficulty;
  private int aiRoundPoints;
  private int playerRoundPoints;
  private Colour powerColour;
  private Player player;
  private Colour chosenPlayerColour;
  private DifficultyLevel Ai;
  private ArrayList<Colour> historyOfColours;
  private int aiPointsLastRound = -1;
  private boolean gameStart = false;
  private int playerTotalPoints;
  private int aiTotalPoints;
  private String winner;

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    gameStart = true;
    this.numRounds = numRounds;
    this.difficulty = difficulty;
    this.currentRound = 1;
    historyOfColours = new ArrayList<>();
    this.aiTotalPoints = 0;
    this.playerTotalPoints = 0;
    this.winner = null;

    // Create AI based on difficulty using factory
    Ai = DifficultyFactory.createAi(difficulty, historyOfColours);

    // Check if player name is provided
    if (options.length > 0) {
      String playerName = options[0];
      player = new Player(playerName);
      MessageCli.WELCOME_PLAYER.printMessage(playerName);

    }
  }

  public void play() {

    // if play is called before a new game has been started
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // If all rounds have been played already
    if (currentRound > numRounds) {
      MessageCli.PRINT_END_GAME.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(currentRound), String.valueOf(numRounds));
    // Track player's last round colour
    Colour lastRoundColour = this.chosenPlayerColour;
    historyOfColours.add(lastRoundColour);

    // POWER ROUND
    if (currentRound % 3 == 0 && currentRound != 0) {

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

        // AI makes its move and guess
        Colour aiChoose = Ai.chooseColour(); // The AI's chosen colour
        Ai.setStrategy(currentRound, lastRoundColour, aiPointsLastRound); // SETTING AI Strategy
        Colour aiGuess = Ai.getColour(lastRoundColour); // The AI's guessed colour

        MessageCli.PRINT_INFO_MOVE.printMessage(AI_NAME, aiChoose, aiGuess);

        validInput = true;
        MessageCli.PRINT_INFO_MOVE.printMessage(player.getName(), chosen, guess);
        this.powerColour = Colour.getRandomColourForPowerColour();
        MessageCli.PRINT_POWER_COLOUR.printMessage(powerColour);

        // point scoring logic task 2 test 4 - test 7

        // Resetting round points
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
        if (aiGuess != null && aiGuess.equals(chosen)) {
          aiRoundPoints += 1;
          if (aiGuess != null && aiGuess.equals(powerColour)) {
            aiRoundPoints += 2; // Bonus for guessing power colour (task 8 - 10)
          }
        }

        // Update total points
        playerTotalPoints += playerRoundPoints;
        aiTotalPoints += aiRoundPoints;

        // Store AI's points for this round for hard strategy logic
        setaiPointsLastRound(aiRoundPoints);

        MessageCli.PRINT_OUTCOME_ROUND.printMessage(player.getName(), String.valueOf(playerRoundPoints));
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(AI_NAME, String.valueOf(aiRoundPoints));
      }

      // Non-power rounds
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

        // AI's move and guess
        Colour aiChoose = Ai.chooseColour(); // The AI's chosen colour
        Ai.setStrategy(currentRound, lastRoundColour, aiPointsLastRound); // SETTING AI Strategy
        Colour aiGuess = Ai.getColour(lastRoundColour); // The AI's guessed colour

        MessageCli.PRINT_INFO_MOVE.printMessage(AI_NAME, aiChoose, aiGuess);

        validInput = true;
        MessageCli.PRINT_INFO_MOVE.printMessage(player.getName(), chosen, guess);

        // point scoring logic task 2 test 4 - test 7

        // Resetting round points
        playerRoundPoints = 0;
        aiRoundPoints = 0;

        // Logic for scoring in non-power rounds
        if (aiGuess != null && aiGuess.equals(chosen) && guess.equals(aiChoose)) {
          playerRoundPoints += 1;
          aiRoundPoints += 1;
        } else if (guess.equals(aiChoose)) {
          playerRoundPoints += 1;
        } else if (aiGuess != null && aiGuess.equals(chosen)) {
          aiRoundPoints += 1;
        }

        // Update total points
        playerTotalPoints += playerRoundPoints;
        aiTotalPoints += aiRoundPoints;

        // Store AI's points for this round for hard strategy logic
        setaiPointsLastRound(aiRoundPoints);

        MessageCli.PRINT_OUTCOME_ROUND.printMessage(player.getName(), String.valueOf(playerRoundPoints));
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(AI_NAME, String.valueOf(aiRoundPoints));
      }
    }

    currentRound++;

    // After final round, show stats and declare winner
    if (currentRound > numRounds) {
      showStats();
      MessageCli.PRINT_END_GAME.printMessage();
      if (this.getAiTotalPoints() > this.getPlayerTotalPoints()) {
        winner = AI_NAME;
        MessageCli.PRINT_WINNER_GAME.printMessage(winner);
      } else if (this.getAiTotalPoints() < this.getPlayerTotalPoints()) {
        winner = player.getName();
        MessageCli.PRINT_WINNER_GAME.printMessage(winner);
      }
    }
  }

  public void showStats() {
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_POINTS.printMessage(player.getName(), this.getPlayerTotalPoints());
    MessageCli.PRINT_PLAYER_POINTS.printMessage(AI_NAME, this.getAiTotalPoints());

    // When the game ends in a tie
    if (this.getAiTotalPoints() == this.getPlayerTotalPoints()) {
      MessageCli.PRINT_TIE_GAME.printMessage();
    }
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

  public ArrayList<Colour> getHistoryOfColours() {
    return historyOfColours;
  }

  public int getListSize() {
    return historyOfColours.size();
  }

  public void setaiPointsLastRound(int aiPointsLastRound) {
    this.aiPointsLastRound = aiPointsLastRound;
  }

  public int getAiPointsLastRound() {
    return aiPointsLastRound;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public int getPlayerTotalPoints() {
    return playerTotalPoints;
  }

  public int getAiTotalPoints() {
    return aiTotalPoints;
  }

  public String getWinnerName() {
    return winner;
  }
}
