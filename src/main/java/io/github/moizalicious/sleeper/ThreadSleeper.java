/**
 * Utility class used to call the static Thread.sleep() method.
 */

package io.github.moizalicious.sleeper;

public class ThreadSleeper {

    /**
     * Method to call the Thread.sleep() method for a specific time.
     *
     * @param milliseconds Amount of time the thread must sleep
     */
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    /**
     * Method to call the Thread.sleep() method for a random amount of time.
     *
     * @param min Minimum random amount
     * @param max Maximum random amount
     */
    public static void sleepRandom(long min, long max) {
        int sleepTime = (int) ((Math.random() * (max - min)) + min);
        sleep(sleepTime);
    }

}
