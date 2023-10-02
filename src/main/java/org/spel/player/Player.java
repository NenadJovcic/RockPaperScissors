package org.spel.player;

import org.spel.game.Choice;

public interface Player {
    String getName();

    int getTotalWins();

    Choice makeMove();

    void incrementTotalWins();
}
