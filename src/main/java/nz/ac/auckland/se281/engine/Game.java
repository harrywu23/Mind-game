package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

public class Game {
  public static String AI_NAME = "HAL-9000";

  private int numRounds;
  private int currentRound;
  public Game() {
  }

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    this.numRounds = numRounds;
    this.currentRound = 1;
    if (options.length > 0) {
      String namePlayer = options[0];
      MessageCli.WELCOME_PLAYER.printMessage(namePlayer);
    }
  }  
  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(currentRound), String.valueOf(numRounds)); 
  }

  public void showStats() {}
}
