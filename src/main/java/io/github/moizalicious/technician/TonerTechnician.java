package io.github.moizalicious.technician;

import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.sleeper.ThreadSleeper;

public class TonerTechnician extends Thread {

    private String name;
    private LaserPrinter laserPrinter;

    public TonerTechnician(String name, LaserPrinter laserPrinter) {
        this.name = name;
        this.laserPrinter = laserPrinter;
    }

    @Override
    public void run() {
        while (true) {
            laserPrinter.replaceTonerCartridge();
            ThreadSleeper.sleep(5000);
        }
    }

}
