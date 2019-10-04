package the.best;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertiesTest {

    @InjectMocks
    Properties instance;

    @Mock
    HashMap<Toy.Fields ,Properties.Interval> properties;

    Properties.Interval instanceInterval;

    @Before
    public void setUp() throws Exception {
        instanceInterval = new Properties.Interval(0, 50);
    }

    @Test
    public void shouldReturnTrueWhenPropertiesContainsKeyMethodPut() {
        Toy.Fields toyFields = Toy.Fields.PRICE;
        Properties.Interval interval = new Properties.Interval(0, 150);
        when(properties.containsKey(toyFields)).thenReturn(true);

        assertTrue(instance.put(toyFields, interval));
    }

    @Test
    public void shouldReturnFalseWhenPropertiesNotContainsKeyMethodPut() {
        Toy.Fields toyFields = Toy.Fields.PRICE;
        Properties.Interval interval = new Properties.Interval(0, 150);
        when(properties.containsKey(toyFields)).thenReturn(false);

        assertFalse(instance.put(toyFields, interval));
    }

    @Test
    public void shouldReturnTrueWhenIntervalContainsValueClassIntervalMethodInInterval() {
        assertTrue(instanceInterval.inInterval(25));
        assertTrue(instanceInterval.inInterval(0));
        assertTrue(instanceInterval.inInterval(50));
    }

    @Test
    public void shouldReturnFalseWhenIntervalNotContainsValueClassIntervalMethodInInterval() {
        assertFalse(instanceInterval.inInterval(50.01));
        assertFalse(instanceInterval.inInterval(-0.01));
    }
}