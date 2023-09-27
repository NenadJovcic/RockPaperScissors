package org.spel.menu;

public class MenuOption {
    private int optionNumber;
    private String text;
    private Runnable action;

    public MenuOption(int optionNumber, String text, Runnable action) {
        this.optionNumber = optionNumber;
        this.text = text;
        this.action = action;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getText() {
        return text;
    }

    public void run() {
        action.run();
    }
}
