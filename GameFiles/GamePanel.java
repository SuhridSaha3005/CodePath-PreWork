import javax.swing.*;
import java.awt.*;

/* This class creates and draws the panel where our game runs */
class GamePanel extends JPanel {

    private final Rectangle[] rectangles; // Array of rectangles in our game
    private static final String START = "Start"; // Text inside Start button
    private static final String STOP = "Stop"; // Text inside Stop button
    private static final String TITLE = "Light and Sound Memory Game"; // Title over game
    private String startStop; // Keeps track of text inside start/stop button

    /* Constructor for GamePanel class */
    public GamePanel() {
        super(); // Since it extends JPanel
        rectangles = new Rectangle[5];
        startStop = START;
        rectangles[0] = new Rectangle(30, 110, 70, 30, Color.GRAY);
        rectangles[1] = new Rectangle(20, 160, 98, 120, Color.RED);
        rectangles[2] = new Rectangle(134, 160, 98, 120, Color.YELLOW);
        rectangles[3] = new Rectangle(248, 160, 98, 120, Color.BLUE);
        rectangles[4] = new Rectangle(362, 160, 98, 120, Color.GREEN);
    }

    /* Changes the color filled inside rectangle at position i of rectangles array */
    public void changeRectColor(int i, Color color) {
        rectangles[i].changeColor(color);
    }

    /* Changes text inside Start/Stop button */
    public void changeText() {
        if (startStop.charAt(2) == 'a') {
            startStop = STOP;
        } else {
            startStop = START;
        }
    }

    /* Paints/Repaints our panel given our instance variables */
    @Override
    public void paintComponent(Graphics g) {
        for (Rectangle rect : rectangles) {
            rect.draw(g);
        }
        g.setFont(new Font("Arial", Font.ITALIC, 25));
        g.setColor(Color.BLACK);
        g.drawString(startStop, 35, 135);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString(TITLE, 35, 70);
    }
}
