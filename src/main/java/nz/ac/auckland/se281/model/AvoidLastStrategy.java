package nz.ac.auckland.se281.model;

public class AvoidLastStrategy implements ArtificialIntelligenceStrategy {

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour getAiGuess(Colour lastChosenColour) {
    return Colour.getRandomColourExcluding(lastChosenColour);
  }
}