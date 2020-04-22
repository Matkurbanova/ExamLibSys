package com.exam.ExamLibSys.repositories;


import com.exam.ExamLibSys.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.authorId = ?1")
    List<Order> findByAuthorId(long authorId);
}
