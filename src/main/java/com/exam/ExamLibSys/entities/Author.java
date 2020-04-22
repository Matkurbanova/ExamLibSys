package com.exam.ExamLibSys.entities;

import javax.persistence.*;

@Entity
@Table(name="author")

//@NamedQuery(name = "find all authors", query = "select p from Author p")
public class Author {

    @Id
    @GeneratedValue
    public int id;

    public String name;
    public String surname;
    public String email;
    public String password;

//    public Author() {
//    }
//
//    public Author(String name, String surname, String email, String password){
//        this.name=name;
//        this.surname=surname;
//        this.email=email;
//        this.password=password;
//    }
//
//    public Author(int id, String name, String surname, String email, String password){
//        this.id=id;
//        this.name=name;
//        this.surname=surname;
//        this.email=email;
//        this.password=password;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("\nAuthor [id=%d] [name='%s'] [surname='%s'] [email=%s] [password=%s]", id, name, surname, email, password);
//    }
}