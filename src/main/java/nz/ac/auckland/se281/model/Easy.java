package nz.ac.auckland.se281.model;

public class Easy implements AIDifficulty {

  private AIStrategy strategy;

  public Easy(AIStrategy strategy) {
    this.strategy = new RandomStrategy();
    // pass in AIStrategy so I can access strategy methods guess and choose
    // (getAicolour,getplayercolour)
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
