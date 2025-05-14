package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public class DifficultyFactory {

  public static AIStrategy chooseDifficulty(String difficulty, Game game) {
    difficulty = difficulty.toUpperCase().trim();
    switch (difficulty) {
      case "EASY":
        return new RandomStrategy();

      case "MEDIUM":
        return new AvoidLastStrategy(game);

      default:
        System.exit(0); // this is bad! it's there because we did not cover exceptions yet :)
    }
    return null;
  }
}
