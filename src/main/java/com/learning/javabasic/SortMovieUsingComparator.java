package com.learning.javabasic;

import java.util.Comparator;

public class SortMovieUsingComparator implements Comparator<SortMovieUsingComparable> {
    @Override
    public int compare(SortMovieUsingComparable o1, SortMovieUsingComparable o2) {
        return o1.name.compareTo(o2.name);
    }
}
