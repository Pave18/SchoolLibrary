package bal;

import models.PrintedProduct;
import models.Student;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Reports {

    TypePrintedProductManager tppManager;
    StudentManager sManager;
    PrintedProductManager ppManager;

    public Reports() {
        tppManager = new TypePrintedProductManager();
        sManager = new StudentManager();
        ppManager = new PrintedProductManager();
    }

    public String reportOne() {
        ArrayList<PrintedProduct> printedProductsFree = new ArrayList<>();


        for (PrintedProduct pp : ppManager.getAll()) {
            if (pp.getStudent().getId() == null) {
                printedProductsFree.add(pp);
            }
        }

        //Create string report
        StringBuilder reportString = new StringBuilder();

        for (PrintedProduct p : printedProductsFree) {
            reportString.append("\n [id: ").append(p.getId())
                    .append("; Type: ").append(p.getType().getNameType())
                    .append("; Title: ").append(p.getTitle())
                    .append("; Author: ").append(p.getAuthor())
                    .append("]");
        }

        reportString.append("\n\n");
        return reportString.toString();
    }

    public String reportTwo() {
        ArrayList<Student> temp = sManager.getAll();
        Collections.sort(temp, Student.COMPARISON_NUMBER_OF_BOOKS);


        ArrayList<Student> students = new ArrayList<>();
        for (Student s : temp) {
            if (s.getAmountOfBooks().size() > 0) {
                students.add(s);
            }
        }


        //Create string report
        StringBuilder reportString = new StringBuilder();

        for (Student s : students) {
            reportString.append("\n [Name: ").append(s.getfName()).append(" ").append(s.getlName())
                    .append("; Amount of books: ").append(s.getPrintedProducts().size())
                    .append("]");
        }

        reportString.append("\n\n");
        return reportString.toString();
    }


    public String reportThree() {
        ArrayList<Student> temp = sManager.getAll();
        Collections.sort(temp);

        ArrayList<Student> students = new ArrayList<>();
        for (Student s : temp) {
            if (s.getPrintedProducts().size() <= 2) {
                students.add(s);
            }
        }

        //Create string report
        StringBuilder reportString = new StringBuilder();

        for (Student s : students) {
            reportString.append("\n [Name: ").append(s.getfName()).append(" ").append(s.getlName())
                    .append("; Birthday: ").append(convertDataToString(s.getbDay()))
                    .append("; Amount of books: ").append(s.getPrintedProducts().size())
                    .append("]");
        }

        reportString.append("\n\n");
        return reportString.toString();
    }

    private String convertDataToString(Date date) {
        return DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
    }
}
