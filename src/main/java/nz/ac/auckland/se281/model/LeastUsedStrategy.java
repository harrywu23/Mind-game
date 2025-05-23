package nz.ac.auckland.se281.model;

import java.util.ArrayList;

public class LeastUsedStrategy implements ArtificialIntelligenceStrategy {

  private ArrayList<Colour> historyOfColours;

  public LeastUsedStrategy(ArrayList<Colour> historyOfColours) {
    this.historyOfColours = historyOfColours;
  }

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour getAiGuess(Colour lastChosenColour) {
    int redCount = 0;
    int greenCount = 0;
    int blueCount = 0;
    int yellowCount = 0;

    for (Colour currentColour : historyOfColours) {
      if (currentColour == null) {
        continue;
      }

      if (currentColour == Colour.RED) {
        redCount++;
      } else if (currentColour == Colour.GREEN) {
        greenCount++;
      } else if (currentColour == Colour.BLUE) {
        blueCount++;
      } else if (currentColour == Colour.YELLOW) {
        yellowCount++;
      }
    }

    // Find the least used colour based on canonical order
    if (redCount <= greenCount && redCount <= blueCount && redCount <= yellowCount) {
      return Colour.RED;
    } else if (greenCount <= blueCount && greenCount <= yellowCount) {
      return Colour.GREEN;
    } else if (blueCount <= yellowCount) {
      return Colour.BLUE;
    } else {
      return Colour.YELLOW;
    }
  }
}