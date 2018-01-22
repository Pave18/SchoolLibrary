package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Student implements Serializable, Comparable<Student> {

    private Long id;
    private String fName;
    private String lName;
    private Date bDay;
    private ArrayList<PrintedProduct> printedProducts;

    public Student() {
        printedProducts = new ArrayList<>();
    }

    public Student(String fName, String lName, Date bDay) {
        this.fName = fName;
        this.lName = lName;
        this.bDay = bDay;
        printedProducts = new ArrayList<>();
    }

    public Student(Long id, String fName, String lName, Date bDay, ArrayList<PrintedProduct> printedProducts) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.bDay = bDay;
        this.printedProducts = printedProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public ArrayList<PrintedProduct> getPrintedProducts() {
        return printedProducts;
    }

    public void setPrintedProducts(ArrayList<PrintedProduct> printedProducts) {
        this.printedProducts = printedProducts;
    }

    public ArrayList<PrintedProduct> getAmountOfBooks() {
        String type = "Book";

        ArrayList<PrintedProduct> books = new ArrayList<>();

        for (PrintedProduct pp : getPrintedProducts()) {
            if (pp.getType().getNameType().equals(type)) {
                books.add(pp);
            }
        }

        return books;
    }

    public void addPrintedProduct(PrintedProduct printedProduct) {
        printedProducts.add(printedProduct);
    }

    public static final Comparator<Student> COMPARISON_NUMBER_OF_BOOKS = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAmountOfBooks().size() - o2.getAmountOfBooks().size();
        }
    };


    @Override
    public int compareTo(Student o) {
        try {
            if (convertData(getbDay()).getTime() < convertData(o.getbDay()).getTime()) return -1;
            if (convertData(getbDay()).getTime() > convertData(o.getbDay()).getTime()) return 1;
        } catch (Exception e) {
            System.out.println(e);
        }

        if (getAmountOfBooks().size() < o.getAmountOfBooks().size()) return 1;
        if (getAmountOfBooks().size() > o.getAmountOfBooks().size()) return -1;
        return 0;
    }

    private static Date convertData(Date date) throws ParseException {
        return new SimpleDateFormat("dd.MM.yyyy")
                .parse(DateFormat.getDateInstance(DateFormat.MEDIUM).format(date));
    }
}
