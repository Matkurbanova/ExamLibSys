package com.exam.ExamLibSys.restcontrollers;


import com.exam.ExamLibSys.Statics;
import com.exam.ExamLibSys.data.Response;
import com.exam.ExamLibSys.entities.Author;
import com.exam.ExamLibSys.entities.Book;
import com.exam.ExamLibSys.entities.Order;
import com.exam.ExamLibSys.repositories.BookRepository;
import com.exam.ExamLibSys.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private OrderRepo orderRepo;

    @RequestMapping("/book")
    public Iterable<Book> getBook() {
        return bookRepository.findAll();

    }

    @RequestMapping("/book/{type}")
    public Iterable<Book> getMenu(@PathVariable int type) {
        return bookRepository.findByType(type);

    }

    @RequestMapping(value = "add-to-cart/{book_id}", method = RequestMethod.POST)
    public Response addToCart(
            @PathVariable("book_id") int bookId,
            @RequestBody Author author

    ) {
        Response response = new Response();
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            Order order = new Order();
            order.authorId = author.id;
            order.bookId = bookId;
            orderRepo.save(order);
            response.status = Statics.OK;
            response.data = book.get();


        } else {
            response.status = Statics.NOT_FOUND;
            response.message = "Book not found";
        }
        return response;
    }
}
