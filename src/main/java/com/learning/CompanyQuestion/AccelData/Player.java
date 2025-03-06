package com.learning.CompanyQuestion.AccelData;

public class Player {
    int position;

    String playrName;
    boolean done = false;

    public Player(int position, boolean done, String name) {
        this.position = position;
        this.done = done;
        this.playrName = name;
    }

}
