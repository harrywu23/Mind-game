package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  public static AIDifficulty createAI(Difficulty type) {
    switch (type) {
      case EASY:
        return new Easy();

      case MEDIUM:
        return new Medium(new AvoidLastStrategy());

      // case "HARD":
      // return new Hard();

      default:
        System.exit(0); // this is bad! it's there because we did not cover exceptions yet :)
    }
    return null;
  }
}
