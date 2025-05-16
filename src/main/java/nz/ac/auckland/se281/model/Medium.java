package nz.ac.auckland.se281.model;

public class Medium implements AIDifficulty {

  private AIStrategy strategy;
  private RandomStrategy easyStrategy;
  private AvoidLastStrategy mediumStrategy;

  public Medium(AIStrategy strategy) {
    this.strategy = strategy;
    this.easyStrategy = new RandomStrategy();
    this.mediumStrategy = new AvoidLastStrategy();
  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();

  }

  @Override
  public Colour guessColour(int currentRound) {
    if (currentRound > 1) {
      return mediumStrategy.getAiGuess();
    }
    return easyStrategy.getAiGuess();
  }

  @Override
  public void setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
  }
}
