package nz.ac.auckland.se281.model;

public class AvoidLastStrategy implements AIStrategy {

  private AIStrategy strategy;

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour getAiGuess(Colour lastChosenColour) {
    return Colour.getRandomColourExcluding(lastChosenColour);
  }

  @Override
  public AIStrategy setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
    return strategy;
  }
}