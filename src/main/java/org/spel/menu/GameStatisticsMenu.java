package org.spel.menu;

import org.spel.game.GameResult;
import org.spel.game.GameState;
import org.spel.player.HumanPlayer;
import org.spel.player.Player;

import java.text.DecimalFormat;
import java.util.List;


public class GameStatisticsMenu extends Menu {
    private final GameState gameState;
    private final List<GameResult> gameHistory;

    public GameStatisticsMenu(GameState gameState) {
        super("SpelHistorik - Meny");
        this.gameState = gameState;
        this.gameHistory = gameState.getGameHistory();

        menuOptions = List.of(
                new MenuOption(1, "Visa spelhistorik", this::displayGameHistory),
                new MenuOption(2, "Visa spelarstatistik", this::displayPlayerStatistics),
                new MenuOption(3, "Gå till huvudmenyn", () -> MenuSystem.setState(new MainMenu(gameState)))
        );
    }

    private void displayGameHistory() {
        System.out.println("\nSpelhistorik:");
        int count = 0;
        for (GameResult result : gameHistory) {
            count++;
            System.out.println("Runda: " + count + ": " + result.getPlayerName() + " valde " + result.getPlayerChoice() + ", " + result.getOpponentName() + " valde " + result.getOpponentChoice() + " - " + result.getResult());
        }
    }

    private void displayPlayerStatistics() {
        if (gameState == null || gameHistory == null) {
            return;
        }
        HumanPlayer humanPlayer = gameState.getHumanPlayer();
        List<Player> opponents = gameState.getOpponents();

        int totalPlayerWins = humanPlayer.getTotalWins();
        int totalRounds = gameHistory.size();

        System.out.println("\nStatistik för " + humanPlayer.getName() + ":");
        System.out.println("Totala vinster: " + totalPlayerWins);
        System.out.println("Totala rundor spelade: " + totalRounds);

        DecimalFormat df = new DecimalFormat("0.00%");

        // Calculate and display the percentage of rounds won by the user
        double winPercentage = (double) totalPlayerWins / totalRounds;
        System.out.println("Andel vinster av alla matcher: " + df.format(winPercentage));

        // Calculate and display statistics for each opponent
        for (Player opponent : opponents) {
            List<GameResult> opponentResults = gameHistory.stream().filter(gr -> gr.getOpponentName().equals(opponent.getName())).toList();
            int opponentWins = opponentResults.stream().mapToInt(gr -> {
                if (gr.getResult().equals(opponent.getName() + " vinner!")) {
                    return 1;
                } else {
                    return 0;
                }
            }).sum();
            int opponentGames = opponentResults.size();

            // Calculate and display the percentage of matches won against each opponent type
            double opponentWinPercentage = opponentGames > 0 ? (double) opponentWins / opponentGames : 0.0;
            String opponentWinPercentageStr = opponentGames > 0 ? df.format(opponentWinPercentage) : "Inte Spelat";
            System.out.println(opponent.getName() + " rundor vunna mot " + humanPlayer.getName() + ": " + opponentWins + " (" + opponentWinPercentageStr + ")");
            System.out.println("Rundor spelade mot " + opponent.getName() + ": " + opponentGames);
        }
    }

}
