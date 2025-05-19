package nz.ac.auckland.se281.model;

public class MediumDifficulty implements DifficultyLevel {

  private ArtificialIntelligenceStrategy strategy;
  private RandomStrategy easyStrategy;
  private AvoidLastStrategy mediumStrategy;
  private ArtificialIntelligenceStrategy currentStrategy;

  public MediumDifficulty(ArtificialIntelligenceStrategy strategy) {
    this.strategy = strategy;
    this.easyStrategy = new RandomStrategy();
    this.mediumStrategy = new AvoidLastStrategy();
  }

  @Override
  public Colour chooseColour() {
    return strategy.getAiColour();

  }

  @Override
  public void setStrategy(int currentRound, Colour lastChosenColour, int aiPointsLastRound) {
    if (currentRound > 1) {
      currentStrategy = mediumStrategy;
    } else {
      currentStrategy = easyStrategy;
    }
  }

  @Override
  public Colour getColour(Colour lastChosenColour) {
    return currentStrategy.getAiGuess(lastChosenColour);
  }
}
