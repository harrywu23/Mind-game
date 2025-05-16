package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Player;

public class AvoidLastStrategy implements AIStrategy {

  private Player player;

  public AvoidLastStrategy() {
  }

  @Override
  public Colour getAiColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour getAiGuess() {
    Colour lastColour = player.getLastChosenColour();
    return Colour.getRandomColourExcluding(lastColour);
  }
}