package dao;

import models.PrintedProduct;
import models.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentDAO {

    private Long id;
    private String filename;

    public StudentDAO() {
        filename = "Student.dat";
        if (getAllStudents().size() == 0) {
            id = 0L;
        } else {
            id = getAllStudents().get(getAllStudents().size() - 1).getId();
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> typePrintedProducts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            typePrintedProducts = (ArrayList<Student>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return typePrintedProducts;
    }

    public void insert(Student student) {
        ArrayList<Student> temp = new ArrayList<>();
        temp.addAll(getAllStudents());
        temp.add(new Student(++id, student.getfName(), student.getlName(), student.getbDay(), new ArrayList<PrintedProduct>()));
        updateAll(temp);
    }

    public void updateAll(ArrayList<Student> typePrintedProducts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(typePrintedProducts);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
