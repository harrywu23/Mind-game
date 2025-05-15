package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Player;

public class AvoidLastStrategy implements AIStrategy {

  private Player player;

  public AvoidLastStrategy(Player player) {
    this.player = player;
  }

  @Override
  public Colour chooseColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour guessColour() {
    Colour lastColour = player.getLastChosenColour();
    return Colour.getRandomColourExcluding(lastColour);
  }
}