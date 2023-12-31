package org.spel.game;

import org.spel.player.HumanPlayer;
import org.spel.player.Player;
import org.spel.player.RandomComputerPlayer;
import org.spel.player.TimeBasedComputerPlayer;
import org.spel.player.NamedComputerPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private final Scanner scanner = new Scanner(System.in);
    private final GameState gameState;



    public RockPaperScissorsGame(GameState gameState) {
        this.gameState = gameState;
    }

    public void playGame() {
        setupGame();
        playMatches();
    }

    private void setupGame() {
        setRoundsToWin();
        createOpponents();
        selectOpponent();
    }


    private void setRoundsToWin() {
        System.out.print("Ange antal vinster som krävs för att vinna spelet: ");
        int roundsToWin = scanner.nextInt();
        gameState.setRoundsToWin(roundsToWin);
    }

    private void createOpponents() {
        List<Player> opponents = new ArrayList<>();
        opponents.add(new RandomComputerPlayer());
        opponents.add(new TimeBasedComputerPlayer());
        opponents.add(new NamedComputerPlayer(gameState.getHumanPlayer().getName()));
        gameState.setOpponents(opponents);
    }

    private void selectOpponent() {
        System.out.println("Välj en motståndare:");
        List<Player> opponents = gameState.getOpponents();
        for (int i = 0; i < opponents.size(); i++) {
            System.out.println((i + 1) + ". " + opponents.get(i).getName());
        }

        int choice;
        do {
            System.out.print("Ange numret för ditt val: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > opponents.size());

        gameState.setCurrentOpponent(opponents.get(choice - 1));
    }

    private void playMatches() {
        HumanPlayer humanPlayer = gameState.getHumanPlayer();
        Player currentOpponent = gameState.getCurrentOpponent();
        int roundsToWin = gameState.getRoundsToWin();

        int playerWins = 0;
        int opponentWins = 0;


        while (playerWins < roundsToWin && opponentWins < roundsToWin) {
            Choice playerChoice = humanPlayer.makeMove();
            Choice opponentChoice = currentOpponent.makeMove();

            String result = determineWinner(playerChoice, opponentChoice, humanPlayer, currentOpponent);
            System.out.println(result);

            GameResult gameResult = new GameResult.Builder()
                    .playerName(humanPlayer.getName())
                    .opponentName(currentOpponent.getName())
                    .playerChoice(playerChoice)
                    .opponentChoice(opponentChoice)
                    .result(result)
                    .build();

            gameState.addGameResult(gameResult);

            if (result.equals(humanPlayer.getName() + " vinner!")) {
                playerWins++;
            } else if (result.equals(currentOpponent.getName() + " vinner!")) {
                opponentWins++;
            }
        }

        System.out.println("Matchen avslutades med att " + humanPlayer.getName() + " hade " + playerWins + " vinster och " + currentOpponent.getName() + " hade " + opponentWins + " vinster.");
    }

    private String determineWinner(Choice playerChoice, Choice opponentChoice, HumanPlayer player, Player opponent) {
        if (playerChoice == opponentChoice) {
            return "Oavgjort!";
        }

        boolean playerWins = (playerChoice == Choice.STEN && opponentChoice == Choice.SAX) ||
                (playerChoice == Choice.SAX && opponentChoice == Choice.PÅSE) ||
                (playerChoice == Choice.PÅSE && opponentChoice == Choice.STEN);

        if (playerWins) {
            return player.getName() + " vinner!";
        } else {
            return opponent.getName() + " vinner!";
        }
    }
}
