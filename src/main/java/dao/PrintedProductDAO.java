package dao;

import models.PrintedProduct;
import models.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PrintedProductDAO {

    private Long id;
    private String filename;

    public PrintedProductDAO() {
        filename = "PrintedProduct.dat";

        if (getAll().size() == 0) {
            id = 0L;
        } else {
            id = getAll().get(getAll().size() - 1).getId();
        }
    }

    public ArrayList<PrintedProduct> getAll() {
        ArrayList<PrintedProduct> typePrintedProducts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            typePrintedProducts = (ArrayList<PrintedProduct>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return typePrintedProducts;
    }

    public void insert(PrintedProduct printedProduct) {
        ArrayList<PrintedProduct> temp = new ArrayList<>();
        temp.addAll(getAll());
        temp.add(new PrintedProduct(++id, printedProduct.getType(), printedProduct.getTitle(),
                printedProduct.getAuthor(), printedProduct.getDate(), new Student()));
        updateAll(temp);
    }


    public void updateAll(ArrayList<PrintedProduct> typePrintedProducts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(typePrintedProducts);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
