package org.spel.player;


import java.util.Scanner;

public class HumanPlayer implements Player {

    private String name;
    private int totalWins;
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        this.name = name;
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
        System.out.print(name + ", välj sten, sax eller påse: ");
        String choice;
        do {
            choice = scanner.next();
        } while (!isValidChoice(choice));
        return choice;
    }

    @Override
    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    @Override
    public void incrementTotalWins() {
        totalWins++;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isValidChoice(String choice) {
        return choice.equals("sten") || choice.equals("sax") || choice.equals("påse");
    }
}
