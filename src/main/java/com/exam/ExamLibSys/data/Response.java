package com.exam.ExamLibSys.data;

public class Response {
    public int status;
    public String message;
    public Object data;

    public Response(){
    }
    public Response(int status, String message, Object data){
        this.status=status;
        this.message=message;
        this.data=data;

    }

}

