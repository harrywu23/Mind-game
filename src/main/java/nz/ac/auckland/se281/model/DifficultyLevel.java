package nz.ac.auckland.se281.model;

public interface DifficultyLevel {
  public Colour chooseColour();

  public Colour guessColour(int currentRound, Colour lastChosenColour, int aiPointsLastRound);

  public void setStrategy(AiStrategy strategy);
}
