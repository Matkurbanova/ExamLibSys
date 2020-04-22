package com.exam.ExamLibSys.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
//@NamedQuery(name = "find all books", query = "select p from Book p")
public class Book {

    @Id
    @GeneratedValue

    public int id;

    public String title;
    public Date publish_date;
    public int quantity;
    public String image;
    public int type;


//    public Book(){}
//
//    public Book(String title, Date publish_date, int quantity,String image) {
//        this.title = title;
//        this.publish_date = publish_date;
//        this.quantity = quantity;
//        this.image=image;
//
//    }
//
//    public Book(int id, String title, Date publish_date, int quantity,String image) {
//        this.id=id;
//        this.title = title;
//        this.publish_date = publish_date;
//        this.quantity = quantity;
//        this.image=image;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Date getPublish_date() {
//        return publish_date;
//    }
//
//    public void setPublish_date(Date publish_date) {
//        this.publish_date = publish_date;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("\nBook [id=%d] [title='%s'] [publish_date='%s'] [quantity=%s]", id, title, publish_date, quantity);
//    }
}