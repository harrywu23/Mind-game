package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.engine.Game;

public class DifficultyFactory {

  public static DifficultyLevel createAi(Difficulty type, Game game) {
    switch (type) {
      case EASY:
        return new EasyDifficulty(new RandomStrategy());

      case MEDIUM:
        return new MediumDifficulty(new AvoidLastStrategy());

      case HARD:
        return new HardDifficulty(game, (new LeastUsedStrategy(game)));

      default:
        System.exit(0); // this is bad! it's there because we did not cover exceptions yet :)
    }
    return null;
  }
}
