package nz.ac.auckland.se281.model;

public interface AiStrategy {
  public Colour getAiColour();

  public Colour getAiGuess(Colour lastchosenColour);
}
