package models;

import java.io.Serializable;
import java.util.Date;

public class PrintedProduct implements Serializable {

    private Long id;

    private TypePrintedProduct type;

    private String title;

    private String author;

    private Date date;

    private Student student;

    public PrintedProduct() {
    }

    public PrintedProduct(TypePrintedProduct type, String title, String author, Date date) {
        this.type = type;
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public PrintedProduct(Long id, TypePrintedProduct type, String title, String author, Date date, Student student) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.author = author;
        this.date = date;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypePrintedProduct getType() {
        return type;
    }

    public void setType(TypePrintedProduct type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
