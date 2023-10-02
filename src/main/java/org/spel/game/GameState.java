package org.spel.game;

import lombok.Getter;
import org.spel.player.HumanPlayer;
import org.spel.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private final List<GameResult> gameHistory;
    @Getter
    private HumanPlayer humanPlayer;
    @Getter
    private Player currentOpponent;
    private final List<Player> opponents;
    @Getter
    private int roundsToWin;

    public GameState(HumanPlayer humanPlayer) {
        this.gameHistory = new ArrayList<>();
        this.humanPlayer = humanPlayer;
        this.opponents = new ArrayList<>();
        this.currentOpponent = null;
        this.roundsToWin = 0;
    }

    public void setRoundsToWin(int roundsToWin) {
        this.roundsToWin = roundsToWin;
    }

    public void setHumanPlayer(HumanPlayer humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public List<GameResult> getGameHistory() {
        return new ArrayList<>(gameHistory);
    }

    public List<Player> getOpponents() {
        return new ArrayList<>(opponents);
    }

    public void setOpponents(List<Player> opponents) {
        this.opponents.clear();
        this.opponents.addAll(opponents);
    }

    public void setCurrentOpponent(Player opponent) {
        this.currentOpponent = opponent;
    }

    public void addGameResult(GameResult gameResult) {
        gameHistory.add(gameResult);

        if (gameResult.getResult().equals(humanPlayer.getName() + " vinner!")) {
            humanPlayer.incrementTotalWins();
        } else if (gameResult.getResult().equals(currentOpponent.getName() + " vinner!")) {
            currentOpponent.incrementTotalWins();
        }
    }
}
