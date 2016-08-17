package main;

/**
 * Created by Tyson on 8/16/2016.
 */
public class FizzBuzz {
    public static String CalculateReturn(int i) {
        if (i < 0) throw new IllegalArgumentException("Numbers can not be below zero");
        String returnValue = String.valueOf(i);

        if (i%3 == 0 && i%5 == 0) {
            returnValue = "FizzBuzz";
        } else if (i%3 == 0) {
            returnValue = "Fizz";
        } else if (i%5 == 0) {
            returnValue = "Buzz";
        }

        return returnValue;
    }
}
