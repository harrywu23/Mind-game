package nz.ac.auckland.se281.model;

public class Hard implements AIDifficulty {
  private AIStrategy strategy;

  public Hard(AIStrategy strategy) {
    this.strategy = new RandomStrategy();

  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();

  }

  @Override
  public Colour guessColour(int currentRound, Colour lastChosenColour) {
    return strategy.getAiGuess(lastChosenColour);

  }

  @Override
  public void setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
  }
}
