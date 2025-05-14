package nz.ac.auckland.se281.model;

public class RandomStrategy implements AIStrategy {

  @Override
  public Colour setStrategy() {
    return Colour.getRandomColourForAi();
  }

  public Colour guessColour() {
    return Colour.getRandomColourForAi();
  }
}