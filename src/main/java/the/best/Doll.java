package the.best;

public class Doll extends Toy{

    public enum State {MALE, FEMALE, UNKNOWN}
    private State state;

    public Doll(String name) {
        super(name);
        this.state = State.UNKNOWN;
    }

    public Doll(String name, double price, double weight, double volume, double appearance, double fun, State state) {
        super(name, price, weight, volume, appearance, fun);
        this.state = state;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("state = %-7s", state);
    }
}
