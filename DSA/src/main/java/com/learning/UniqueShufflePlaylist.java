package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class UniqueShufflePlaylist {
   // private List<String> playlist;
    private List<String> shuffledPlaylist;
    private int currentIndex;

    public UniqueShufflePlaylist(List<String> playlist) {
       // this.playlist = new ArrayList<>(playlist);
        this.shuffledPlaylist = new ArrayList<>(playlist);
        shufflePlaylist();
        this.currentIndex = 0;
    }

    private void shufflePlaylist() {
        Collections.shuffle(shuffledPlaylist);
    }

    public void playNextSong() {
        if (currentIndex >= shuffledPlaylist.size()) {
            // If all songs have been played, reshuffle the playlist
            shufflePlaylist();
            currentIndex = 0;
        }

        // Play the next song
        String currentSong = shuffledPlaylist.get(currentIndex);
        System.out.println("Playing: " + currentSong);
        currentIndex++;
    }

    public static void main(String[] args) {
        List<String> playlist = Arrays.asList("Song1", "Song2", "Song3", "Song4", "Song5");
        UniqueShufflePlaylist uniqueShufflePlaylist = new UniqueShufflePlaylist(playlist);

        // Play the entire shuffled playlist
        for (int i = 0; i < playlist.size(); i++) {
            uniqueShufflePlaylist.playNextSong();
        }
    }
}
