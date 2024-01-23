package com.learning.CompanyQuestion.angleOne;

import java.util.Random;

public class test {


    public static  String playRandomSong() {
        String[] songs = {"song1", "song2", "song3"};
        Random rand = new Random();
        boolean [] playList = new boolean[songs.length];
        String result="";
        int i = 0;
        int n=songs.length;
       while(i<n){
           int randomIndex = rand.nextInt(songs.length);
              if(playList[randomIndex]==false) {
                  playList[randomIndex] = true;
                  i++;
                 return songs[randomIndex];
              }
              else {
                  while(randomIndex <playList.length){
                      if(playList[randomIndex]==true) {
                          randomIndex++;
                      }
                      return songs[randomIndex];

                  }
              }
        }
       return  result;

    }
    public static void main(String[] args) {

        System.out.println(playRandomSong());

    }

}
