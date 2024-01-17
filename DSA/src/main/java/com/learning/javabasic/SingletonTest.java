package com.learning.javabasic;

public class SingletonTest {
    private static volatile SingletonTest singletonTest = null;

    private SingletonTest(){
    }

    public static SingletonTest getInstance() {
        if (singletonTest == null)
            singletonTest = new SingletonTest();
        return singletonTest;
    }

    public static SingletonTest getInstanceDoubleCheck() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                if (singletonTest == null)
                    singletonTest = new SingletonTest();
            }
        }
        return singletonTest;
    }

    public static void main(String[] args) {
        SingletonTest singletonTest = SingletonTest.getInstance();
        System.out.println(singletonTest);
        SingletonTest singletonTest1 = SingletonTest.getInstance();
        System.out.println(singletonTest1);
    }
}
