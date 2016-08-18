package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyson on 8/17/2016.
 */
public class PrimeFactors {
    public static List<Integer> computePrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();


        for (int candidate = 2;n > 1;candidate++) {
            for (;n%candidate == 0;n /= candidate) {
                primes.add(candidate);
            }
        }

        return primes;
    }
}
