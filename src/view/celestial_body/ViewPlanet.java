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
        System.out.println("assets/planets/" + (planet.isGasGiant() ? "gas/" : "rock/") + planet.getModel());
        BufferedImage spriteSheet = ImageIO.read(new File("assets/planets/" + (planet.isGasGiant() ? "gas/" : "rock/") + planet.getModel()));
        this.sprites = new BufferedImage[16];
        for (int i = 0; i < 16; i++) {
            this.sprites[i] = spriteSheet.getSubimage(i * planet.getWidth(), 0, planet.getWidth(), planet.getHeight());
        }
    }

    public void draw(Graphics2D g2d, int state) {
        g2d.drawImage(sprites[state], planet.getX(), planet.getY(), 128, 128, null);
    }
}
