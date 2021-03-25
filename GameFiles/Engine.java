import javax.swing.*;

/* This class runs the main game */
public class Engine {
    public static void main(String[] args) {
        JFrame gameWindow = new JFrame("Light and Sound Game"); // Window name
        GamePanel panel = new GamePanel(); // Window Panel over which game is drawn
        gameWindow.setContentPane(panel);
        panel.addMouseListener(new GameMouse(panel)); // Mouse Listener tracks mouse clicks
        gameWindow.setSize(500, 500); // Sets size of window
        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameWindow.setVisible(true); // Display window
    }
}
