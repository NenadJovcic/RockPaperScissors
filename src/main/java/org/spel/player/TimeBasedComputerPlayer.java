package org.spel.player;


import org.spel.game.Choice;

import java.time.LocalTime;


public class TimeBasedComputerPlayer implements Player{
    private final String name;
    private int totalWins;

    public TimeBasedComputerPlayer() {
        this.name = "Klockis";
    }

    @Override
    public Choice makeMove() {
        int l = LocalTime.now().getSecond();

        if (l < 20) {
            return Choice.STEN;
        }else if (l >= 20 && l <= 40) {
            return Choice.SAX;
        }
        return Choice.PÅSE;
    }

    @Override
    public void incrementTotalWins() {
        totalWins++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalWins() {
        return totalWins;
    }
}
