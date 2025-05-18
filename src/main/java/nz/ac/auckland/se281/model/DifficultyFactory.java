package nz.ac.auckland.se281.model;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  public static DifficultyLevel createAi(Difficulty type, ArrayList<Colour> historyOfColours) {
    switch (type) {
      case EASY:
        return new EasyDifficulty(new RandomStrategy());

      case MEDIUM:
        return new MediumDifficulty(new AvoidLastStrategy());

      case HARD:
        return new HardDifficulty(historyOfColours, (new LeastUsedStrategy(historyOfColours)));

      default:
        System.exit(0); // this is bad! it's there because we did not cover exceptions yet :)
    }
    return null;
  }
}
