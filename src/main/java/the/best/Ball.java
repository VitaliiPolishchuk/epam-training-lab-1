package the.best;

public class Ball extends Toy{

    private double fullness;

    public Ball(String name, double price, double weight, double volume, double fullness) {
        super(name, price, weight, volume);
        this.fullness = fullness;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("fullness = %-7.2f", fullness);
    }
}
