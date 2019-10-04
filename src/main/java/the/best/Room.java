package the.best;

import java.util.List;

public interface Room {
    boolean canAddToy(Toy toy);
    void addToy(Toy toy);
    void sort(Toy.Fields sortingType);
    List<Toy> search(Properties properties);
}
