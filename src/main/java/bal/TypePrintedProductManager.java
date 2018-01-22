package bal;

import dao.TypePrintedProductDAO;
import models.TypePrintedProduct;

import java.util.ArrayList;

public class TypePrintedProductManager {

    private TypePrintedProductDAO dao;

    public TypePrintedProductManager() {
        dao = new TypePrintedProductDAO();

        //Creates a file if it does not exist.
        if (emptyTypePrintedProducts()) {
            dao.insert(new ArrayList<TypePrintedProduct>());
        }
    }

    public ArrayList<TypePrintedProduct> getAll() {
        return dao.getAll();
    }

    private boolean emptyTypePrintedProducts() {
        return dao.getAll().size() == 0;
    }

    public void addType(String type) {
        dao.insert(new TypePrintedProduct(type));
    }
}
