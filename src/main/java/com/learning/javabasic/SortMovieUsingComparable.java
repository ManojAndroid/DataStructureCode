package com.learning.javabasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMovieUsingComparable implements Comparable<SortMovieUsingComparable> {

    int rating;
    String name;
    public SortMovieUsingComparable(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }

   /* @Override
    public int compareTo(SortMovieUsingComparable o) {
        return -(this.rating-o.rating);// sort in reverse order
    }*/

    @Override
    public int compareTo(SortMovieUsingComparable o) {
        return (this.rating-o.rating);
    }

    public static void main(String[] args) {
        List<SortMovieUsingComparable> movieList=new ArrayList<>();
        movieList.add(new SortMovieUsingComparable(1,"A"));
        movieList.add(new SortMovieUsingComparable(-1,"b"));
        movieList.add(new SortMovieUsingComparable(-4,"c"));
        movieList.add(new SortMovieUsingComparable(3,"d"));
        Collections.sort(movieList);
        for (SortMovieUsingComparable movie:movieList){
            System.out.println(movie.name+" "+movie.rating);
        }
        System.out.println(" ----------------- ");
        Collections.sort(movieList,Collections.reverseOrder());
        for (SortMovieUsingComparable movie:movieList){
            System.out.println(movie.name+" "+movie.rating);
        }
        SortMovieUsingComparator sortMovieUsingComparator=new SortMovieUsingComparator();
        Collections.sort(movieList,sortMovieUsingComparator);
        //Collections.sort(movieList, Comparator.comparing(o -> o.name));//java 8

        for (SortMovieUsingComparable movie:movieList){
            System.out.println(movie.name+" "+movie.rating);
        }
    }
}
