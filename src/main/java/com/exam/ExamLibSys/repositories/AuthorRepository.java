package com.exam.ExamLibSys.repositories;


import com.exam.ExamLibSys.entities.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Integer> {

        @Query("SELECT u FROM Author u WHERE u.email=?1 AND u.password=?2")
        Author getByEmailAndPass(String email,String password);

    }
