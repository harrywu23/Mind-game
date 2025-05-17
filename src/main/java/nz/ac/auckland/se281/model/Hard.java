package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public class Hard implements AIDifficulty {

  private AIStrategy strategy;
  private RandomStrategy easyStrategy;
  private AvoidLastStrategy mediumStrategy;
  private LeastUsedStrategy hardStrategy;
  private AIStrategy currentStrategy;

  public Hard(Game game, AIStrategy strategy) {
    this.strategy = strategy;
    this.easyStrategy = new RandomStrategy();
    this.mediumStrategy = new AvoidLastStrategy();
    this.hardStrategy = new LeastUsedStrategy(game);

  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();
  }

  @Override
  public Colour guessColour(int currentRound, Colour lastChosenColour, int aiPointsLastRound) {

    // use currentStrategy.setStrategy() later
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
    return currentStrategy.getAiGuess(lastChosenColour);
  }
}
