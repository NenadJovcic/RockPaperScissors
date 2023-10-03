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
        HumanPlayer humanPlayer = createHumanPlayerWithPrompt();
        gameState = new GameState(humanPlayer);
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


}
