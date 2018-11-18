package io.github.moizalicious;

import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.student.Student;
import io.github.moizalicious.technician.PaperTechnician;
import io.github.moizalicious.technician.TonerTechnician;

public class PrintingSystem {

    public static void main(String[] args) {
        LaserPrinter laserPrinter = new LaserPrinter("LP001");

        Student student1 = new Student("Student 1", laserPrinter);
        student1.start();
        Student student2 = new Student("Student 2", laserPrinter);
        student2.start();
        Student student3 = new Student("Student 3", laserPrinter);
        student3.start();
        Student student4 = new Student("Student 4", laserPrinter);
        student4.start();

        PaperTechnician paperTechnician = new PaperTechnician("Paper Man", laserPrinter);
        paperTechnician.start();
        TonerTechnician tonerTechnician = new TonerTechnician("Toner Man", laserPrinter);
        tonerTechnician.start();
    }

}
