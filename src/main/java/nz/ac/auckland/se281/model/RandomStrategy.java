package nz.ac.auckland.se281.model;

public class RandomStrategy implements AIStrategy {

  @Override
  public Colour chooseColour() {
    return Colour.getRandomColourForAi();
  }

  public Colour guessColour() {
    return Colour.getRandomColourForAi();
  }
}