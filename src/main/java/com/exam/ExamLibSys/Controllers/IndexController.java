package com.exam.ExamLibSys.Controllers;


import com.exam.ExamLibSys.entities.Author;
import com.exam.ExamLibSys.entities.Book;
import com.exam.ExamLibSys.entities.Order;
import com.exam.ExamLibSys.repositories.AuthorRepository;
import com.exam.ExamLibSys.repositories.BookRepository;
import com.exam.ExamLibSys.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class IndexController {


    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderRepo orderRepo;

    @RequestMapping("/")
    public ModelAndView index(HttpSession session) {
        Map<String, String> data = new HashMap<>();
        data.put("message", "");
        if (session.getAttribute("author_id") != null) {


            return getBook(session);
        }

        return new ModelAndView("index", data);
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ModelAndView hello(

            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            Map<String, String> model,
            HttpSession session
    ) {
        Author author = authorRepository.getByEmailAndPass(email, password);
        if (author != null) {
            session.setAttribute("user_id", author.id);
            return getBook(session);
        } else
            model.put("message", "Wrong email or password");
        return new ModelAndView("index");

    }


    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ModelAndView getBook(HttpSession session) {
        Iterable<Book> book = bookRepository.findAll();

        Iterable<Book> bookjava= bookRepository.findByType(1);
        Iterable<Book> bookTemp =bookRepository.findByType(2);

        Map<String, Object> model = new HashMap<>();
        model.put("book", book);
        model.put("logedin", session.getAttribute("author_id") != null);
        model.put("book", bookjava);
        model.put("temp", bookTemp);


        return new ModelAndView("book", model);
    }

    @RequestMapping(value = "/book/{type}", method = RequestMethod.GET)
    public ModelAndView getTemp(
            @PathVariable("type") String type
    ) {
        Map<String, Object> model = new HashMap<>();
        if (type.equals("java")) {
            Iterable<Book> book = bookRepository.findByType(1);
            model.put("book", book);
            model.put("bookTitle", "JAVA");
        } else if (type.equals("business")) {
            Iterable<Book> book = bookRepository.findByType(2);
            model.put("book", book);
            model.put("bookTitle", "Бизнес");


        } else if (type.equals("all books")) {
            Iterable<Book> book =bookRepository.findAll();
            model.put("book", book);
            model.put("bookTitle", "Все книги");

        }
        return new ModelAndView("book", model);
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public ModelAndView addBook() {
        return new ModelAndView("addBook");
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public ModelAndView addMenu(
            @RequestParam("title") String title,
            @RequestParam("publish_date") Date publish_date,
            @RequestParam("quantity") int quantity,
            @RequestParam("image") String image,
            @RequestParam("type")int type



    ) {
        Book book = new Book();
        book.title = title;
        book.publish_date = publish_date;
        book.quantity = quantity;
        book.image = image;
        book.type=type;

        bookRepository.save(book);
        return new ModelAndView("addBook");
    }

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public String addToCart(
            @RequestParam("p_id") int bookId,
            Map<String, Object> model,
            HttpSession session
    ) {
        if (session.getAttribute("author_id") != null) {
            long authorId = (long) session.getAttribute("author_id");
            Book book = bookRepository.findById(bookId).get();
            Order order = new Order();
            order.bookId = bookId;
            order.authorId = authorId;
            order.status = 0;
            order.orderDate = LocalDateTime.now();

            orderRepo.save(order);
            model.put("message",book.title + " added");


        } else {
            model.put("message", "Войдите на сайт");

        }
        return "ok";


    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public RedirectView logout(HttpSession session) {
        session.removeAttribute("author_id");
        return new RedirectView("/");
    }

    //    Orders список заказов
    @RequestMapping(value = "/list-orders", method = RequestMethod.GET)
    public ModelAndView listOrders(Map<String, Object> model) {
        Iterable<Order> orders = orderRepo.findAll();
        model.put("listOrders", orders);

        return new ModelAndView("listOrders", model);
    }
}

