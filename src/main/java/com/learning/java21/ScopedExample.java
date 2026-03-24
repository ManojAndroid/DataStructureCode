package com.learning.java21;


import java.lang.ScopedValue;

public class ScopedExample {
// avaulable in 23
static ScopedValue<String> USER = ScopedValue.newInstance();
    public static void main(String[] args) {
        ScopedValue.where(USER, "Manoj").run(() -> {
            System.out.println(USER.get());
        });
    }

}
