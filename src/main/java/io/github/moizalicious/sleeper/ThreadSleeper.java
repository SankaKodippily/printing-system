package io.github.moizalicious.sleeper;

public class ThreadSleeper {

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public static void sleepRandom(long min, long max) {
        int sleepTime = (int) ((Math.random() * (max - min)) + min);
        sleep(sleepTime);
    }

}
