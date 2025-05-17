package nz.ac.auckland.se281.model;

public interface AIStrategy {
  public Colour getAiColour();

  public Colour getAiGuess(Colour lastchosenColour);

  public AIStrategy setStrategy(AIStrategy strategy);
}
