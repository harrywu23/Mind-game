package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public class AvoidLastStrategy implements AIStrategy {

  private Game game;

  public AvoidLastStrategy(Game game) {
    this.game = game;
  }

  @Override
  public Colour chooseColour() {
    return Colour.getRandomColourForAi();
  }

  @Override
  public Colour guessColour() {
    Colour lastColour = game.getPlayer().getLastChosenColour();
    return Colour.getRandomColourExcluding(lastColour);
  }
}