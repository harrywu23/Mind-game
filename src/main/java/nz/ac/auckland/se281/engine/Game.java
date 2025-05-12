package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

public class Game {

  public static String AI_NAME = "HAL-9000";
  private int numRounds;
  private int currentRound = 1;

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    this.numRounds = numRounds;
    if (options.length > 0) {
      String namePlayer = options[0];
      MessageCli.WELCOME_PLAYER.printMessage(namePlayer);
    }
  }  
  
  public void play() {
    if (currentRound <= numRounds){
      MessageCli.START_ROUND.printMessage(String.valueOf(currentRound), String.valueOf(numRounds));
      currentRound++; 
    }
  }

  public void showStats() {}
}
