package nz.ac.auckland.se281.model;

public class DifficultyFactory {

  public static AIDifficulty selectDifficulty(String type) {
    switch (type) {
      case "EASY":
        return new Easy();

      // case "MEDIUM":
      // return new Medium();

      // case "HARD":
      // return new Hard();

      default:
        System.exit(0); // this is bad! it's there because we did not cover exceptions yet :)
    }
    return null;
  }
}
