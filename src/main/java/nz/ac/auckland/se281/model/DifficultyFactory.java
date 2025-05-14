package nz.ac.auckland.se281.model;
import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  public static AIStrategy chooseDifficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new RandomStrategy();

      case MEDIUM:
        return new AvoidLastStrategy();

      default:
        System.exit(0); // this is bad! it's there because we did not cover exceptions yet :)
    }
    return null;
  }
}
