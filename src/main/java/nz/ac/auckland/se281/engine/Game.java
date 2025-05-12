package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;
import nz.ac.auckland.se281.cli.Utils;

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

    if (currentRound <= numRounds){
      MessageCli.START_ROUND.printMessage(String.valueOf(currentRound), String.valueOf(numRounds));
      currentRound++; 
    }

    MessageCli.ASK_HUMAN_INPUT.printMessage();

    String input = Utils.scanner.nextLine().toUpperCase();
String[] inputs = input.split(" ");

if (inputs.length != 2) {
  MessageCli.INVALID_HUMAN_INPUT.printMessage();
  return;
}

Colour chosen = Colour.fromInput(inputs[0]);
Colour guess = Colour.fromInput(inputs[1]);

if (chosen == null || guess == null) {
  MessageCli.INVALID_HUMAN_INPUT.printMessage();
  return;
}

MessageCli.PRINT_INFO_MOVE.printMessage(namePlayer, chosen.toString(), guess.toString());
  }

  public void showStats() {}
}
