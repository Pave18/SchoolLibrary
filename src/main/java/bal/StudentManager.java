package bal;

import dao.PrintedProductDAO;
import dao.StudentDAO;
import models.PrintedProduct;
import models.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StudentManager {

    private StudentDAO dao;

    public StudentManager() {
        dao = new StudentDAO();

        //Creates a file if it does not exist.
        if (emptyTypePrintedProducts()) {
            dao.updateAll(new ArrayList<Student>());
        }
    }

    public ArrayList<Student> getAll() {
        return dao.getAllStudents();
    }

    private boolean emptyTypePrintedProducts() {
        return dao.getAllStudents().size() == 0;
    }

    public void addStudent(String fName, String lName, int year, int month, int day) {
        dao.insert(new Student(fName, lName, getData(year, month, day)));
    }

    private Date getData(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return new Date(calendar.getTime().getTime());
    }

    public void addPrintedProduct(Student student, PrintedProduct printedProduct) {
        PrintedProductDAO ppDao = new PrintedProductDAO();

        ArrayList<Student> tempStudents = getAll();
        ArrayList<PrintedProduct> tempPrintedProducts = ppDao.getAll();


        for (Student s : tempStudents) {
            if (s.getId().equals(student.getId())) {
                s.addPrintedProduct(printedProduct);

                //Find PrintedProduct and add student
                for (PrintedProduct pp : tempPrintedProducts) {
                    if (pp.getId().equals(printedProduct.getId())) {
                        pp.setStudent(s);
                    }
                }
            }
        }

        dao.updateAll(tempStudents);
        ppDao.updateAll(tempPrintedProducts);
    }
}
