package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;
import java.util.ArrayList;

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
    ArrayList<Colour> history = game.getHistoryOfColours();
    ArrayList<Colour> alreadyCountedColours = new ArrayList<>();

    Colour leastUsed = null;
    int minCount = Integer.MAX_VALUE;

    // checking which colour has been used the least
    for (Colour colour : history) {
      if (alreadyCountedColours.contains(colour)) {
        // skip because we have already counted this colour
        continue;
      }

      int count = 0;
      for (Colour currentColour : history) {
        if (currentColour.equals(colour)) {
          count++;
        }
      }

      if (count < minCount) {
        minCount = count;
        leastUsed = colour;
      }
      alreadyCountedColours.add(colour); // Mark it as counted AFTER counting
    }
    return leastUsed;
  }
}