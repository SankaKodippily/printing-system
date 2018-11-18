package io.github.moizalicious.printer;

import io.github.moizalicious.document.Document;
import io.github.moizalicious.sleeper.ThreadSleeper;

public class LaserPrinter implements ServicePrinter {

    private String printerId;
    private int paperLevel;
    private int tonerLevel;
    private int documentsPrinted;

    public LaserPrinter( String printerId) {
        this.printerId = printerId;
        this.paperLevel = Full_Paper_Tray;
        this.tonerLevel =  Full_Toner_Level;
        this.documentsPrinted = 0;
    }

    @Override
    public synchronized void replaceTonerCartridge() {
        if (tonerLevel < Minimum_Toner_Level) {
            tonerLevel = PagesPerTonerCartridge;
            System.out.println("Toner Replaced Successfully, Toner Level: " + tonerLevel + "\n");
            ThreadSleeper.sleep(2000);
        } /*else {
            // TODO check whether this is actually needed
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            replaceTonerCartridge();
            System.out.println("Passed Wait For Toner");
        }*/
        notifyAll();

    }

    @Override
    public synchronized void refillPaper() {
        if (paperLevel < 200) {
            paperLevel = paperLevel + SheetsPerPack;
            System.out.println("Paper Refilled Successfully, Paper Level: " + paperLevel + "\n");
            ThreadSleeper.sleep(2000);
        } /*else {
            // TODO check whether this is actually needed
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            refillPaper();
            System.out.println("Passed Wait For Refill");
        }*/
        notifyAll();

    }

    @Override
    public synchronized void printDocument(Document document) {
        while (!(paperLevel > document.getNumberOfPages() && tonerLevel > document.getNumberOfPages() * 2)) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        paperLevel = paperLevel - document.getNumberOfPages();
        tonerLevel = tonerLevel - (document.getNumberOfPages() * 2);
        documentsPrinted++;
        System.out.println(document.getDocumentName() + " by " + document.getUserID() + " printed successfully");
        System.out.println(document.toString());
        System.out.println(toString() + "\n");
        ThreadSleeper.sleep(2000);
        notifyAll();
    }

    public String toString() {
        return "[ Printer ID: " + printerId +
                ", Paper Level: " + paperLevel +
                ", Toner Level: " + tonerLevel +
                ", Documents Printed: " + documentsPrinted + " ]";
    }

}
