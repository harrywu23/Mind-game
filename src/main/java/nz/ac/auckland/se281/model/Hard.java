package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public class Hard implements AIDifficulty {

  private AIStrategy strategy;
  private RandomStrategy easyStrategy;
  private AvoidLastStrategy mediumStrategy;
  private LeastUsedStrategy hardStrategy;

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
    if (currentRound < 2) {
      return easyStrategy.getAiGuess(lastChosenColour);
    }
    if (currentRound == 3) {
      return hardStrategy.getAiGuess(lastChosenColour);

    }
    if (currentRound > 4) {
      if (aiPointsLastRound == 0) {
        return mediumStrategy.getAiGuess(lastChosenColour);
      } else {
        return hardStrategy.getAiGuess(lastChosenColour);
      }

    }
    return easyStrategy.getAiGuess(lastChosenColour);
  }

  @Override
  public void setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
  }
}
