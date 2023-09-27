package org.spel.player;

public class NamedComputerPlayer implements Player {
    private String playerName;
    private String name;
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
    public String makeMove() {
        if (playerName.charAt(0) > 'G' && playerName.charAt(0) < 'L') {
            return "sten";
        } else if (playerName.charAt(0) > 'L' && playerName.charAt(0) < 'O') {
            return "sax";
        }
        return "påse";
    }

    @Override
    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
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
