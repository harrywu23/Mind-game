package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public interface Difficulty {
    public AIStrategy createStrategy(Game game);
}
