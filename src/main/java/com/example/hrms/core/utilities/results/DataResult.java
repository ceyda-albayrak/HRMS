package com.example.hrms.core.utilities.results;

public class DataResult<T> extends Result {
    private T data;
    public DataResult(T data,boolean success, String message) {
        super(success, message); //base sınıfın(Result) constructorlarını çalıştırıyor
        this.data=data;
    }

    public DataResult(T data,boolean success) {
        super(success); //base sınıfın(Result) constructorlarını çalıştırıyor
        this.data=data;
    }


    public T getData() { return this.data;}

}
