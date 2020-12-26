import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public abstract class DrawableImage extends DrawableItem {

    private Image image;

    private int height;

    private int width;

    private boolean flipHoriz = false;

    private boolean flipVert = false;

    public DrawableImage(DrawingPanel drawArea, String imageFile, int width, int height) {

        // Set the drawing panel using DrawableItem's constructor
        super(drawArea);

        // Set the image at imageFile
        Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
        this.setImage(image);

        // Set the height and width of the rendered image (not the image's raw width and height)
        this.setHeight(height);
        this.setWidth(width);
    }

    public void draw(Graphics g) {

        // If you are wondering how "flipping" works here, check out:
        // http://www.javaworld.com/javaworld/javatips/jw-javatip32.html

        int dx1, dy1, dx2, dy2;

        if (this.flipHoriz) {
            dx1 = this.getX() + this.getWidth();
            dx2 = this.getX();
        } else {
            dx1 = this.getX();
            dx2 = this.getX() + this.getWidth();
        }

        if (this.flipVert) {
            dy1 = this.getY() + this.getHeight();
            dy2 = this.getY();
        } else {
            dy1 = this.getY();
            dy2 = this.getY() + this.getHeight();
        }

        g.drawImage(getImage(),
                dx1, dy1, dx2, dy2,
                0 , 0, this.getImage().getWidth(null), this.getImage().getHeight(null),
                null);
    }

    public void horizontalFlip() {
        this.flipHoriz = !this.flipHoriz;
    }

    public void verticalFlip() {
        this.flipVert = !this.flipVert;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
