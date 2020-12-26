import java.util.Random;

public class Fish extends DrawableImage {

    private int speed;
    private int size;
    private boolean movingRight;
    private boolean movingUp;

    public Fish(DrawingPanel drawArea, String imageFile, int speed, boolean facingRight, boolean facingUp) {

        // Uses the constructor to DrawableImage to set the area, image, and image dimensions
        // to use while drawing
        super(drawArea, imageFile, 60, 40);

        // Set the fish speed
        this.setSpeed(speed);

        // Does the initial graphic show the fish facing right? If so, let the fish start
        // out moving in that direction
        this.setMovingRight(facingRight);

        this.setMovingUp(facingUp);

        this.size = 44; // Default size for fish
    }

    public void initialize() {

        int xPos, yPos;

        // This finds a random y coordinate to place the fish so that it is
        // not too high or too low
        Random rand = new Random();
        yPos = rand.nextInt(this.getWindowHeight() - this.getHeight());

        // If the fish starts moving right, start the fish at the left edge
        if (isMovingRight()) {
            xPos = 0;

            // Otherwise, start the fish at the right edge of the window
        } else {
            xPos = this.getWindowWidth() - this.getWidth();
        }

        // Set the x, y coordinates
        this.setX(xPos);
        this.setY(yPos);
    }

    public void moveOneStep() {
        // Horizontal animations
        int nextX = 0;

        if (this.isMovingRight()) {
            nextX += this.getX() + this.getSpeed();
        } else {
            nextX += this.getX() - this.getSpeed();
        }

        if (nextX + this.getSpeed() + this.getSize() > this.getWindowWidth() || nextX - this.getSpeed() < 0)
            reverseHorizontalDirection();


        // Vertical animations
        int nextY = 0;
        int verticalSpeed = this.getSpeed()/3;

        if (this.isMovingUp()) {
            nextY += this.getY() - verticalSpeed;
        } else {
            nextY += this.getY() + verticalSpeed;
        }

        if (nextY + verticalSpeed + this.getSize() > this.getWindowHeight() || nextY - verticalSpeed <= 0)
            reverseVerticalDirection();

        this.setX(nextX);
        this.setY(nextY);
    }

    protected void reverseHorizontalDirection() {

        // Flips the image to be rendered
        this.horizontalFlip();

        // Now change the direction of movement
        boolean movingRight = this.isMovingRight();
        this.setMovingRight(!movingRight);
    }

    protected void reverseVerticalDirection() {
        boolean movingUp = this.isMovingUp();
        this.setMovingUp(!movingUp);
    }

    public int getSpeed() {
        return speed;
    }

    public int getSize() { return size; }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public boolean isMovingUp() { return movingUp; }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

}
