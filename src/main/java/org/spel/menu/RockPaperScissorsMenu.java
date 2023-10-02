package org.spel.menu;

import org.spel.game.GameState;
import org.spel.game.RockPaperScissorsGame;
import org.spel.player.Player;

import java.util.List;

public class RockPaperScissorsMenu extends Menu {
    private final RockPaperScissorsGame game;
    private final GameState gameState;

    public RockPaperScissorsMenu(GameState gameState) {
        super("Rock-Paper-Scissors");
        this.gameState = gameState;
        this.game = new RockPaperScissorsGame(gameState);
        menuOptions = List.of(
                new MenuOption(1, "Spela Rock-Paper-Scissors", this::playRockPaperScissors),
                new MenuOption(2, "Gå tillbaka till huvudmenyn", this::goBackToMainMenu)
        );
    }

    private void playRockPaperScissors() {
        game.playGame();
    }

    private void goBackToMainMenu() {
        MenuSystem.setState(new MainMenu(gameState));
    }

}
