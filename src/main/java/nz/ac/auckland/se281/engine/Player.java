package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class Player {
  private String name;
  private Colour lastChosenColour;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Colour getLastChosenColour() {
    return lastChosenColour;
  }

  public void setLastChosenColour(Colour colour) {
    this.lastChosenColour = colour;
  }
}
