package the.best;

public class Doll extends Toy{

    public static enum State {MALE, FEMALE, UNKNOWN}
    private State state;

    public Doll(String name, double price, double weight, double volume, State state) {
        super(name, price, weight, volume);
        this.state = state;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("state    = %-7s", state);
    }
}
