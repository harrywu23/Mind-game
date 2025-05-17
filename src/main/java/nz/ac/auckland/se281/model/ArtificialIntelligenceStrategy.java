package nz.ac.auckland.se281.model;

public interface ArtificialIntelligenceStrategy {
  public Colour getAiColour();

  public Colour getAiGuess(Colour lastchosenColour);
}
