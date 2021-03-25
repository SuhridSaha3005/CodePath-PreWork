package GameFiles;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* This class tracks mouse clicks */
class GameMouse extends MouseAdapter {

    private final GamePanel panel; // Window panel that draws everything
    private final Piano piano; // Plays the musical/colored keys for the game
    private boolean gameOn; // True if game is being played, else false
    private String code; // The string of keys for current game
    private boolean playerTurn; // True if player can play keys, else false
    private int turn; // Turn number, 1 when game begins, until 8
    private String playerInput; // Keeps track of the keys clicked by player

    /* Constructor for Mouse click tracker */
    public GameMouse(GamePanel panel) {
        super(); // Since it extends MouseAdapter
        this.panel = panel;
        this.piano = new Piano(panel);
        this.gameOn = false;
        this.playerTurn = true;
        this.turn = 0;
    }

    /* If mouse is clicked, this method makes required change */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (contains(e.getX(), 30, 100) && contains(e.getY(),110, 140)) {
            if (gameOn) {
                endGame();
            } else {
                startGame();
            }
            return;
        }
        if (!playerTurn) {
            return;
        }
        if (contains(e.getX(), 20, 118) && contains(e.getY(), 160, 280)) {
            piano.play(1);
            updatePlayerInput(1);
        } else if (contains(e.getX(), 134, 232) && contains(e.getY(), 160, 280)) {
            piano.play(2);
            updatePlayerInput(2);
        } else if (contains(e.getX(), 248, 346) && contains(e.getY(), 160, 280)) {
            piano.play(3);
            updatePlayerInput(3);
        } else if (contains(e.getX(), 362, 460) && contains(e.getY(), 160, 280)) {
            piano.play(4);
            updatePlayerInput(4);
        }
    }

    /* Checks if integer n is between integers low and high (both exclusive) */
    private boolean contains(int n, int low, int high) {
        return n > low && n < high;
    }

    /* Updates all game features to initial state */
    private void startGame() {
        panel.changeText();
        panel.repaint();
        gameOn = true;
        code = setRandomCode();
        playerInput = "";
        computerTurn();
    }

    /* Ends game and returns everything to initial state */
    private void endGame() {
        panel.changeText();
        panel.repaint();
        gameOn = false;
        code = null;
        playerTurn = true;
        turn = 0;
        playerInput = null;
    }

    /* Updates keys entered by player */
    /* If keys different from code, then game over */
    /* If all turns over then player wins */
    private void updatePlayerInput(int key) {
        if (!gameOn) {
            return;
        }
        playerInput += key;
        int l = playerInput.length();
        if (playerInput.charAt(l - 1) != code.charAt(l - 1)) {
            System.out.println("Game Over!");
            endGame();
        } else if (l == 8) {
            System.out.println("You Won!");
            endGame();
        } else if (l == turn) {
            playerInput = "";
            computerTurn();
        }
    }

    /* This method sets the code (string of keys) at the beginning of the game */
    private String setRandomCode() {
        StringBuilder code = new StringBuilder();
        int k;
        for (int i = 0; i < 8; i += 1) {
            k = StdRandom.uniform(1, 5);
            code.append(k);
        }
        return code.toString();
    }

    /* Plays substrings of the code in the current game at every turn */
    private void computerTurn() {
        playerTurn = false;
        int i = 0;
        int j;
        Stopwatch sw;
        while (i <= turn) {
            j = code.charAt(i) - 48;
            piano.play(j);
            sw = new Stopwatch();
            while (sw.elapsedTime() < 0.2) {} // Pauses for 0.2 second
            i += 1;
        }
        sw = new Stopwatch();
        while (sw.elapsedTime() < 0.5) {} // Pauses for 0.5 second
        turn += 1;
        playerTurn = true;
    }
}
