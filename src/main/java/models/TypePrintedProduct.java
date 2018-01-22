package models;

import java.io.Serializable;

public class TypePrintedProduct implements Serializable {

    private Long id;
    private String nameType;

    public TypePrintedProduct() {
    }

    public TypePrintedProduct(String nameType) {
        this.nameType = nameType;
    }

    public TypePrintedProduct(Long id, String nameType) {
        this.id = id;
        this.nameType = nameType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
