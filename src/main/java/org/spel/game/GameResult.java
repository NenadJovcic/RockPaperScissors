package org.spel.game;

public class GameResult {
    private String playerName;
    private String opponentName;
    private String playerChoice;
    private String opponentChoice;
    private String result;

    private GameResult() {
    }

    public static class Builder {
        private String playerName;
        private String opponentName;
        private String playerChoice;
        private String opponentChoice;
        private String result;

        public Builder() {
        }

        public Builder playerName(String playerName) {
            this.playerName = playerName;
            return this;
        }

        public Builder opponentName(String opponentName) {
            this.opponentName = opponentName;
            return this;
        }

        public Builder playerChoice(String playerChoice) {
            this.playerChoice = playerChoice;
            return this;
        }

        public Builder opponentChoice(String opponentChoice) {
            this.opponentChoice = opponentChoice;
            return this;
        }

        public Builder result(String result) {
            this.result = result;
            return this;
        }

        public GameResult build() {
            GameResult gameResult = new GameResult();
            gameResult.playerName = this.playerName;
            gameResult.opponentName = this.opponentName;
            gameResult.playerChoice = this.playerChoice;
            gameResult.opponentChoice = this.opponentChoice;
            gameResult.result = this.result;
            return gameResult;
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(String playerChoice) {
        this.playerChoice = playerChoice;
    }

    public String getOpponentChoice() {
        return opponentChoice;
    }

    public void setOpponentChoice(String opponentChoice) {
        this.opponentChoice = opponentChoice;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GameResult{" + "playerName='" + playerName + '\'' + ", opponentName='" + opponentName + '\'' + ", playerChoice='" + playerChoice + '\'' + ", opponentChoice='" + opponentChoice + '\'' + ", result='" + result + '\'' + '}';
    }
}

