package nz.ac.auckland.se281.model;

public class RandomStrategy implements AIStrategy {

  private AIStrategy strategy;

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  public Colour getAiGuess(Colour lastChosenColour) {
    return Colour.getRandomColourForAi();
  }

  @Override
  public AIStrategy setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
    return strategy;
  }
}