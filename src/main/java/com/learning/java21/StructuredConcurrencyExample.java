package com.learning.java21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        try(var structured= new StructuredTaskScope.ShutdownOnFailure()){
            var task1=structured.fork(()->"task1 returning");
            var task2=structured.fork(()->"tase2 returning");
            structured.join();
            structured.throwIfFailed();

            System.out.println(task1.get());
            System.out.println(task2.get());

        }
    }
}
