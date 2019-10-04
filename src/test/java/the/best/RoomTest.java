package the.best;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RoomTest {
    RoomImpl instance;


    @Before
    public void setUp() throws Exception {
        instance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 2);
    }

    @Test
    public void shouldReturnTrueWhenWeCanAddToyMethodCanAddToy() {
        assertTrue(instance.canAddToy(new Toy("def", 1000, 2, 2)));
        assertTrue(instance.canAddToy(new Toy("def", 0, 2, 2)));
        assertTrue(instance.canAddToy(new Toy("def", 100, 2, 2)));
    }

    @Test
    public void shouldReturnFalseWhenToyPriceWithTotalPriceBiggerThanCapitalMethodCanAddToy() {
        assertFalse(instance.canAddToy(new Toy("def", 1000.001, 2, 2)));
    }

    @Test
    public void shouldReturnFalseWhenSizeEqualsCapacityMethodCanAddToy() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 0);
        assertFalse(instance.canAddToy(new Toy("def", 1000.001, 2, 2)));
    }

    @Test
    public void shouldBeEqualsWhenSearchByPrice0to150MethodSearch() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 6);
        Toy toy1 = new Toy("def", 150.01, 2,2);
        Toy toy2 = new Toy("def", 150, 2,2);
        Toy toy3 = new Toy("def", 149.99, 2,2);
        Toy toy4 = new Toy("def", 0, 2,2);
        specialInstance.addToy(toy1);
        specialInstance.addToy(toy2);
        specialInstance.addToy(toy3);
        specialInstance.addToy(toy4);

        List<Toy> expected = Arrays.asList(toy2, toy3, toy4);

        Properties properties = new Properties();
        properties.put(Toy.Fields.PRICE, new Properties.Interval(0,150));

        assertEquals(expected, specialInstance.search(properties));
    }

    @Test
    public void shouldBeEqualsWhenSearchByCapacity0to150MethodSearch() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 6);
        Toy toy1 = new Toy("def", 150.01, 150.01,2);
        Toy toy2 = new Toy("def", 150, 150,2);
        Toy toy3 = new Toy("def", 149.99, 149.99,2);
        Toy toy4 = new Toy("def", 0, 0,2);
        specialInstance.addToy(toy1);
        specialInstance.addToy(toy2);
        specialInstance.addToy(toy3);
        specialInstance.addToy(toy4);

        List<Toy> expected = Arrays.asList(toy2, toy3, toy4);

        Properties properties = new Properties();
        properties.put(Toy.Fields.WEIGHT, new Properties.Interval(0,150));

        assertEquals(expected, specialInstance.search(properties));
    }

    @Test
    public void shouldBeEqualsWhenSearchByVolume0to150MethodSearch() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 6);
        Toy toy1 = new Toy("def", 150.01, 2,150.1);
        Toy toy2 = new Toy("def", 150, 2,150);
        Toy toy3 = new Toy("def", 149.99, 2,149.99);
        Toy toy4 = new Toy("def", 0, 2,0);
        specialInstance.addToy(toy1);
        specialInstance.addToy(toy2);
        specialInstance.addToy(toy3);
        specialInstance.addToy(toy4);

        List<Toy> expected = Arrays.asList(toy2, toy3, toy4);

        Properties properties = new Properties();
        properties.put(Toy.Fields.VOLUME, new Properties.Interval(0,150));

        assertEquals(expected, specialInstance.search(properties));
    }

    @Test
    public void shouldBeEqualsWhenPropertiesIsNullMethodSearch() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 6);
        Toy toy1 = new Toy("def", 150.01, 2,150.1);
        Toy toy2 = new Toy("def", 150, 2,150);
        Toy toy3 = new Toy("def", 149.99, 2,149.99);
        Toy toy4 = new Toy("def", 0, 2,0);
        specialInstance.addToy(toy1);
        specialInstance.addToy(toy2);
        specialInstance.addToy(toy3);
        specialInstance.addToy(toy4);

        List<Toy> expected = Arrays.asList(toy1, toy2, toy3, toy4);

        assertEquals(expected, specialInstance.search(null));
    }

    @Test
    public void shouldBeEqualsWhenSortByPrice() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 6);
        Toy toy1 = new Toy("def", 149.99, 1.99,199.99);
        Toy toy2 = new Toy("def", 150, 2,150);
        Toy toy3 = new Toy("def", 150.01, 2.01,150.1);
        Toy toy4 = new Toy("def", 0, 2,0);
        specialInstance.addToy(toy1);
        specialInstance.addToy(toy2);
        specialInstance.addToy(toy3);
        specialInstance.addToy(toy4);

        List<Toy> expected = Arrays.asList(toy4, toy1, toy2, toy3);

        specialInstance.sort(Toy.Fields.PRICE);

        assertEquals(expected, specialInstance.search(null));
    }

    @Test
    public void shouldBeEqualsWhenSortByWeight() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 6);
        Toy toy1 = new Toy("def", 149.99, 1.99,199.99);
        Toy toy2 = new Toy("def", 150, 2,150);
        Toy toy3 = new Toy("def", 150.01, 2.01,150.1);
        Toy toy4 = new Toy("def", 0, 0,0);
        specialInstance.addToy(toy1);
        specialInstance.addToy(toy2);
        specialInstance.addToy(toy3);
        specialInstance.addToy(toy4);

        List<Toy> expected = Arrays.asList(toy4, toy1, toy2, toy3);

        specialInstance.sort(Toy.Fields.WEIGHT);

        assertEquals(expected, specialInstance.search(null));
    }


    @Test
    public void shouldBeEqualsWhenSortByVolume() {
        RoomImpl specialInstance = new RoomImpl(RoomImpl.AgeGroup.ADULT, 1000, 6);
        Toy toy1 = new Toy("def", 149.99, 1.99,149.99);
        Toy toy2 = new Toy("def", 150, 2,150);
        Toy toy3 = new Toy("def", 150.01, 2.01,150.1);
        Toy toy4 = new Toy("def", 0, 2,0);
        specialInstance.addToy(toy1);
        specialInstance.addToy(toy2);
        specialInstance.addToy(toy3);
        specialInstance.addToy(toy4);

        List<Toy> expected = Arrays.asList(toy4, toy1, toy2, toy3);

        specialInstance.sort(Toy.Fields.VOLUME);

        assertEquals(expected, specialInstance.search(null));
    }
}