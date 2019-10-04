package the.best;

public class Toy {

    public static enum Fields{PRICE, WEIGHT, VOLUME}

    private double price;
    private double weight;
    private double volume;

    private String name;



    public Toy(String name, double price, double weight, double volume) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.volume = volume;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getTitles(){
        return String.format("%-20s %-15s %-15s %-15s %-15s", "Name", "Class", "Price", "Weight", "Volume");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-15s %-15s %-15s",
                                name,
                                getOnlyClassName(),
                                Double.toString(price) + " $",
                                Double.toString(weight) + " kg",
                                Double.toString(volume) + " m^3");
    }

    private String getOnlyClassName(){
        String res = this.getClass().toGenericString();
        int lastIndexOfDot = res.lastIndexOf(".");
        if(lastIndexOfDot == -1){
            return res;
        }
        return res.substring(lastIndexOfDot + 1);
    }

    public int compareByPrice(Toy toy){
        if(toy == null) {
            throw new NullPointerException("toy is null in compareByPrice");
        }

        if(toy.getPrice() == this.price) {
            return 0;
        }
        else if(toy.getPrice() > this.price){
             return -1;
        }
        else {
            return 1;
        }
    }

    public int compareByWeight(Toy toy){
        if(toy == null) {
            throw new NullPointerException("toy is null in compareByWeight");
        }

        if(toy.getWeight() == this.weight) {
            return 0;
        }
        else if(toy.getWeight() > this.weight){
            return -1;
        }
        else {
            return 1;
        }
    }

    public int compareByVolume(Toy toy){
        if(toy == null) {
            throw new NullPointerException("toy is null in compareByVolume");
        }

        if(toy.getVolume() == this.volume) {
            return 0;
        }
        else if(toy.getVolume() > this.volume){
            return -1;
        }
        else {
            return 1;
        }
    }
}
