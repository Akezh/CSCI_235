import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Bubble extends DrawableItem {

    private int size;
    private int speed;

    public Bubble(DrawingPanel drawArea, int size, int speed) {

        // Set the drawing panel using DrawableItem's constructor
        super(drawArea);

        // Set size and speed
        setSize(size);
        setSpeed(speed);
    }

    public void initialize() {
        int xPos, yPos;

        // Set the initial x coordinate to some random value that keeps it
        // inside of the window
        Random rand = new Random();
        xPos = rand.nextInt(this.getWindowWidth() - this.getSize());

        // Start the bubble at the very bottom of the screen
        yPos = this.getWindowHeight() - this.getSize();

        // Set the x, y coordinates
        this.setX(xPos);
        this.setY(yPos);
    }

    public void moveOneStep() {
        int nextY = 0;

        nextY = this.getY() - this.getSpeed();

        if (nextY <= 0 - this.getSize()) {
            Random rand = new Random();
            int nextX = rand.nextInt(this.getWindowWidth() - this.getSize());
            this.setX(nextX);
            nextY = this.getWindowHeight() - this.getSize();
        }

        this.setY(nextY);
    }

    public void draw(Graphics g) {

        // Draw a dark gray circle with diameter = size
        g.setColor(Color.DARK_GRAY);
        g.drawOval(this.getX(), this.getY(), this.getSize(), this.getSize());
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
