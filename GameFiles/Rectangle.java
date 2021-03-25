import java.awt.*;

/* This class creates and draws rectangles on the game Panel */
class Rectangle {
    private final int x; // TopLeft x-coordinate of Rectangle
    private final int y; // TopLeft y-coordinate of Rectangle
    private final int width; // Width of Rectangle
    private final int height; // Height of Rectangle
    private Color color; // Color filled in Rectangle

    /* Constructor for Rectangle class */
    public Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /* Changes color filled within rectangle */
    /* Required for playing keys */
    public void changeColor(Color color) {
        this.color = color;
    }

    /* This Method draws out our rectangle */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
