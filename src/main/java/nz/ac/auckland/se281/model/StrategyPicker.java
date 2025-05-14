public class StrategyPicker {
    private AIStrategy strategy;

    public StrategyPicker(AIStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AIStrategy strategy) {
        this.strategy = strategy;
    }

    public AIStrategy getStrategy() {
        return strategy;
    }

    public Colour getGuess() {
        return strategy.guessColour();
    }
}
