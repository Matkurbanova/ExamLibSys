package com.exam.ExamLibSys.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    public int id;

    @Column(name = "order_date", columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
    public LocalDateTime orderDate;

    @Column(name = "book_id")
    public int bookId;
    @Column(name = "author_id")
    public long authorId;
    @Column(name = "comment")
    public int comment;
    @Column(name = "time")
    public int time;
    @Column(name = "quantity")
    public int quantity;
    @Column(name = "status")
    //0-новый
    //1-готовится
    //2-готово
    public int status;
    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    public Book book;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    public Author author;

    public String getTime() {
        return orderDate.toString().substring(11, 16);
    }

    public String getOrderStatus() {
        switch (status) {
            case 0:
                return "New";
            case 1:
                return "In process";
            case 2:
                return "Done";
        }
        return "New";
    }
}
