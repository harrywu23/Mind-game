package nz.ac.auckland.se281.model;

public class Medium implements Difficulty {

  @Override
  public AIStrategy getStrategy() {
    return new AvoidLastStrategy();
  }
}
