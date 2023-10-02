package org.spel.player;


import org.spel.game.Choice;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private String name;
    private int totalWins;
    private final Scanner scanner = new Scanner(System.in);

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
    public Choice makeMove() {
        System.out.print(name + ", välj sten, sax eller påse: ");
        Choice choice;
        do {
            String input = scanner.next().toLowerCase();
            switch (input) {
                case "sten":
                    choice = Choice.STEN;
                    break;
                case "sax":
                    choice = Choice.SAX;
                    break;
                case "påse":
                    choice = Choice.PÅSE;
                    break;
                default:
                    choice = null;
                    break;
            }
        } while (choice == null);
        return choice;
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
