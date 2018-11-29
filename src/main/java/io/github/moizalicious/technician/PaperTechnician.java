package io.github.moizalicious.technician;

import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.sleeper.ThreadSleeper;

/**
 * Thread class to represent a Paper Technician.
 */
public class PaperTechnician extends Thread {

    private String name;
    private LaserPrinter laserPrinter;
    private volatile boolean running;

    public PaperTechnician(String name, LaserPrinter laserPrinter, ThreadGroup threadGroup) {
        super(threadGroup, name);
        this.name = name;
        this.laserPrinter = laserPrinter;
        this.running = true;
    }

    /**
     * Method that is executed when the thread is started.
     */
    @Override
    public void run() {
        int c = 0;
        while (running && c < 3) {
            laserPrinter.refillPaper();
            c++;
            if (c != 2) {
                ThreadSleeper.sleepRandom(1000, 4000);
            }
        }
        System.out.println(name + " has completed it's round(s) of paper refills\n");
    }

    /**
     * Method to safely stop running the thread.
     */
    public void terminate() {
        running = false;
    }

}
