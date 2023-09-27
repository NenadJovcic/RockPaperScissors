package org.spel.player;


import java.time.LocalTime;


public class TimeBasedComputerPlayer implements Player{
    private String name;
    private int totalWins;

    public TimeBasedComputerPlayer() {
        this.name = "Klockis";
    }

    @Override
    public String makeMove() {
        int l = LocalTime.now().getSecond();

        if (l < 20) {
            return "sten";
        }else if (l >= 20 && l <= 40) {
            return "sax";
        }
        return "påse";
    }

    @Override
    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
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
