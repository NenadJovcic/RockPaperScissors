package org.spel;

import org.spel.menu.MenuSystem;
import org.spel.player.NamedComputerPlayer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Startar Spelet ...");

        MenuSystem menuSystem = MenuSystem.getInstance();
        while (true) {
            menuSystem.execute();
        }
    }
}
