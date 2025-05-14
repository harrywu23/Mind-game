package nz.ac.auckland.se281.model;

public class Easy implements Difficulty {

  private AIStrategy strategy;

  public Easy() {
    this.strategy = new RandomStrategy();
  }

  @Override
  public Colour useStrategy() {
    return strategy.guessColour();
  }
}
