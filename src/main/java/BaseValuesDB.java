import bal.PrintedProductManager;
import bal.StudentManager;
import bal.TypePrintedProductManager;
import models.PrintedProduct;
import models.Student;
import models.TypePrintedProduct;

import java.util.ArrayList;

public class BaseValuesDB {

    public BaseValuesDB() {
        TypePrintedProductManager tppManager = new TypePrintedProductManager();
        if (tppManager.getAll().size() == 0) {
            tppManager.addType("Book");
            tppManager.addType("Article");
            tppManager.addType("Journal ");
            tppManager.addType("Newspaper");
        }
        ArrayList<TypePrintedProduct> typePrintedProductArrayList = tppManager.getAll();

        StudentManager sManager = new StudentManager();
        if (sManager.getAll().size() == 0) {
            sManager.addStudent("Felix", "Potter", 2002, 11, 30);
            sManager.addStudent("Robert", "Nort", 2000, 6, 13);
            sManager.addStudent("Alex", "Lain", 2002, 4, 25);
            sManager.addStudent("Fill", "Paul", 2002, 11, 30);
        }
        ArrayList<Student> studentArrayList = sManager.getAll();


        PrintedProductManager ppManager = new PrintedProductManager();
        if (ppManager.getAll().size() == 0) {
            ppManager.addPrintProduct(typePrintedProductArrayList.get(0), "Mathematics", "Arnold Valun", 2015);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(0), "Physics", "Bill Norsk", 2014);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(0), "World Literature", "Van Goi", 2016);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(0), "Design", "NYC-moda", 2018);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(0), "Design", "NYC-moda", 2017);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(0), "Pattern", "IBM", 2015);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(1), "Spring", "HabraHabra", 2018);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(3), "Java", "Oracle", 2018);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(2), "Android", "Google", 2018);
            ppManager.addPrintProduct(typePrintedProductArrayList.get(1), "TomCat", "Apache", 2018);

            ArrayList<PrintedProduct> printedProductArrayList = ppManager.getAll();

            sManager.addPrintedProduct(studentArrayList.get(0), printedProductArrayList.get(0));
            sManager.addPrintedProduct(studentArrayList.get(0), printedProductArrayList.get(3));
            sManager.addPrintedProduct(studentArrayList.get(1), printedProductArrayList.get(1));
            sManager.addPrintedProduct(studentArrayList.get(2), printedProductArrayList.get(2));
            sManager.addPrintedProduct(studentArrayList.get(2), printedProductArrayList.get(4));
            sManager.addPrintedProduct(studentArrayList.get(2), printedProductArrayList.get(5));
        }
    }
}
