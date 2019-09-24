package the.best;

public class Car extends Toy {

    private double speed;

    public Car(String name) {
        super(name);
        this.speed = -1;
    }

    public Car(String name, double price, double weight, double volume, double appearance, double fun, double speed) {
        super(name, price, weight, volume, appearance, fun);
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
        return super.toString() + String.format("speed = %-7.2f", speed);
    }
}
