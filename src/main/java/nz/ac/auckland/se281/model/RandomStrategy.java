package nz.ac.auckland.se281.model;

public class RandomStrategy implements AIStrategy {

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour getAiGuess(Colour lastChosenColour) {
    return Colour.getRandomColourForAi();
  }
}