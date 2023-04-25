package view.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import model.celestial_body.Star;
import view.celestial_body.ViewStar;

public class MapGalaxy extends JPanel {
    // CLASS CONSTANTS
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;

    // INSTANCE VARIABLES
    private ViewStar star;
    private Image background;

    // CONSTRUCTORS
    public MapGalaxy(int width, int height) throws IOException {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(java.awt.Color.BLACK);

        Star star = new Star(150, 200);
        this.star = new ViewStar(star);

        this.background = javax.imageio.ImageIO.read(new File("assets/bg.jpg"));
    }

    // GETTERS
    public ViewStar getViewStar() {
        return star;
    }

    // SETTERS
    public void setStar(ViewStar star) {
        this.star = star;
    }

    // METHODS
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 10000, 10000, null);
        star.draw((java.awt.Graphics2D) g);
    }
}
