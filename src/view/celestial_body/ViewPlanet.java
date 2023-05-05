package view.celestial_body;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.celestial_body.Planet;

public class ViewPlanet {
    // INSTANCE VARIABLES
    protected final Planet planet;
    protected final BufferedImage[] sprites;

    // CONSTRUCTORS
    public ViewPlanet(Planet planet) throws IOException {
        this.planet = planet;
        BufferedImage spriteSheet = ImageIO.read(new File("assets/planets/" + (planet.isGasGiant() ? "gas/" : "rock/") + planet.getModel()));
        this.sprites = new BufferedImage[16];
        for (int i = 0; i < 16; i++) {
            this.sprites[i] = spriteSheet.getSubimage(i * planet.getWidth(), 0, planet.getWidth(), planet.getHeight());
        }
    }

    public void drawSystem(Graphics2D g2d, int x, int state) {
        System.out.println("Drawing planet at " + x + " with state " + state);
        System.out.println(sprites.length);
        g2d.drawImage(sprites[state], x - 1000, -128/2 + 720/2, 128, 128, null);
    }
}
