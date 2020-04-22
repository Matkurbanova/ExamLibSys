package com.exam.ExamLibSys.restcontrollers;

import com.exam.ExamLibSys.entities.Author;
import com.exam.ExamLibSys.entities.Book;
import com.exam.ExamLibSys.entities.Order;
import com.exam.ExamLibSys.repositories.AuthorRepository;
import com.exam.ExamLibSys.repositories.BookRepository;
import com.exam.ExamLibSys.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    AuthorRepository authorRepository;
    @RequestMapping("/author")
    public Iterable<Author>getAuthors() {
        return authorRepository.findAll();
    }
    @Autowired
    BookRepository bookRepository;
    @RequestMapping("/book")
    public Iterable<Book>getBook()
    {
        return bookRepository.findAll();
    }
    @Autowired
    OrderRepo orderRepo;
    @RequestMapping("/orders")
    public Iterable<Order>getOrders()
    {
        return orderRepo.findAll();
    }
}