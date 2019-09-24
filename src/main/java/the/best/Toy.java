package the.best;

public class Toy {
    private double price;
    private double weight;
    private double volume;
    private double appearance; //marketing
    private double fun;        //value

    private String name;

    public Toy(String name){
        this.name = name;
        this.price = -1;
        this.weight = -1;
        this.volume = -1;
        this.appearance = -1;
        this.fun = -1;
    }

    public Toy(String name, double price, double weight, double volume, double appearance, double fun) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.volume = volume;
        this.appearance = appearance;
        this.fun = fun;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getAppearance() {
        return appearance;
    }

    public void setAppearance(double appearance) {
        this.appearance = appearance;
    }

    public double getFun() {
        return fun;
    }

    public void setFun(double fun) {
        this.fun = fun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getTitles(){
        return String.format("%-20s %-7s %-7s %-7s %-11s %-7s", "", "Prive", "Weight", "Volume", "Appearence", "Fun");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-7.2f %-7.2f %-7.2f %-11.2f %-7.2f", name, price, weight, volume, appearance, fun);
    }
}
