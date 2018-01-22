package dao;

import models.TypePrintedProduct;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TypePrintedProductDAO {

    private Long id;
    private String filename;

    public TypePrintedProductDAO() {
        filename = "TypePrintedProduct.dat";

        if (getAll().size() == 0) {
            id = 0L;
        } else {
            id = getAll().get(getAll().size() - 1).getId();
        }
    }

    public ArrayList<TypePrintedProduct> getAll() {
        ArrayList<TypePrintedProduct> typePrintedProducts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            typePrintedProducts = (ArrayList<TypePrintedProduct>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return typePrintedProducts;
    }

    public void insert(TypePrintedProduct typePrintedProduct) {
        ArrayList<TypePrintedProduct> temp = new ArrayList<>();
        temp.addAll(getAll());
        temp.add(new TypePrintedProduct(++id, typePrintedProduct.getNameType()));
        insert(temp);
    }


    public void insert(ArrayList<TypePrintedProduct> typePrintedProducts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(typePrintedProducts);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
