package org.spel.player;

import org.spel.game.Choice;

import java.util.Random;

public class RandomComputerPlayer implements Player {
    private final String name;
    private int totalWins;
    private static final Choice[] moves = {Choice.STEN, Choice.SAX, Choice.PÅSE};
    private final Random random = new Random();

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
    public Choice makeMove() {
        return moves[random.nextInt(moves.length)];
    }


    @Override
    public void incrementTotalWins() {
        totalWins++;
    }

}
