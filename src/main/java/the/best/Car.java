package the.best;

public class Car extends Toy {

    private double speed;

    public Car(String name, double price, double weight, double volume, double speed) {
        super(name, price, weight, volume);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("speed    = %-7.2f", speed);
    }
}
