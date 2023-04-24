package view.gui;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import model.celestial_body.Planet;
import view.celestial_body.ViewPlanet;

public class MapGalaxy extends JPanel {
    // CLASS CONSTANTS
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;

    // INSTANCE VARIABLES
    private ViewPlanet planet;

    // CONSTRUCTORS
    public MapGalaxy(int width, int height) throws IOException {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(java.awt.Color.BLACK);

        Planet planet = new Planet(0, 0, false);
        this.planet = new ViewPlanet(planet);
    }

    // GETTERS
    public ViewPlanet getPlanet() {
        return planet;
    }

    // SETTERS
    public void setPlanet(ViewPlanet planet) {
        this.planet = planet;
    }

    // METHODS
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        planet.draw((java.awt.Graphics2D) g);
    }
}
