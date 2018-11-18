package io.github.moizalicious.student;

import io.github.moizalicious.document.Document;
import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.sleeper.ThreadSleeper;

public class Student extends Thread {

    private String name;

    private LaserPrinter laserPrinter;

    private Document document1;
    private Document document2;
    private Document document3;
    private Document document4;
    private Document document5;

    public Student(String name, LaserPrinter laserPrinter) {
        this.name = name;
        this.laserPrinter = laserPrinter;

        document1 = new Document(name, "Document 1", (int) ((Math.random() * 90) + 10));
        document2 = new Document(name, "Document 2", (int) ((Math.random() * 90) + 10));
        document3 = new Document(name, "Document 3", (int) ((Math.random() * 90) + 10));
        document4 = new Document(name, "Document 4", (int) ((Math.random() * 90) + 10));
        document5 = new Document(name, "Document 5", (int) ((Math.random() * 90) + 10));
    }

    @Override
    public void run() {
        laserPrinter.printDocument(document1);
        ThreadSleeper.sleep(1000);

        laserPrinter.printDocument(document2);
        ThreadSleeper.sleep(1000);

        laserPrinter.printDocument(document3);
        ThreadSleeper.sleep(1000);

        laserPrinter.printDocument(document4);
        ThreadSleeper.sleep(1000);

        laserPrinter.printDocument(document5);
        ThreadSleeper.sleep(1000);
    }

}
