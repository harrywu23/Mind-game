package nz.ac.auckland.se281.model;

public class EasyDifficulty implements DifficultyLevel {

  private ArtificialIntelligenceStrategy strategy;
  private ArtificialIntelligenceStrategy currentStrategy;

  public EasyDifficulty(ArtificialIntelligenceStrategy strategy) {
    this.strategy = new RandomStrategy();
  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();

  }

  @Override
  public void setStrategy(int currentRound, Colour lastChosenColour, int aiPointsLastRound) {
    currentStrategy = strategy;
  }

  @Override
  public Colour getColour(Colour lastChosenColour) {
    return currentStrategy.getAiGuess(lastChosenColour);
  }
}
