package nz.ac.auckland.se281.model;

public class MediumDifficulty implements DifficultyLevel {

  private AIStrategy strategy;
  private RandomStrategy easyStrategy;
  private AvoidLastStrategy mediumStrategy;

  public MediumDifficulty(AIStrategy strategy) {
    this.strategy = strategy;
    this.easyStrategy = new RandomStrategy();
    this.mediumStrategy = new AvoidLastStrategy();
  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();

  }

  @Override
  public Colour guessColour(int currentRound, Colour lastChosenColour, int aiPointsLastRound) {
    if (currentRound > 1) {
      return mediumStrategy.getAiGuess(lastChosenColour);
    }
    return easyStrategy.getAiGuess(lastChosenColour);
  }

  @Override
  public void setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
  }
}
