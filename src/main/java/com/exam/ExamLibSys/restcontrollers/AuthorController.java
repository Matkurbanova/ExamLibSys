package com.exam.ExamLibSys.restcontrollers;


import com.exam.ExamLibSys.data.Response;
import com.exam.ExamLibSys.entities.Author;
import com.exam.ExamLibSys.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
@Autowired
AuthorRepository authorRepository;
@RequestMapping(value = "/email",method = RequestMethod.POST)
    public Response email(
        @RequestBody Author author
        ){
Response response=new Response();
Author userDb=authorRepository.getByEmailAndPass(author.email,author.password);
if(userDb!=null){
    response.status=1000;
response.data=userDb;

}else
{
response.status=5000;
response.message="User Not Found";
}
return response;
}

}
