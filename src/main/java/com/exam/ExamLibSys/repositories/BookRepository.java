package com.exam.ExamLibSys.repositories;

import com.exam.ExamLibSys.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByType(int type);}
