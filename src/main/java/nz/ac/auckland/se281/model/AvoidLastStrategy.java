package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public class AvoidLastStrategy implements AIStrategy {

  private Game game;

  public AvoidLastStrategy() {
  }

  public void setGame(Game game) {
    this.game = game;
  }

  @Override
  public Colour chooseColour() {
    return Colour.getRandomColourForAi();
  }

  public Colour guessColour() {
    int round = game.getCurrentRound();
    Colour lastColour = game.getPlayer().getLastChosenColour();
    // First round → completely random
    if (round > 1) {
      return Colour.getRandomColourExcluding(lastColour);
    }
    return Colour.getRandomColourForAi();
  }
}