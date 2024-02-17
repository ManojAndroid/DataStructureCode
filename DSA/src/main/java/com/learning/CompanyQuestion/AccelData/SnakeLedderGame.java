package com.learning.CompanyQuestion.AccelData;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SnakeLedderGame {

    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ledders;

    private int boardSize;

    public SnakeLedderGame(int boardSize) {
        this.boardSize = boardSize;
    }

    public SnakeLedderGame() {
    }

    protected void addSnakesPosition(Map<Integer, Integer> snakesPosition) {
        this.snakes = new HashMap<>(snakesPosition);
    }

    protected void addLeddersPosition(Map<Integer, Integer> leddersPosition) {
        this.ledders = new HashMap<>(leddersPosition);
    }

    protected int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    protected int movePlayer(Player player, int steps) {
        int newPosition = player.position + steps;
        if (newPosition > boardSize) {
            System.out.println("You will win when get " + (boardSize - player.position));
            return player.position;
        }

        int newPositionAfterSnakeLedder = checkSnakeAndLeder(newPosition);
        System.out.println("Your current position " + newPositionAfterSnakeLedder);
        return newPositionAfterSnakeLedder;
    }

    protected int checkSnakeAndLeder(int position) {
        if (snakes.containsKey(position)) {
            System.out.println(" Snake is there you position will go down");
            return snakes.get(position);
        }
        if (ledders.containsKey(position)) {
            System.out.println("  There is ledder your position will go up ");
            return ledders
                    .get(position);
        }
        return position;

    }


    protected void play(Player player) {
        if (player.position < boardSize) {
            System.out.println(" role the dic");
            int rolledValue = rollDice();
            System.out.println(" your rolled Value" + rolledValue);
            player.position = movePlayer(player, rolledValue);
        } else if (player.position == boardSize) {
            System.out.println(" conguratulations you have reachecd name " + player.playrName);
        }
    }

    protected boolean isInValidInput(Map<Integer, Integer> snakes, Map<Integer, Integer> ledder) {
        AtomicBoolean isLoopPresent = new AtomicBoolean(false);
        snakes.forEach((k, v) -> {
            if (ledder.containsValue(v)) {
                isLoopPresent.set(true);
            }
        });
        return isLoopPresent.get();
    }


    public static void main(String[] args) {
        int bordSize = 100;
        SnakeLedderGame snakeLedderGame = new SnakeLedderGame(bordSize);
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(16, 6);
        snakes.put(64, 40);
        snakes.put(93, 70);

        Map<Integer, Integer> ledder = new HashMap<>();
        ledder.put(10, 38);
        ledder.put(71, 95);

        if (snakeLedderGame.isInValidInput(snakes, ledder)) {
            System.out.println(" there is loop between snake and ledder please correct");
        }

        snakeLedderGame.addSnakesPosition(snakes);
        snakeLedderGame.addLeddersPosition(ledder);

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(0, Boolean.FALSE, "Akash"));
        playerList.add(new Player(0, Boolean.FALSE, "Vikash"));
        playerList.add(new Player(0, Boolean.FALSE, "Raj"));
        playerList.add(new Player(0, Boolean.FALSE, "Karan"));

        List<String> complatedPlayes = new LinkedList<>();
        while (complatedPlayes.size() < playerList.size()) {
            for (Player player : playerList) {
                if (player.position < bordSize && !player.done) {
                    snakeLedderGame.play(player);
                }
                else if (player.position == bordSize) {
                    playerList.remove(player);
                    complatedPlayes.add(player.playrName);
                    System.out.println("player: " + player.playrName);
                }

            }


        }
        System.out.println(" game has been completed");


    }


}
