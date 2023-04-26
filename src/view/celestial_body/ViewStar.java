package view.celestial_body;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.celestial_body.Star;

public class ViewStar {
    // INSTANCE VARIABLES
    protected final Star star;
    protected final BufferedImage[] sprites;

    // CONSTRUCTORS
    public ViewStar(Star star) throws IOException {
        this.star = star;
        BufferedImage spriteSheet = ImageIO.read(new File("assets/stars/mini/" + star.getModel()));
        this.sprites = new BufferedImage[16];
        for (int i = 0; i < 16; i++) {
            this.sprites[i] = spriteSheet.getSubimage(i * 128, 0, 128, 128);
        }
    }

    // GETTERS
    public Star getStar() {
        return star;
    }

    // METHODS
    public void draw(java.awt.Graphics2D g2d, int x, int y, int size, int state) {
        g2d.drawImage(sprites[state], x - star.getX() * size, y - star.getY() * size, 16*size, 16*size, null);
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
