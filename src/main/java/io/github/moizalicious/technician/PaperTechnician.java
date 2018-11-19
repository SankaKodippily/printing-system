package io.github.moizalicious.technician;

import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.sleeper.ThreadSleeper;

public class PaperTechnician extends Thread {

    private String name;
    private LaserPrinter laserPrinter;

    public PaperTechnician(String name, LaserPrinter laserPrinter, ThreadGroup threadGroup) {
        super(threadGroup, name);
        this.name = name;
        this.laserPrinter = laserPrinter;
    }

    @Override
    public void run() {
        laserPrinter.refillPaper();
        ThreadSleeper.sleepRandom(1000, 4000);
        laserPrinter.refillPaper();
        ThreadSleeper.sleepRandom(1000, 4000);
        laserPrinter.refillPaper();

        System.out.println(name + " has completed 3 rounds of paper refills\n");
    }
}
