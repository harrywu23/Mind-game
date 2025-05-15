package nz.ac.auckland.se281.model;

public class Easy implements AIDifficulty {

  private AIStrategy strategy;

  public Easy() {
    // pass in AIStrategy so I can access strategy methods guess and choose (getAicolour,getplayercolour)
  }

  @Override
  public void setStrategy(AIStrategy strategy) {
    this.strategy = strategy;
  }
}
