package ru.vsu.marbles;

import java.awt.*;

public class Game {

    private final Player[] players = new Player[2];

    public Game() {
        players[0] = new Player("Player 1", Color.BLACK);
        players[1] = new Player("Player 2", Color.BLUE);
    }

    public void startGame() {
        int currentPlayer = 0;
        int nextPlayer = (currentPlayer + 1) % 2;
        do {
            printScore();
            MarbleGuess guess = players[currentPlayer].makeStake();
            players[nextPlayer].makeStake();
            if (players[nextPlayer].guess(guess) ) {
                players[currentPlayer].giveBalls(players[nextPlayer].takeBalls());
            } else {
                players[nextPlayer].giveBalls(players[currentPlayer].takeBalls());
            }
            currentPlayer = (currentPlayer + 1) % 2;
            nextPlayer = (currentPlayer + 1) % 2;
        } while (!gameIsOver());
        printScore ();
    }

    private void printScore() {
        for (int i = 0; i < 2; i++) {
            System.out.println(players[i]);
        }
    }

    private boolean gameIsOver() {
        return players[0].getBallsCount() == 0 || players[1].getBallsCount() == 0;
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.startGame();
    }

}