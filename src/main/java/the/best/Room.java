package the.best;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Room {

    private List<Toy> toys;
    private double capital;
    private int size;
    private int capacity;
    private double totalPrice;
    private AgeGroup ageGroup;

    public static enum AgeGroup{BABY, TEENAGE, ADULT}
    private Room(AgeGroup ageGroup) {
        this.toys = new ArrayList<Toy>();
        this.size = 0;
        this.totalPrice = 0.0;
        this.ageGroup = ageGroup;
    }

    public Room(AgeGroup ageGroup, double capital, int capacity) {
        this(ageGroup);
        this.capital = capital;
        this.capacity = capacity;
    }

    public boolean canAddToy(Toy toy){
        return size < capacity && totalPrice + toy.getPrice() <= capital;
    }

    public void addToy(Toy toy){
        toys.add(toy);
        ++size;
        totalPrice += toy.getPrice();
    }

    @Override
    public String toString() {
        StringBuilder resB = new StringBuilder();
        resB.append(String.format("Age group: %s\nSize:      %d/%d\nPrice:     %.2f$/%.2f$\n", ageGroup, size, capacity, totalPrice, capital));
        if(toys.size() > 0){
            resB.append("\n").append(Toy.getTitles()).append("\n");
            for(Toy toy : toys){
                resB.append(toy.toString()).append("\n");
            }
        }
        return resB.toString();
    }

    public void sort(Toy.Fields sortingType){
        switch (sortingType){
            case PRICE:
                toys.sort((Toy a, Toy b) -> a.compareByPrice(b));
                break;
            case VOLUME:
                toys.sort((Toy a, Toy b) -> a.compareByVolume(b));
                break;
            case WEIGHT:
                toys.sort((Toy a, Toy b) -> a.compareByWeight(b));
                break;
        }
    }

    public List<Toy> search(Properties properties){
        if(properties == null) return null;
        Set<Toy.Fields> toyFiels = properties.getFiels();
        List<Toy> res = new ArrayList<>();
        for(Toy toy : toys){
            boolean isAdd = true;
            for(Toy.Fields fields : toyFiels){
                double toyFieldValue = -1.0;
                switch (fields){
                    case WEIGHT:
                        toyFieldValue = toy.getWeight();
                        break;
                    case PRICE:
                        toyFieldValue = toy.getPrice();
                        break;
                    case VOLUME:
                        toyFieldValue = toy.getVolume();
                        break;
                }
                if(!properties.getInterval(fields).inInterval(toyFieldValue)) {
                    isAdd = false;
                    break;
                }
            }
            if(isAdd){
                res.add(toy);
            }
        }
        return res;
    }
}
