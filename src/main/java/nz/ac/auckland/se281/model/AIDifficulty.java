package nz.ac.auckland.se281.model;

public interface AIDifficulty {
  public Colour chooseColour();
  public Colour guessColour(int currentRound);
  public void setStrategy(AIStrategy strategy);

  // add choose and guess methods 
  // pass in Game game, guess(game) - for getting round, FOR MEDIUM 
}
