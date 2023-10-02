package org.spel.player;

import org.spel.game.Choice;

public class NamedComputerPlayer implements Player {
    private final String playerName;
    private final String name;
    private int totalWins;

    public NamedComputerPlayer(String playerName) {
        this.name = "Namnis";
        this.playerName = makeFirstLetterCapital(playerName);
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
        if (playerName.charAt(0) > 'G' && playerName.charAt(0) < 'L') {
            return Choice.STEN;
        } else if (playerName.charAt(0) > 'L' && playerName.charAt(0) < 'O') {
            return Choice.SAX;
        }
        return Choice.PÅSE;
    }


    private String makeFirstLetterCapital(String name) {
        if (name.isEmpty()) return null;
        StringBuilder newName = new StringBuilder(name);

        return newName.replace(0, 1, String.valueOf(Character.toUpperCase(name.charAt(0)))).toString();
    }
    @Override
    public void incrementTotalWins() {
        totalWins++;
    }


}
