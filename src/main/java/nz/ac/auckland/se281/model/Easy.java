package nz.ac.auckland.se281.model;

public class Easy implements AIDifficulty {

  private AIStrategy strategy;

  public Easy() {
    this.strategy = new RandomStrategy();
    // pass in AIStrategy so I can access strategy methods guess and choose
    // (getAicolour,getplayercolour)
  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();

  }

  @Override
  public Colour guessColour() {
    return strategy.getAiGuess();

  }

  @Override
  public void setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
  }
}
