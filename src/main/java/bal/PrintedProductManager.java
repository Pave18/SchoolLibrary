package bal;

import dao.PrintedProductDAO;
import models.PrintedProduct;
import models.TypePrintedProduct;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PrintedProductManager {

    private PrintedProductDAO dao;

    public PrintedProductManager() {
        dao = new PrintedProductDAO();

        //Creates a file if it does not exist.
        if (emptyTypePrintedProducts()) {
            dao.updateAll(new ArrayList<PrintedProduct>());
        }
    }

    public ArrayList<PrintedProduct> getAll() {
        return dao.getAll();
    }

    private boolean emptyTypePrintedProducts() {
        return dao.getAll().size() == 0;
    }

    public void addPrintProduct(TypePrintedProduct type, String title, String author, int year) {
        dao.insert(new PrintedProduct(type, title, author, getData(year)));
    }

    private Date getData(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 1, 1);
        return new Date(calendar.getTime().getTime());
    }
}
