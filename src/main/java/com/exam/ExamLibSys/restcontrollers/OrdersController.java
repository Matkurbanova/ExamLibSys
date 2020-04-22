package com.exam.ExamLibSys.restcontrollers;


import com.exam.ExamLibSys.entities.Order;
import com.exam.ExamLibSys.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    OrderRepo orderRepo;

    @RequestMapping("/{uid}")
    public Iterable<Order> getOrders(@PathVariable("uid") int authorId) {
        return orderRepo.findByAuthorId(authorId);
    }

}
