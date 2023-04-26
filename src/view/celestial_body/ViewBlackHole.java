package view.celestial_body;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.celestial_body.BlackHole;

public class ViewBlackHole {
    // INSTANCE VARIABLES
    protected final BlackHole blackHole;
    protected final BufferedImage[] sprites;

    // CONSTRUCTORS
    public ViewBlackHole(BlackHole blackHole) throws IOException {
        this.blackHole = blackHole;
        BufferedImage spriteSheet = ImageIO.read(new File(blackHole.getModel()));
        this.sprites = new BufferedImage[16];
        for (int i = 0; i < 16; i++) {
            this.sprites[i] = spriteSheet.getSubimage(i * 512, 0, 512, 512);
        }
    }

    public void draw(java.awt.Graphics2D g2d, int x, int y, int size, int state) {
        g2d.drawImage(sprites[state], x - blackHole.getX() * size, y - blackHole.getY() * size, 64*size, 64*size, null);
    }
}
