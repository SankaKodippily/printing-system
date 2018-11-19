package io.github.moizalicious.technician;

import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.sleeper.ThreadSleeper;

public class TonerTechnician extends Thread {

    private String name;
    private LaserPrinter laserPrinter;

    public TonerTechnician(String name, LaserPrinter laserPrinter, ThreadGroup threadGroup) {
        super(threadGroup, name);
        this.name = name;
        this.laserPrinter = laserPrinter;
    }

    @Override
    public void run() {
        laserPrinter.replaceTonerCartridge();
        ThreadSleeper.sleepRandom(1000, 4000);
        laserPrinter.replaceTonerCartridge();
        ThreadSleeper.sleepRandom(1000, 4000);
        laserPrinter.replaceTonerCartridge();

        System.out.println(name + " has completed 3 rounds of toner replacements\n");
    }

}
