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
            notifyAll();
//            ThreadSleeper.sleep(2000);
        } else {
            // TODO check whether this is actually needed
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
//            System.out.println("Unable To Replace Toner: Toner Level - " + tonerLevel + "\n");
        }
    }

    @Override
    public synchronized void refillPaper() {
        if (paperLevel < 200) {
            paperLevel = paperLevel + SheetsPerPack;
            System.out.println("Paper Refilled Successfully, Paper Level: " + paperLevel + "\n");
            notifyAll();
//            ThreadSleeper.sleep(2000);
        } else {
            // TODO check whether this is actually needed
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
//            System.out.println("Unable To Refill Paper: Paper Level - " + paperLevel + "\n");
        }
    }

    @Override
    public synchronized void printDocument(Document document) {
        if (paperLevel > document.getNumberOfPages() && tonerLevel > document.getNumberOfPages()) {
            paperLevel = paperLevel - document.getNumberOfPages();
            tonerLevel = tonerLevel - document.getNumberOfPages();
            documentsPrinted++;
            System.out.println(document.getDocumentName() + " by " + document.getUserID() + " printed successfully");
            System.out.println(document.toString());
            System.out.println(toString() + "\n");
            notifyAll();
//            ThreadSleeper.sleep(2000);
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            // TODO replace with a while loop instead of using recursion
            printDocument(document);
            System.out.println("Unable To Print Document: Insufficient Toner/Paper Level");
            System.out.println(document.toString());
            System.out.println(toString() + "\n");
        }
    }

    public String toString() {
        return "[ Printer ID: " + printerId +
                ", Paper Level: " + paperLevel +
                ", Toner Level: " + tonerLevel +
                ", Documents Printed: " + documentsPrinted + " ]";
    }

}
