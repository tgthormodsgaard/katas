package test;

import main.FizzBuzz;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tyson on 8/16/2016.
 */
public class FizzBuzzTest {

    @Test
    public void oneReturnsOne() {
        assertEquals("1", FizzBuzz.CalculateReturn(1));
    }

    @Test
    public void threeReturnsFizz() {
        assertEquals("Fizz", FizzBuzz.CalculateReturn(3));
    }

    @Test
    public void fiveReturnsBuzz() {
        assertEquals("Buzz", FizzBuzz.CalculateReturn(5));
    }

    @Test
    public void fifteenReturnsFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.CalculateReturn(15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeThrowsException() {
        FizzBuzz.CalculateReturn(-1);
    }
}
