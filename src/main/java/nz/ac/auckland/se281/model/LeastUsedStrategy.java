package nz.ac.auckland.se281.model;

import java.util.ArrayList;
import nz.ac.auckland.se281.engine.Game;

public class LeastUsedStrategy implements AIStrategy {

  private Game game;

  public LeastUsedStrategy(Game game) {
    this.game = game;
  }

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour getAiGuess(Colour lastChosenColour) {
    ArrayList<Colour> playerColourHistory = game.getHistoryOfColours();

    // reset count every time the method is called

    int redCount = 0;
    int greenCount = 0;
    int blueCount = 0;
    int yellowCount = 0;

    // checking which colour has been used the least

    for (Colour currentColour : playerColourHistory) {
      if (currentColour == null) {
        continue;
      }

      if (currentColour.equals(Colour.RED)) {
        redCount++;
      } else if (currentColour.equals(Colour.GREEN)) {
        greenCount++;
      } else if (currentColour.equals(Colour.BLUE)) {
        blueCount++;
      } else if (currentColour.equals(Colour.YELLOW)) {
        yellowCount++;
      }
    }

    // start R,G,B,Y
    Colour leastUsed = Colour.RED;
    int minCount = redCount;

    if (greenCount < minCount) {
      leastUsed = Colour.GREEN;
      minCount = greenCount;
    }
    if (blueCount < minCount) {
      leastUsed = Colour.BLUE;
      minCount = blueCount;
    }
    if (yellowCount < minCount) {
      leastUsed = Colour.YELLOW;
      minCount = yellowCount;
    }
    return leastUsed;
  }
}