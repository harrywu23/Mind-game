package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public class Medium implements Difficulty {

  @Override
  public AIStrategy createStrategy(Game game) {
    return new AvoidLastStrategy(game);
  }
}
