package io.github.moizalicious.student;

import io.github.moizalicious.document.Document;
import io.github.moizalicious.printer.LaserPrinter;

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
        document1 = new Document(name, "Document 1", generateRandomNoOfPages());
        document2 = new Document(name, "Document 2", generateRandomNoOfPages());
        document3 = new Document(name, "Document 3", generateRandomNoOfPages());
        document4 = new Document(name, "Document 4", generateRandomNoOfPages());
        document5 = new Document(name, "Document 5", generateRandomNoOfPages());
    }

    private int generateRandomNoOfPages() {
        int min = 1;
        int max = 30;
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void run() {
        laserPrinter.printDocument(document1);
        laserPrinter.printDocument(document2);
        laserPrinter.printDocument(document3);
        laserPrinter.printDocument(document4);
        laserPrinter.printDocument(document5);
        System.out.println(name + " has completed printing it's documents\n");
    }

}
