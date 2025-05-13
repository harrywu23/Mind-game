package nz.ac.auckland.se281.model;

public class DifficultyPicker {

  public static AIStrategy chooseDifficulty(String difficulty) {
    difficulty = difficulty.toUpperCase().trim();
    switch (difficulty) {
      case "EASY":
        return new RandomStrategy();

      default:
        System.exit(0); // this is bad! it's there because we did not cover exceptions yet :)
    }
    return null;
  }
}
