package org.spel.player;

public interface Player {
    String getName();

    int getTotalWins();

    String makeMove();

    void setTotalWins(int totalwins);

    void incrementTotalWins();
}
