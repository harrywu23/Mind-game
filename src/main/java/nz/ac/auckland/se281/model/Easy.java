package nz.ac.auckland.se281.model;

import nz.ac.auckland.se281.engine.Game;

public class Easy implements Difficulty {

    @Override
    public AIStrategy createStrategy(Game game) {
        return new RandomStrategy(); 
    }
}
