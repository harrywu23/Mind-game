package nz.ac.auckland.se281.model;

import java.util.ArrayList;

public class HardDifficulty implements DifficultyLevel {

  private ArtificialIntelligenceStrategy strategy;
  private RandomStrategy easyStrategy;
  private AvoidLastStrategy mediumStrategy;
  private LeastUsedStrategy hardStrategy;
  private ArtificialIntelligenceStrategy currentStrategy;

  public HardDifficulty(ArrayList<Colour> historyOfColours, ArtificialIntelligenceStrategy strategy) {
    this.strategy = strategy;
    this.easyStrategy = new RandomStrategy();
    this.mediumStrategy = new AvoidLastStrategy();
    this.hardStrategy = new LeastUsedStrategy(historyOfColours);
    this.currentStrategy = easyStrategy;

  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();
  }

  @Override
  public Colour getColour(Colour lastChosenColour) {
    return currentStrategy.getAiGuess(lastChosenColour);
  }

  @Override
  // set strategy should be void. should set current strategy within this class
  public void setStrategy(int currentRound, Colour lastChosenColour, int aiPointsLastRound) {

    if (currentRound <= 2) {
      currentStrategy = easyStrategy;
    } else if (currentRound == 3) {
      currentStrategy = hardStrategy;
    } else {
      // points scored = 0;
      if (aiPointsLastRound == 0) {
        if (currentStrategy == hardStrategy) {
          currentStrategy = mediumStrategy;
        } else if (currentStrategy == mediumStrategy) {
          currentStrategy = hardStrategy;
        }
        // if points scored > 0
      } else if (aiPointsLastRound >= 1) {
        if (currentStrategy == mediumStrategy) {
          currentStrategy = mediumStrategy;
        } else if (currentStrategy == hardStrategy) {
          currentStrategy = hardStrategy;
        }
      }
    }

    // make a new method that returns this
    // return currentStrategy.getAiGuess(lastChosenColour);
  }

  // wherever this class was made,
  // ai.setstrategy
  // ai.getcolour
}
