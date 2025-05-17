package nz.ac.auckland.se281.model;

public interface AIDifficulty {
  public Colour chooseColour();

  public Colour guessColour(int currentRound, Colour lastChosenColour, int aiPointsLastRound);

  public void setStrategy(AIStrategy strategy);
}
