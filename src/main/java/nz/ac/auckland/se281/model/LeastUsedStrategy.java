package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;
import java.util.ArrayList;

public class LeastUsedStrategy implements AIStrategy {

  private Game game;
  private Colour leastUsed;

  public LeastUsedStrategy(Game game) {
    this.game = game;
  }

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour getAiGuess(Colour lastChosenColour) {
    ArrayList<Colour> history = game.getHistoryOfColours();
    int redCount = 0;
    int greenCount = 0;
    int blueCount = 0;
    int yellowCount = 0;

    // checking which colour has been used the least
    for (Colour currentColour : history) {
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