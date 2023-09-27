package org.spel.player;

import java.util.Random;

public class RandomComputerPlayer implements Player {
    private String name;
    private int totalWins;
    private static final String[] moves = {"sten", "sax", "påse"};
    private Random random = new Random();

    public RandomComputerPlayer() {
        this.name = "Slumpis";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalWins() {
        return totalWins;
    }

    @Override
    public String makeMove() {
        return moves[random.nextInt(moves.length)];
    }

    @Override
    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }
    @Override
    public void incrementTotalWins() {
        totalWins++;
    }

}
