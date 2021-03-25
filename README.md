# CodePath-PreWork
Pre Work assignment for CodePath. The file "Engine.java" runs a Light and Sound Memory game. <br />
It plays keys in a sequence- only some at a time, and revealing a new key with every turn. <br />
If you click a wrong key, you lose. If you survive for 8 turns, you win.

## Controls
Click on any key to play corresponding sound. Press "Start" to start game and "Stop" to end game. <br />
It prints "Game Over!" and "You Won!" in the Java executive tab/terminal.

## Files
* Engine.java = Main engine for game. Runs in main method
* GameMouse.java (extends java.awt.event.MouseAdapter) = Uses Mouse clicks to update game status
* GamePanel.java (extends javax.swing.JPanel) = Draws/creates game panel where you see everything
* Piano.java = Used to play the keys either during game or when user clicks them
* Rectangle.java = Draws/creates rectangles for the game
