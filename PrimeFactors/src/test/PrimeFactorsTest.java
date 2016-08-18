package test;

import org.junit.Test;

import static java.util.Arrays.asList;
import static main.PrimeFactors.computePrimes;
import static org.junit.Assert.assertEquals;

/**
 * Created by Tyson on 8/17/2016.
 */
public class PrimeFactorsTest {
    @Test
    public void oneHasNoPrime() {
        assertEquals(asList(), computePrimes(1));
    }

    @Test
    public void twoIsPrime() {
        assertEquals(asList(2), computePrimes(2));
    }

    @Test
    public void fourHasTwoTimesTwoPrimes() {
        assertEquals(asList(2,2), computePrimes(4));
    }

    @Test
    public void fiveIsPrime() {
        assertEquals(asList(5), computePrimes(5));
    }

    @Test
    public void sixHasTwoTimesThreePrimes() {
        assertEquals(asList(2,3), computePrimes(6));
    }

    @Test
    public void eightHasThreeTimesTwoPrimes() {
        assertEquals(asList(2,2,2), computePrimes(8));
    }

    @Test
    public void nineHasThreeTimesThreePrimes() {
        assertEquals(asList(3,3), computePrimes(9));
    }

    @Test
    public void twelveHasTwoTwoThreePrimes() {
        assertEquals(asList(2,2,3), computePrimes(12));
    }

    @Test
    public void fifteenHasThreeTimesFivePrimes() {
        assertEquals(asList(3,5), computePrimes(15));
    }
}
