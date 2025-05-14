package nz.ac.auckland.se281.model;

public class Easy implements Difficulty {

    @Override
    public AIStrategy getStrategy() {
        return new RandomStrategy(); 
    }
}
