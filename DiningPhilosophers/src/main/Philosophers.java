package main;

import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 * A philosphers class to be used to determine if the philospher is eating
 */
public class Philosophers implements Runnable {

    /**how long a philospher eats */
    private Random numGenerator = new Random();

    /**Philosphers ID */
    private int id;

    /** the chopsticks for the philospher to use */
    private Lock leftChopstick;
    private Lock rightChopstick;

    public Philosophers(int id, Lock leftChopstick, Lock rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                pickUpLeftChopstick();
                pickUpRightChopstick();
                eat();
                putDownChopsticks();
            }
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + id + " was interrupted.\n");
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.\n");
        System.out.flush();
        Thread.sleep (numGenerator.nextInt(10));
    }

    /**
     * Locks the left chopstick to signify that this philosopher is holding it
     */
    private void pickUpLeftChopstick() {
        leftChopstick.lock();
        System.out.println("Philosopher " + id + " is holding 1 chopstick.\n");
        System.out.flush();
    }

    /**
     * Locks the right chopstick to signify that this philosopher is holding it
     */
    private void pickUpRightChopstick() {
        rightChopstick.lock();
    }

    /**
     * Lets a random amount of time pass to model eating.
     * @throws InterruptedException
     */
    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.\n");
        System.out.flush();
        Thread.sleep (numGenerator.nextInt(10));
    }

    /**
     * Releases the locks on both chopsticks to model putting them down so the
     * other philosophers can use them.
     */
    private void putDownChopsticks() {
        leftChopstick.unlock();
        rightChopstick.unlock();
    }
}
