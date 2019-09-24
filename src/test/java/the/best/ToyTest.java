package the.best;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToyTest {
    Toy instance;

    @Before
    public void setUp() throws Exception {
        instance = new Toy("def", 1,2,3);
    }

    @Test
    public void shouldReturnZeroWhenInputEqualsByPriceMethodCompareByPrice() {
        assertEquals(0,instance.compareByPrice(new Toy("def", 1, 2, 3)));
    }

    @Test
    public void shouldReturnZeroWhenInputEqualsByVolumeMethodCompareByVolume() {
        assertEquals(0, instance.compareByPrice(new Toy("def", 1, 2, 3)));
    }

    @Test
    public void shouldReturnZeroWhenInputEqualsByWeightMethodCompareByWeight() {
        assertEquals(0, instance.compareByWeight(new Toy("def", 1, 2, 3)));
    }

    @Test
    public void shouldReturnOneWhenInputLessThanInstanceMethodCompareByWeight() {
        assertEquals(1, instance.compareByWeight(new Toy("def", 1, 1.99, 2.99)));
    }

    @Test
    public void shouldReturnOneWhenInputLessThanInstanceMethodCompareByPrice() {
        assertEquals(1, instance.compareByPrice(new Toy("def", 0.99, 1.99, 2.99)));
    }

    @Test
    public void shouldReturnOneWhenInputLessThanInstanceMethodCompareByVolume() {
        assertEquals(1, instance.compareByVolume(new Toy("def", 0.99, 1.99, 2.99)));
    }

    @Test
    public void shouldReturnNegativeOneWhenInputBiggerThanInstanceMethodCompareByVolume() {
        assertEquals(-1, instance.compareByVolume(new Toy("def", 1.01, 2.01, 3.01)));
    }

    @Test
    public void shouldReturnNegativeOneWhenInputBiggerThanInstanceMethodCompareByPrice() {
        assertEquals(-1, instance.compareByPrice(new Toy("def", 1.01, 2.01, 3.01)));
    }

    @Test
    public void shouldReturnNegativeOneWhenInputBiggerThanInstanceMethodCompareByWeight() {
        assertEquals(-1, instance.compareByWeight(new Toy("def", 1.01, 2.01, 3.01)));
    }
}