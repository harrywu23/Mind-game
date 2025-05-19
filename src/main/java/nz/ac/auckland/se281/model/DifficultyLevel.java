package nz.ac.auckland.se281.model;

public interface DifficultyLevel {
  public Colour chooseColour();

  public Colour getColour(Colour lastChosenColour);

  public void setStrategy(int currentRound, Colour lastChosenColour, int aiPointsLastRound);
}
