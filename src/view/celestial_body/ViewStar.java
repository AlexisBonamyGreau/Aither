package view.celestial_body;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.celestial_body.Star;

public class ViewStar {
    // CLASS CONSTANTS
    private static final int STAR_SIZE = 2048;

    // INSTANCE VARIABLES
    protected final Star star;
    protected final BufferedImage[] sprites;
    protected Image image;

    // CONSTRUCTORS
    public ViewStar(Star star) throws IOException {
        this.star = star;
        BufferedImage spriteSheet = ImageIO.read(new File("assets/stars/mini/" + star.getModel()));
        this.sprites = new BufferedImage[16];
        for (int i = 0; i < 16; i++) {
            this.sprites[i] = spriteSheet.getSubimage(i * 128, 0, 128, 128);
        }
        this.image = ImageIO.read(new File("assets/stars/normal/" + star.getModel()));
    }

    // GETTERS
    public Star getStar() {
        return star;
    }

    // METHODS
    public void drawGalaxy(java.awt.Graphics2D g2d, int x, int y, int size, int state) {
        g2d.drawImage(sprites[state], x - star.getX() * size, y - star.getY() * size, 16*size, 16*size, null);
    }

    public void drawSystem(java.awt.Graphics2D g2d, int x) {
        g2d.drawImage(image, x - 1000, -STAR_SIZE/2 + 720/2, STAR_SIZE, STAR_SIZE, null);
    }

    public void setX(int x) {
        star.setX(x);
    }

    public void setY(int y) {
        star.setY(y);
    }

    public boolean isClicked(int x, int y, int i, int j, int size) {
        return (x >= i - star.getX() * size && x <= i - star.getX() * size + 16*size && y >= j - star.getY() * size && y <= j - star.getY() * size + 16*size);
    }
}
