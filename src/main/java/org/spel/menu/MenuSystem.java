package org.spel.menu;

import org.spel.game.GameResult;
import org.spel.game.GameState;
import org.spel.player.HumanPlayer;
import org.spel.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSystem implements MenuState {
    private static MenuState activeMenu;
    private static final MenuSystem menuSystem = new MenuSystem();

    private static final GameState gameState;

    static {
        List<GameResult> gameHistory = new ArrayList<>();
        HumanPlayer humanPlayer = createHumanPlayerWithPrompt();

        List<Player> opponents = new ArrayList<>();
        gameState = new GameState(humanPlayer);
        gameState.setOpponents(opponents);

        activeMenu = new MainMenu(gameState);
    }

    private static HumanPlayer createHumanPlayerWithPrompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skapar användare...");
        System.out.println("Vänligen ange ett namn");

        String playerName = scanner.nextLine().trim();

        while (playerName.isEmpty()) {
            System.out.println("Ange ditt namn först.");
            playerName = scanner.nextLine().trim();
        }

        return new HumanPlayer(playerName);
    }

    public static MenuSystem getInstance() {
        return menuSystem;
    }

    public static void setState(MenuState selectedMenu) {
        activeMenu = selectedMenu;
    }

    @Override
    public void execute() {
        activeMenu.execute();
    }


  /*  public static List<GameResult> getGameHistory() {
        return gameState.getGameHistory();
    }

    public static HumanPlayer getHumanPlayer() {
        return gameState.getHumanPlayer();
    }

    public static List<Player> getOpponents() {
        return gameState.getOpponents();
    }

    public static void setGameHistory(List<GameResult> newGameHistory) {
        gameState.getGameHistory().clear();
        gameState.getGameHistory().addAll(newGameHistory);
    }

    public static void setHumanPlayer(HumanPlayer newHumanPlayer) {
        gameState.getHumanPlayer().setName(newHumanPlayer.getName());
    }

    public static void setOpponents(List<Player> newOpponents) {
        gameState.setOpponents(newOpponents);
    }*/
}
