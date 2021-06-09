package com.example.hrms.core.utilities.results;

public class Result //supertype(interface gibi ama tek basına da anlamı var)
         {
    private Boolean success;
    private String message;


    public Result(boolean success){
        this.success=success;
    }


    public Result(boolean success,String message){
        this(success);
        this.message=message;

    }

    public boolean isSuccess() {
        return this.success;
    }



    public String getMessage(){
        return this.message;
    }
}
