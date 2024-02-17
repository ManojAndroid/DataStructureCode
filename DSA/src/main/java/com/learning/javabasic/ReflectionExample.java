package com.learning.javabasic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    String name="manoj";
    void mainMethod(){
        System.out.println("mainMethod");
    }

    void mainMethod2(){
        System.out.println("mainMethod2");
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        ReflectionExample reflectionExample=new ReflectionExample();
        Field field=ReflectionExample.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(reflectionExample,"hshshs");
        System.out.println(reflectionExample.name);

     /*   Method method=ReflectionExample.class.getDeclaredMethod("mainMethod");
        Method method2=ReflectionExample.class.getDeclaredMethod("mainMethod2");
        method.setAccessible(true);
        field.set(reflectionExample,method2);
        //reflectionExample.mainMethod();
*/
    }
}
