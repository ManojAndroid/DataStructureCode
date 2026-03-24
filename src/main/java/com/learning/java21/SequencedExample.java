package com.learning.java21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.SequencedCollection;

public class SequencedExample {
    public static void main(String[] args) {
        SequencedCollection<String> sq=new ArrayList<>();
        sq.add("manoj");
        sq.add("sa");
        System.out.println(sq.getFirst());
        System.out.println(sq.getLast());
        System.out.println("-------------------");
        sq.addFirst("first");
        sq.addLast("dd");
        System.out.println(sq.getFirst());
        System.out.println(sq.getLast());

    }
}
