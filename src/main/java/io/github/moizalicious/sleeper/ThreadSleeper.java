package io.github.moizalicious.sleeper;

public class ThreadSleeper {

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

}
