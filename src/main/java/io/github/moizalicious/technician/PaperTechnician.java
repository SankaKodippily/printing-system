package io.github.moizalicious.technician;

import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.sleeper.ThreadSleeper;

public class PaperTechnician extends Thread {

    private String name;
    private LaserPrinter laserPrinter;

    public PaperTechnician(String name, LaserPrinter laserPrinter) {
        this.name = name;
        this.laserPrinter = laserPrinter;
    }

    @Override
    public void run() {
//        while (true) {
//            laserPrinter.refillPaper();
//        }
        for (int i = 0; i < 3; i++) {
            laserPrinter.refillPaper();
            ThreadSleeper.sleep(5000);
        }
        System.out.println(name + " has completed 3 rounds of paper refills\n");
    }
}
