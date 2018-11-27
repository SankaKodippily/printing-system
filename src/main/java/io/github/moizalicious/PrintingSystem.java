package io.github.moizalicious;

import io.github.moizalicious.printer.LaserPrinter;
import io.github.moizalicious.student.Student;
import io.github.moizalicious.technician.PaperTechnician;
import io.github.moizalicious.technician.TonerTechnician;

public class PrintingSystem {

    public static void main(String[] args) {
        LaserPrinter laserPrinter = new LaserPrinter("LP001");

        ThreadGroup students = new ThreadGroup("students");
        ThreadGroup technicians = new ThreadGroup("technicians");

        Student student1 = new Student("Student 1", laserPrinter, students);
        student1.start();
        Student student2 = new Student("Student 2", laserPrinter, students);
        student2.start();
        Student student3 = new Student("Student 3", laserPrinter, students);
        student3.start();
        Student student4 = new Student("Student 4", laserPrinter, students);
        student4.start();

        PaperTechnician paperTechnician = new PaperTechnician("Paper Man", laserPrinter, technicians);
        paperTechnician.start();
        TonerTechnician tonerTechnician = new TonerTechnician("Toner Man", laserPrinter, technicians);
        tonerTechnician.start();

        while (students.activeCount() > 0) {
            // DO NOTHING
            continue;
        }
        if (technicians.activeCount() > 0) {
            // TODO interupt the technicians thread group
        }
        System.out.println("Final Laser Printer Status After All Documents Printed:");
        System.out.println(laserPrinter.toString());
        System.exit(0);
    }

}
