package org.spel.menu;

import org.spel.game.GameResult;
import org.spel.game.GameState;
import org.spel.game.RockPaperScissorsGame;
import org.spel.player.HumanPlayer;
import org.spel.player.Player;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu implements MenuState {
    private static final Scanner scanner = new Scanner(System.in);


    public MainMenu(GameState gameState) {
        super("HuvudMeny");

        menuOptions = List.of(
                new MenuOption(1, "SpelMeny ->", () -> MenuSystem.setState(new RockPaperScissorsMenu(gameState))),
                new MenuOption(2, "HistorikMeny ->",
                        () -> MenuSystem.setState(new GameStatisticsMenu(gameState))),
                new MenuOption(3, "Quit", () -> System.exit(0))
        );
    }
}
