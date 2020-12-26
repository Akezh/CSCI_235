import java.awt.Graphics;


public abstract class DrawableItem {

    private int x;
    private int y;

    private DrawingPanel drawArea;

    public DrawableItem(DrawingPanel drawArea) {
        setDrawArea(drawArea);
    }

    public abstract void initialize();

    public abstract void draw(Graphics g);

    public abstract void moveOneStep();

    public int getWindowWidth() {
        return this.getDrawArea().getWidth();
    }

    public int getWindowHeight() {
        return this.getDrawArea().getHeight();
    }

    private DrawingPanel getDrawArea() {
        return drawArea;
    }

    private void setDrawArea(DrawingPanel drawArea) {
        this.drawArea = drawArea;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
