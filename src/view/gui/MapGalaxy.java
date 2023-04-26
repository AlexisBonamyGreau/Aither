package view.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import controller.tools.AitherTool;
import model.celestial_body.Galaxy;
import view.celestial_body.ViewBlackHole;
import view.celestial_body.ViewStar;

public class MapGalaxy extends JPanel {
    // CLASS CONSTANTS
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;
    public static final int BG_SCALE = 4096;

    // INSTANCE VARIABLES
    private Galaxy galaxy;
    private Image background;
    private int state;
    private int x;
    private int y;
    private int size;

    // CONSTRUCTORS
    public MapGalaxy(int width, int height, Galaxy galaxy) throws IOException {
        this.x = 0;
        this.y = 0;
        this.size = 4;
        this.state = 0;

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(java.awt.Color.BLACK);

        this.galaxy = galaxy;

        this.background = javax.imageio.ImageIO.read(new File("assets/bg.jpg"));
    }

    // GETTERS
    public Galaxy getGalaxy() {
        return galaxy;
    }

    // SETTERS

    // METHODS
    @Override
    public void paintComponent(java.awt.Graphics g) {
        correctPosition();

        super.paintComponent(g);
        int bgX = (this.x + WIDTH/2) / 2 - BG_SCALE*size / 2;
        int bgY = (this.y + HEIGHT/2) / 2 - BG_SCALE*size / 2;
        int width = BG_SCALE*size;
        int height = BG_SCALE*size;
        g.drawImage(background, bgX+3000, bgY, width, height, null);
        g.drawImage(background, bgX, bgY, width, height, null);
        for (ViewStar star : galaxy.getViewStars()) {
            star.draw((java.awt.Graphics2D) g, x+WIDTH/2, y+HEIGHT/2, size, state);
        }
        ViewBlackHole blackHole = galaxy.getViewBlackHole();
        blackHole.draw((java.awt.Graphics2D) g, x+WIDTH/2, y+HEIGHT/2, size, state);
    }

    public void updateState() {
        state = (state + 1) % 16;
        repaint();
    }

    public void associateTool(AitherTool tool) {
        tool.setMapGalaxy(this);
        this.addMouseListener(tool);
        this.addMouseMotionListener(tool);
        this.addMouseWheelListener(tool);
    }

    public void dissociateTool(AitherTool tool) {
        this.removeMouseListener(tool);
        this.removeMouseMotionListener(tool);
        this.removeMouseWheelListener(tool);
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void resize(double size, int x, int y) {
        if (this.size * size < 1 || this.size * size > 32) {
            return;
        }
        
        // System.out.println("x: " + x + " y: " + y);
        // System.out.println("this.x: " + this.x + " this.y: " + this.y);
        
        this.x = (int) (this.x * size - x * (size));
        this.y = (int) (this.y * size - y * (size));

        this.size = (int) (this.size * size);
        repaint();
    }

    public void click(int x, int y) {
        for (ViewStar star : galaxy.getViewStars()) {
            if (star.isClicked(x, y, this.x+WIDTH/2, this.y+HEIGHT/2, size)) {
                System.out.println("Star clicked");
                System.out.println(star.getStar().toString());
            }
        }
    }

    public void correctPosition() {
        if (x < -2500*size) {  x = -2500*size; } else if (x > 2500*size) { x = 2500*size; }
        if (y < -2500*size) { y = -2500*size; } else if (y > 2500*size) { y = 2500*size; }
    }
}
